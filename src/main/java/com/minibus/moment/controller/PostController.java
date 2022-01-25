package com.minibus.moment.controller;

import com.minibus.moment.dto.api.*;
import com.minibus.moment.exception.EmoticonNotFoundException;
import com.minibus.moment.exception.PostNotFoundException;
import com.minibus.moment.exception.RegionNotFoundException;
import com.minibus.moment.exception.TransportationNotFoundException;
import com.minibus.moment.service.EmoticonService;
import com.minibus.moment.service.PostService;
import com.minibus.moment.service.RegionService;
import com.minibus.moment.service.TransportationService;
import lombok.RequiredArgsConstructor;
import org.hibernate.TransientPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    private final TransportationService transportationService;
    private final RegionService regionService;
    private final EmoticonService emoticonService;

    @GetMapping("/transportation")
    public GetTransportationList.Response getTransportationList() {
        return new GetTransportationList.Response(transportationService.getTransportationList());
    }

    @GetMapping("/regions")
    public GetRegionList.Response getRegionList() {
        return new GetRegionList.Response(regionService.getRegionList());
    }


    @GetMapping("/reasons")
    public GetReportReasonList.Response getReportReasonList() {
        return new GetReportReasonList.Response(postService.getReportReasonList());
    }

    @PostMapping("/list/best")
    public GetPostList.Response getPostListBest(@RequestBody GetPostList.Request request) {
        return new GetPostList.Response(postService.getPostListBest(request));
    }

    @PostMapping("/list/newest")
    public GetPostList.Response getPostListNewest(@RequestBody GetPostList.Request request) {
        return new GetPostList.Response(postService.getPostListNewest(request));
    }

    @PostMapping("/post/report")
    public boolean reportPost(@RequestBody ReportPost.Request request){
        return postService.reportPost(request);
    }

    @PutMapping("/post/{postId}/like")
    public boolean likePost(@PathVariable Long postId) {
        return postService.like(postId);
    }

    @PutMapping("/post/{postId}/cancel")
    public boolean cancelLikePost(@PathVariable Long postId) {
        return postService.cancelLike(postId);
    }

    @PostMapping("/post")
    public CreatePost.Response createPost(@RequestBody CreatePost.Request request) {
        return new CreatePost.Response(postService.createPost(request));
    }

    @GetMapping("/post/{postId}")
    public GetPost.Response getPost(@PathVariable Long postId) {
        return new GetPost.Response(postService.getPost(postId));
    }

}
