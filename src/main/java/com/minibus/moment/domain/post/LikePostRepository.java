package com.minibus.moment.domain.post;

import com.minibus.moment.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikePostRepository extends JpaRepository<LikePost, Long> {

    Long countAllByPost(Post post);

    Optional<LikePost> findByPostAndUser(Post post, User user);

    List<LikePost> findAllByUserEquals(User user);
}
