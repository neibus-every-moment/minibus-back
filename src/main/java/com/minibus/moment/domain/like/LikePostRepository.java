package com.minibus.moment.domain.like;

import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikePostRepository extends JpaRepository<LikePost, Long> {

    Long countAllByPost(Post post);

    LikePost findAllByPostEqualsAndUserEquals(Post post, User user);

    List<LikePost> findAllByUserEquals(User user);
}
