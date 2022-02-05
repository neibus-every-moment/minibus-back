package com.minibus.moment.service;

import com.minibus.moment.domain.comment.Comment;
import com.minibus.moment.domain.comment.CommentRepository;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.CommentDto;
import com.minibus.moment.dto.api.CreateComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;


    public List<CommentDto> getCommentList(Long postId){

        Post post = postRepository.findById(postId).orElseThrow();

        return commentRepository.findAllByPost(post)
                .stream().map(CommentDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long createComment(CreateComment.Request request){
        Post post = postRepository.findById(request.getPostId()).orElseThrow();
        User user = userRepository.findById(request.getUserId()).orElseThrow();

        Comment comment = Comment.builder()
                .content(request.getContent())
                .user(user)
                .post(post)
                .build();

        return commentRepository.save(comment).getId();
    }

    public List<CommentDto> getCommentListByUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow();

        return commentRepository.findAllByUser(user)
                .stream().map(CommentDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long updateComment(Long commentId, String content){
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        return comment.update(content);
    }

    @Transactional
    public boolean deleteComment(Long commentId){
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        commentRepository.delete(comment);
        return true;
    }
}
