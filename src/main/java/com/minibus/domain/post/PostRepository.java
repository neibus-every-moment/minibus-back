package com.minibus.domain.post;

import com.minibus.type.PostStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByPostStatusEqualsOrderByCreatedAtDesc(PostStatus postStatus, Pageable pageable);
    Page<Post> findAllByPostStatusEqualsOrderByLikeCountDesc(PostStatus postStatus, Pageable pageable);
}
