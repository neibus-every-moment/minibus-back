package com.minibus.moment.domain.post;

import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.type.PostStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findTopByOrderByIdDesc();

    // 최신순 정렬 관련
    List<Post> findAllByPostStatusEqualsOrderByCreatedAtDesc(PostStatus postStatus, Pageable pageable);
    List<Post> findAllByPostStatusEqualsAndRegionIsInOrderByCreatedAtDesc(
            PostStatus postStatus,
            List<Region> regionList,
            Pageable pageable
    );
    List<Post> findAllByPostStatusEqualsAndTransportationIsInOrderByCreatedAtDesc(
            PostStatus postStatus,
            List<Transportation> transportationList,
            Pageable pageable
    );
    List<Post> findAllByPostStatusEqualsAndTransportationIsInAndRegionIsInOrderByCreatedAtDesc(
            PostStatus postStatus,
            List<Transportation> transportationList,
            List<Region> regionList,
            Pageable pageable
    );


    // 공감순 정렬 관련
    List<Post> findAllByPostStatusEqualsOrderByLikeCountDesc(PostStatus postStatus, Pageable pageable);
    List<Post> findAllByPostStatusEqualsAndRegionIsInOrderByLikeCountDesc(
            PostStatus postStatus,
            List<Region> regionList,
            Pageable pageable
    );
    List<Post> findAllByPostStatusEqualsAndTransportationIsInOrderByLikeCountDesc(
            PostStatus postStatus,
            List<Transportation> transportationList,
            Pageable pageable
    );
    List<Post> findAllByPostStatusEqualsAndTransportationIsInAndRegionIsInOrderByLikeCountDesc(
            PostStatus postStatus,
            List<Transportation> transportationList,
            List<Region> regionList,
            Pageable pageable
    );
}
