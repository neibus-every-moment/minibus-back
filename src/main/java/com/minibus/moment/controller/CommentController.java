package com.minibus.moment.controller;

import com.minibus.moment.auth.service.JwtTokenProvider;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.UserDto;
import com.minibus.moment.dto.api.CreateComment;
import com.minibus.moment.dto.api.GetCommentList;
import com.minibus.moment.dto.api.ReportComment;
import com.minibus.moment.dto.api.UpdateComment;
import com.minibus.moment.service.CommentService;
import com.minibus.moment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @GetMapping("/comments/{postId}")
    public GetCommentList.Response getCommentList(@PathVariable Long postId){
        return new GetCommentList.Response(commentService.getCommentList(postId));
    }

    @PostMapping("/comment")
    public CreateComment.Response createComment(@RequestBody CreateComment.Request request){
        return new CreateComment.Response(commentService.createComment(request));
    }

    @PostMapping("/comment/report")
    public boolean reportComment(@RequestBody ReportComment.Request request){
        return commentService.reportComment(request);
    }

    @PutMapping("/comment/{commentId}")
    public UpdateComment.Response updateComment(
            @PathVariable Long commentId,
            @RequestBody UpdateComment.Request request
    ){
        return new UpdateComment.Response(commentService.updateComment(commentId, request.getContent()));
    }

    @DeleteMapping("/comment/{commentId}")
    public boolean deleteComment(@PathVariable Long commentId){
        return commentService.deleteComment(commentId);
    }

}
