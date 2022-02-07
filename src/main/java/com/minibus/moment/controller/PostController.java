package com.minibus.moment.controller;

import com.minibus.moment.dto.api.*;
import com.minibus.moment.service.PostService;
import com.minibus.moment.service.RegionService;
import com.minibus.moment.service.TransportationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    private final TransportationService transportationService;
    private final RegionService regionService;

    @GetMapping("/transportations")
    public GetTransportationList.Response getTransportationList() {
        return GetTransportationList.Response.toResponse(transportationService.getTransportationList());
    }

    @GetMapping("/regions")
    public GetRegionList.Response getRegionList() {
        return GetRegionList.Response.toResponse(regionService.getRegionList());
    }


    @GetMapping("/reasons")
    public GetReportReasonList.Response getReportReasonList() {
        return new GetReportReasonList.Response(postService.getReportReasonList());
    }

    @GetMapping("/posts")
    public GetPostList.Response getPostList(GetPostList.Request request) {
        return new GetPostList.Response(postService.getPostList(request));
    }

    @PostMapping("/report")
    public boolean reportPost(@RequestBody ReportPost.Request request) {
        return postService.reportPost(request);
    }

    @PostMapping("/post")
    public CreatePost.Response createPost(
            @RequestPart("img") List<MultipartFile> multipartFileList,
            @RequestPart("request") CreatePost.Request request) {
        return new CreatePost.Response(postService.createPost(multipartFileList, request));
    }

    @PutMapping("/post/{postId}")
    public UpdatePost.Response updatePost(
            @PathVariable Long postId,
            @RequestBody UpdatePost.Request request
    ) {
        return new UpdatePost.Response(postService.updatePost(postId, request.getContent()));
    }

    @DeleteMapping("/post/{postId}")
    public boolean deletePost(@PathVariable Long postId) {
        return postService.deletePost(postId);
    }

    @GetMapping("/post/{postId}")
    public GetPost.Response getPost(@PathVariable Long postId) {
        return new GetPost.Response(postService.getPost(postId));
    }

    @GetMapping("/my-posts")
    public GetPostList.Response getPostList(@RequestParam Long userId){
        return new GetPostList.Response(postService.getPostListByUser(userId));
    }
}
