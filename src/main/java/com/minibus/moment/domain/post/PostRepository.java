package com.minibus.moment.domain.post;

import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.type.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // 최신순 정렬 관련
    List<Post> findAllByStatusEqualsOrderByCreatedAtDesc(Status status, Pageable pageable);
    List<Post> findAllByStatusEqualsAndRegionIsInOrderByCreatedAtDesc(
            Status status,
            List<Region> regionList,
            Pageable pageable
    );
    List<Post> findAllByStatusEqualsAndTransportationIsInOrderByCreatedAtDesc(
            Status status,
            List<Transportation> transportationList,
            Pageable pageable
    );
    List<Post> findAllByStatusEqualsAndTransportationIsInAndRegionIsInOrderByCreatedAtDesc(
            Status status,
            List<Transportation> transportationList,
            List<Region> regionList,
            Pageable pageable
    );


    // 공감순 정렬 관련
    List<Post> findAllByStatusEqualsOrderByLikeCountDesc(Status status, Pageable pageable);
    List<Post> findAllByStatusEqualsAndRegionIsInOrderByLikeCountDesc(
            Status status,
            List<Region> regionList,
            Pageable pageable
    );
    List<Post> findAllByStatusEqualsAndTransportationIsInOrderByLikeCountDesc(
            Status status,
            List<Transportation> transportationList,
            Pageable pageable
    );
    List<Post> findAllByStatusEqualsAndTransportationIsInAndRegionIsInOrderByLikeCountDesc(
            Status status,
            List<Transportation> transportationList,
            List<Region> regionList,
            Pageable pageable
    );

    List<Post> findAllByStatusEqualsAndUserEqualsOrderByCreatedAtDesc(
            Status status,
            User user,
            Pageable pageable);
}
