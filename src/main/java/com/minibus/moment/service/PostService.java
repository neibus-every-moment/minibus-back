package com.minibus.moment.service;

import com.minibus.moment.domain.image.Image;
import com.minibus.moment.domain.image.ImageRepository;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.region.RegionRepository;
import com.minibus.moment.domain.report.*;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.domain.transportation.TransportationRepository;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.post.CreatePost;
import com.minibus.moment.dto.post.GetPostList;
import com.minibus.moment.dto.post.PostDto;
import com.minibus.moment.dto.post.ReportRequest;
import com.minibus.moment.dto.report.ReportReasonDto;
import com.minibus.moment.exception.MinibusException;
import com.minibus.moment.service.uploader.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.minibus.moment.exception.MinibusErrorCode.*;
import static com.minibus.moment.type.ReportStatus.BEFORE;
import static com.minibus.moment.type.Status.VISIBLE;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final TransportationRepository transportRepository;
    private final RegionRepository regionRepository;
    private final ImageRepository imageRepository;
    private final UserRepository userRepository;

    private final ReportRepository reportRepository;
    private final ReportReasonRepository reportReasonRepository;
    private final ReportEtcDetailRepository reportEtcDetailRepository;
    private final S3Uploader s3Uploader;

    public List<ReportReasonDto> getReportReasonList() {
        return reportReasonRepository.findAll().stream()
                .map(ReportReasonDto::from)
                .collect(Collectors.toList());
    }

    public List<PostDto> getPostList(GetPostList.Request request) {

        List<Post> postList = new ArrayList<>();
        List<String> transportationNameList = request.getTransportations();
        List<String> regionNameList = request.getRegions();
        PageRequest pageRequest = PageRequest.of(
                request.getStart(),
                request.getSize(),
                Sort.by(Sort.Direction.DESC, request.getSorting()));

        if (ObjectUtils.isEmpty(transportationNameList) && ObjectUtils.isEmpty(regionNameList)) {
            postList = postRepository.findAllByStatus(
                    VISIBLE, pageRequest);
        } else if (!ObjectUtils.isEmpty(transportationNameList) && !ObjectUtils.isEmpty(regionNameList)) {
            List<Transportation> transportationList = mapToTransportation(transportationNameList);
            List<Region> regionList = mapToRegion(regionNameList);
            postList = postRepository.findAllByStatusAndTransportationIsInAndRegionIsIn(
                    VISIBLE, transportationList, regionList, pageRequest
            );
        } else if (!ObjectUtils.isEmpty(transportationNameList) && ObjectUtils.isEmpty(regionNameList)) {
            List<Transportation> transportationList = mapToTransportation(transportationNameList);
            postList = postRepository.findAllByStatusAndTransportationIsIn(
                    VISIBLE, transportationList, pageRequest
            );
        } else if (ObjectUtils.isEmpty(transportationNameList) && !ObjectUtils.isEmpty(regionNameList)) {
            List<Region> regionList = mapToRegion(regionNameList);
            postList = postRepository.findAllByStatusAndRegionIsIn(
                    VISIBLE, regionList, pageRequest
            );
        }
        return postList.stream().map(PostDto::from).collect(Collectors.toList());
    }

    public List<PostDto> getPostListByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new MinibusException(USER_NOT_FOUND)
        );
        return postRepository.findAllByUser(user).stream()
                .map(PostDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long updatePost(Long postId, String content) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new MinibusException(POST_NOT_FOUND)
        );
        return post.update(content);
    }

    @Transactional
    public boolean deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new MinibusException(POST_NOT_FOUND)
        );
        postRepository.delete(post);
        return true;
    }

    @Transactional
    public boolean reportPost(Long postId, ReportRequest request) {
        ReportReason reportReason = reportReasonRepository.findByContent(request.getReportReason())
                .orElseThrow(() -> new MinibusException(REPORT_REASON_NOT_FOUND)
                );
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new MinibusException(POST_NOT_FOUND)
                );

        Report report = Report.builder()
                .reportReason(reportReason)
                .post(post)
                .reportStatus(BEFORE)
                .build();
        reportRepository.save(report);

        if (!ObjectUtils.isEmpty(request.getDetail())) {
            ReportEtcDetail reportEtcDetail = ReportEtcDetail.builder()
                    .report(report)
                    .content(request.getDetail())
                    .build();
            reportEtcDetailRepository.save(reportEtcDetail);
        }
        return true;
    }

    @Transactional
    public Long createPost(List<MultipartFile> multipartFileList, CreatePost.Request request) {
        Region region = regionRepository.findByName(request.getRegion())
                .orElseThrow(() -> new MinibusException(REGION_NOT_FOUND)
                );
        Transportation transportation = transportRepository.findByName(request.getTransportation())
                .orElseThrow(() -> new MinibusException(TRANSPORTATION_NOT_FOUND)
                );

        User user = userRepository.findById(request.getUserId()).orElseThrow(
                () -> new MinibusException(USER_NOT_FOUND)
        );
        Post post = Post.builder()
                .user(user)
                .content(request.getContent())
                .region(region)
                .transportation(transportation)
                .status(VISIBLE)
                .build();
        postRepository.save(post);

        try {
            for (MultipartFile file : multipartFileList) {
                Image saveImage = Image.builder()
                        .path(s3Uploader.upload(file, file.getOriginalFilename()))
                        .post(post)
                        .build();
                imageRepository.save(saveImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return post.getId();
    }

    public PostDto getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new MinibusException(POST_NOT_FOUND));
        return PostDto.from(post);
    }

    public List<Transportation> mapToTransportation(List<String> list) {
        return list.stream().map(
                t -> transportRepository.findByName(t).orElseThrow(
                        () -> new MinibusException(TRANSPORTATION_NOT_FOUND)
                )
        ).collect(Collectors.toList());
    }

    public List<Region> mapToRegion(List<String> list) {
        return list.stream().map(
                r -> regionRepository.findByName(r).orElseThrow(
                        () -> new MinibusException(REGION_NOT_FOUND)
                )
        ).collect(Collectors.toList());
    }
}
