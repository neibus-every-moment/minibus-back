package com.minibus.moment.domain.blind;

import com.minibus.moment.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlindRepository extends JpaRepository<Blind, Long> {

    Optional<Blind> findByPost(Post post);
}
