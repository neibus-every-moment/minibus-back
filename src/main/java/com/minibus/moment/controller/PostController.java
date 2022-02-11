package com.minibus.moment.controller;

import com.minibus.moment.dto.api.*;

import com.minibus.moment.service.*;

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
    private final LikePostService likePostService;

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
        return GetReportReasonList.Response.toResponse(postService.getReportReasonList());
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

    // 좋아요 기능. request 에 담긴 postId, userId로 좋아요 기능 실행 뒤 GetPost.Response반환
    @PutMapping("/post/like/{postId}")
    public ToLikePost.Response likePost(@PathVariable Long postId,@RequestBody ToLikePost.Request request) throws Exception{
        return new ToLikePost.Response(likePostService.toLikePost(postId, request));
    }

    // LIKE_POST테이블에서 userId 검색하고 결과의 postId를 POST테이블에서 모두 검색하여 반환
    @GetMapping("/my-like-posts")
    public GetPostList.Response getMyLikePostList(@RequestParam Long userId) {
        return new GetPostList.Response(likePostService.getMyLikePostList(userId));
    }

    @GetMapping("/my-posts")
    public GetPostList.Response getPostList(@RequestParam Long userId){
        return new GetPostList.Response(postService.getPostListByUser(userId));
    }
}
