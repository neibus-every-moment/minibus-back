package com.minibus.moment.controller;

import com.minibus.moment.dto.CommentDto;
import com.minibus.moment.dto.api.CreateComment;
import com.minibus.moment.dto.api.GetCommentList;
import com.minibus.moment.dto.api.UpdateComment;
import com.minibus.moment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comments/{postId}")
    public GetCommentList.Response getCommentList(@PathVariable Long postId){
        return new GetCommentList.Response(commentService.getCommentList(postId));
    }

    @PostMapping("/comment")
    public CreateComment.Response createComment(@RequestBody CreateComment.Request request){
        return new CreateComment.Response(commentService.createComment(request));
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

    @GetMapping("/my-comments")
    public GetCommentList.Response getCommentListByUser(@RequestParam Long userId){
        return new GetCommentList.Response(commentService.getCommentListByUser(userId));
    }

}
