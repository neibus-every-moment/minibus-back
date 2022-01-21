package com.minibus.moment.domain.post;

import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.transport.Transport;
import com.minibus.moment.dto.PostDto;
import com.minibus.moment.type.PostStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    //Region 정렬
    Page<Post> findAllByPostStatusEqualsAndRegionEqualsOrderByCreatedAtDesc(PostStatus postStatus, Region region, Pageable pageable);
    Page<Post> findAllByPostStatusEqualsAndRegionEqualsOrderByLikeCountDesc(PostStatus postStatus, Region region, Pageable pageable);

    //Transport 정렬
    Page<Post> findAllByPostStatusEqualsAndTransportEqualsOrderByCreatedAtDesc(PostStatus postStatus, Transport transport, Pageable pageable);
    Page<Post> findAllByPostStatusEqualsAndTransportEqualsOrderByLikeCountDesc(PostStatus postStatus, Transport transport, Pageable pageable);

}
