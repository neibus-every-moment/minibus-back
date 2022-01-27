package com.minibus.moment.controller;

import com.minibus.moment.dto.api.*;
import com.minibus.moment.service.EmoticonService;
import com.minibus.moment.service.PostService;
import com.minibus.moment.service.RegionService;
import com.minibus.moment.service.TransportationService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/emoticons")
    public GetEmoticonList.Response getEmoticonList() {
        return new GetEmoticonList.Response(emoticonService.getEmoticonList());
    }

    @GetMapping("/reasons")
    public GetReportReasonList.Response getReportReasonList() {
        return new GetReportReasonList.Response(postService.getReportReasonList());
    }

    @GetMapping("/list/best")
    public GetPostList.Response getPostListBest(GetPostList.Request request) {
        return new GetPostList.Response(postService.getPostListBest(request));
    }

    @GetMapping("/list/newest")
    public GetPostList.Response getPostListNewest(GetPostList.Request request) {
        return new GetPostList.Response(postService.getPostListNewest(request));
    }

    @PostMapping("/post/report")
    public boolean reportPost(@RequestBody ReportPost.Request request) {
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
