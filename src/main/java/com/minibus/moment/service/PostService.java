package com.minibus.moment.service;

import com.minibus.moment.domain.emoticon.Emoticon;
import com.minibus.moment.domain.emoticon.EmoticonRepository;
import com.minibus.moment.domain.image.Image;
import com.minibus.moment.domain.image.ImageRepository;
import com.minibus.moment.domain.image.ImageUploader;
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
import com.minibus.moment.dto.PostDto;
import com.minibus.moment.dto.ReportReasonDto;
import com.minibus.moment.dto.api.CreatePost;
import com.minibus.moment.dto.api.GetPostList;
import com.minibus.moment.dto.api.ReportPost;
import com.minibus.moment.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.minibus.moment.type.PostStatus.VISIBLE;
import static com.minibus.moment.type.ReportStatus.BEFORE;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final TransportationRepository transportRepository;
    private final RegionRepository regionRepository;
    private final EmoticonRepository emoticonRepository;
    private final ImageRepository imageRepository;

    private final ReportRepository reportRepository;
    private final ReportReasonRepository reportReasonRepository;
    private final ReportEtcDetailRepository reportEtcDetailRepository;

    public List<ReportReasonDto> getReportReasonList() {
        return reportReasonRepository.findAll().stream()
                .map(ReportReasonDto::from)
                .collect(Collectors.toList());
    }

    public List<PostDto> getPostListNewest(GetPostList.Request request) {
        List<Post> postList;
        List<String> transportationNameList = request.getTransportationName();
        if (transportationNameList == null) {
            transportationNameList = new ArrayList<>();
        }
        List<String> regionNameList = request.getRegionName();
        if (regionNameList == null) {
            regionNameList = new ArrayList<>();
        }
        PageRequest pageRequest = PageRequest.of(request.getStart(), request.getSize());

        if (transportationNameList.isEmpty() && regionNameList.isEmpty()) {
            postList = postRepository.findAllByPostStatusEqualsOrderByCreatedAtDesc(
                    VISIBLE, pageRequest);
        } else if (!transportationNameList.isEmpty() && !regionNameList.isEmpty()) {
            List<Transportation> transportationList = mapToTransportation(transportationNameList);
            List<Region> regionList = mapToRegion(regionNameList);
            postList = postRepository.findAllByPostStatusEqualsAndTransportationIsInAndRegionIsInOrderByCreatedAtDesc(
                    VISIBLE, transportationList, regionList, pageRequest
            );
        } else if (!transportationNameList.isEmpty()) {
            List<Transportation> transportationList = mapToTransportation(transportationNameList);
            postList = postRepository.findAllByPostStatusEqualsAndTransportationIsInOrderByCreatedAtDesc(
                    VISIBLE, transportationList, pageRequest
            );
        } else {
            List<Region> regionList = mapToRegion(regionNameList);
            postList = postRepository.findAllByPostStatusEqualsAndRegionIsInOrderByCreatedAtDesc(
                    VISIBLE, regionList, pageRequest
            );
        }
        return postList.stream().map(PostDto::from).collect(Collectors.toList());
    }

    public List<PostDto> getPostListBest(GetPostList.Request request) {
        List<Post> postList;
        List<String> transportationNameList = request.getTransportationName();
        if (transportationNameList == null) {
            transportationNameList = new ArrayList<>();
        }
        List<String> regionNameList = request.getRegionName();
        if (regionNameList == null) {
            regionNameList = new ArrayList<>();
        }
        PageRequest pageRequest = PageRequest.of(request.getStart(), request.getSize());

        if (transportationNameList.isEmpty() && regionNameList.isEmpty()) {
            postList = postRepository.findAllByPostStatusEqualsOrderByLikeCountDesc(
                    VISIBLE, pageRequest);
        } else if (!transportationNameList.isEmpty() && !regionNameList.isEmpty()) {
            List<Transportation> transportationList = mapToTransportation(transportationNameList);
            List<Region> regionList = mapToRegion(regionNameList);
            postList = postRepository.findAllByPostStatusEqualsAndTransportationIsInAndRegionIsInOrderByLikeCountDesc(
                    VISIBLE, transportationList, regionList, pageRequest
            );
        } else if (!transportationNameList.isEmpty()) {
            List<Transportation> transportationList = mapToTransportation(transportationNameList);
            postList = postRepository.findAllByPostStatusEqualsAndTransportationIsInOrderByLikeCountDesc(
                    VISIBLE, transportationList, pageRequest
            );
        } else {
            List<Region> regionList = mapToRegion(regionNameList);
            postList = postRepository.findAllByPostStatusEqualsAndRegionIsInOrderByLikeCountDesc(
                    VISIBLE, regionList, pageRequest
            );
        }
        return postList.stream().map(PostDto::from).collect(Collectors.toList());
    }

    @Transactional
    public boolean like(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("해당 포스트를 찾지 못했습니다."));
        post.upLikeCount();
        return true;
    }

    @Transactional
    public boolean cancelLike(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("해당 포스트를 찾지 못했습니다.")
                );
        post.downLikeCount();
        return true;
    }

    @Transactional
    public boolean reportPost(ReportPost.Request request) {
        ReportReason reportReason = reportReasonRepository.findById(request.getReportReasonId())
                .orElseThrow(() -> new ReportReasonId("신고 사유가 존재하지 않습니다.")
                );
        Post post = postRepository.findById(request.getId())
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
    public Long createPost(CreatePost.Request request) {
        Region region = regionRepository.findByNameEquals(request.getRegionName())
                .orElseThrow(() -> new RegionNotFoundException("해당 지역이 존재하지 않습니다.")
                );
        Transportation transportation = transportRepository.findByNameEquals(request.getTransportationName())
                .orElseThrow(() -> new TransportationNotFoundException("해당 교통수단이 존재하지 않습니다.")
                );
        Emoticon emoticon = emoticonRepository.findByNameEquals(request.getEmoticonName())
                .orElseThrow(() -> new EmoticonNotFoundException("해당 이모티콘이 존재하지 않습니다.")
                );

        Post post = Post.builder()
                .content(request.getContent())
                .region(region)
                .emoticon(emoticon)
                .transportation(transportation)
                .likeCount(0L)
                .postStatus(VISIBLE)
                .build();
        postRepository.save(post);

        // Todo 저장소에 실제 이미지를 저장하고 URL을 반환 하는 작업 구현 필요
        if (request.getBase64Image() != null) {
            String[] list = request.getBase64Image().split(" ");
            String base64image = list[list.length - 1];
            String fileName = LocalDate.now() + "_" + post.getId();
            String imageUrl = ImageUploader.upload(base64image, fileName, "png");
            //
            Image image = Image.builder()
                    .post(post)
                    .path(imageUrl)
                    .build();
            imageRepository.save(image);
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
