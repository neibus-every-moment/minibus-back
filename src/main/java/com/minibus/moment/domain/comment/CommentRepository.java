package com.minibus.moment.domain.comment;

import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.dto.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPost(Post post);

    List<Comment> findAllByUser(User user);
}
