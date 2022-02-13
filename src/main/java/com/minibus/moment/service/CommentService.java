package com.minibus.moment.service;

import com.minibus.moment.domain.comment.Comment;
import com.minibus.moment.domain.comment.CommentRepository;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.CommentDto;
import com.minibus.moment.dto.api.CreateComment;
import com.minibus.moment.exception.CommentNotFoundException;
import com.minibus.moment.exception.PostNotFoundException;
import com.minibus.moment.exception.UserNotFoundException;
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

    // 포스트의 댓글 목록 조회
    public List<CommentDto> getCommentList(Long postId){

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("해당 글을 찾지 못했습니다."));

        return commentRepository.findAllByPost(post)
                .stream().map(CommentDto::from)
                .collect(Collectors.toList());
    }

    // 댓글 작성
    @Transactional
    public Long createComment(CreateComment.Request request){
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new PostNotFoundException("해당 글을 찾지 못했습니다."));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("사용자를 찾지 못헀습니다."));

        Comment comment = Comment.builder()
                .content(request.getContent())
                .user(user)
                .post(post)
                .build();

        return commentRepository.save(comment).getId();
    }

    public List<CommentDto> getCommentListByUser(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("사용자를 찾지 못했습니다."));

        return commentRepository.findAllByUser(user)
                .stream().map(CommentDto::from)
                .collect(Collectors.toList());
    }

    //댓글 수정
    @Transactional
    public Long updateComment(Long commentId, String content){
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException("해당 댓글을 찾지 못했습니다."));

        return comment.update(content);
    }

    //댓글 삭제
    @Transactional
    public boolean deleteComment(Long commentId){
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException("해당 댓글을 찾지 못했습니다."));

        commentRepository.delete(comment);
        return true;
    }
}
