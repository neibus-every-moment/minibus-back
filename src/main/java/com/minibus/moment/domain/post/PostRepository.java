package com.minibus.moment.domain.post;

import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.type.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByStatus(Status status, Pageable pageable);
    List<Post> findAllByStatusAndRegionIsIn(
            Status status,
            List<Region> regionList,
            Pageable pageable
    );
    List<Post> findAllByStatusAndTransportationIsIn(
            Status status,
            List<Transportation> transportationList,
            Pageable pageable
    );
    List<Post> findAllByStatusAndTransportationIsInAndRegionIsIn(
            Status status,
            List<Transportation> transportationList,
            List<Region> regionList,
            Pageable pageable
    );

    List<Post> findAllByUser(User user);
}
