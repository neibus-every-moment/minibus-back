package com.minibus.moment.service;

import com.minibus.moment.domain.image.Image;
import com.minibus.moment.domain.image.ImageRepository;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.region.RegionRepository;
import com.minibus.moment.domain.report.Report;
import com.minibus.moment.domain.report.ReportRepository;
import com.minibus.moment.domain.reportEtcDetail.ReportEtcDetail;
import com.minibus.moment.domain.reportEtcDetail.ReportEtcDetailRepository;
import com.minibus.moment.domain.reportReason.ReportReason;
import com.minibus.moment.domain.reportReason.ReportReasonRepository;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.domain.transportation.TransportationRepository;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.PostDto;
import com.minibus.moment.dto.ReportReasonDto;
import com.minibus.moment.dto.api.CreatePost;
import com.minibus.moment.dto.api.GetPostList;
import com.minibus.moment.dto.api.ReportPost;
import com.minibus.moment.exception.PostNotFoundException;
import com.minibus.moment.exception.RegionNotFoundException;
import com.minibus.moment.exception.ReportReasonNotFoundException;
import com.minibus.moment.exception.TransportationNotFoundException;
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

    public List<PostDto> getPostListByUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                // 예외 처리
        );
        return postRepository.findAllByUser(user).stream()
                .map(PostDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long updatePost(Long postId, String content) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new PostNotFoundException("해당 포스트를 찾을 수 없습니다.")
        );
        return post.update(content);
    }

    @Transactional
    public boolean deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new PostNotFoundException("해당 포스트를 찾을 수 없습니다.")
        );
        postRepository.delete(post);
        return true;
    }

    @Transactional
    public boolean reportPost(ReportPost.Request request) {
        ReportReason reportReason = reportReasonRepository.findById(request.getReportReasonId())
                .orElseThrow(() -> new ReportReasonNotFoundException("신고 사유가 존재하지 않습니다.")
                );
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new PostNotFoundException("해당 포스트를 찾지 못했습니다.")
                );

        Report report = Report.builder()
                .reportReason(reportReason)
                .post(post)
                .reportStatus(BEFORE)
                .build();
        reportRepository.save(report);

        if (request.getDetail() != null) {
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
        Region region = regionRepository.findByNameEquals(request.getRegion())
                .orElseThrow(() -> new RegionNotFoundException("해당 지역이 존재하지 않습니다.")
                );
        Transportation transportation = transportRepository.findByNameEquals(request.getTransportation())
                .orElseThrow(() -> new TransportationNotFoundException("해당 교통수단이 존재하지 않습니다.")
                );

        User user = userRepository.findById(request.getUserId()).orElseThrow(
                // 예외처리
        );
        Post post = Post.builder()
                .user(user)
                .content(request.getContent())
                .region(region)
                .transportation(transportation)
                .likeCount(0L)
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
                .orElseThrow(() -> new PostNotFoundException("해당 글을 조회할 수 없습니다."));
        return PostDto.from(post);
    }

    public List<Transportation> mapToTransportation(List<String> list) {
        return list.stream().map(
                t -> transportRepository.findByNameEquals(t).orElseThrow(
                        () -> new TransportationNotFoundException("해당 교통수단이 존재하지 않습니다.")
                )
        ).collect(Collectors.toList());
    }

    public List<Region> mapToRegion(List<String> list) {
        return list.stream().map(
                r -> regionRepository.findByNameEquals(r).orElseThrow(
                        () -> new RegionNotFoundException("해당 지역이 존재하지 않습니다.")
                )
        ).collect(Collectors.toList());
    }
}
