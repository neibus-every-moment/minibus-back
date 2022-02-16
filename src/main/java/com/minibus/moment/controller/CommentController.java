package com.minibus.moment.controller;

import com.minibus.moment.dto.comment.CreateComment;
import com.minibus.moment.dto.comment.GetCommentList;
import com.minibus.moment.dto.comment.ReportComment;
import com.minibus.moment.dto.comment.UpdateComment;
import com.minibus.moment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comments/{postId}")
    public GetCommentList.Response getCommentList(@PathVariable Long postId) {
        return new GetCommentList.Response(commentService.getCommentList(postId));
    }

    @PostMapping("/comment")
    public CreateComment.Response createComment(@RequestBody CreateComment.Request request) {
        return new CreateComment.Response(commentService.createComment(request));
    }

    @PostMapping("/comment/report")
    public boolean reportComment(@RequestBody ReportComment.Request request) {
        return commentService.reportComment(request);
    }

    @PutMapping("/comment/{commentId}")
    public UpdateComment.Response updateComment(
            @PathVariable Long commentId,
            @RequestBody UpdateComment.Request request
    ) {
        return new UpdateComment.Response(commentService.updateComment(commentId, request.getContent()));
    }

    @DeleteMapping("/comment/{commentId}")
    public boolean deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }

}
