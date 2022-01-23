package com.minibus.moment.controller;

import com.minibus.moment.dto.PostDto;
import com.minibus.moment.dto.PostInput;
import com.minibus.moment.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/post/list/transport/newest")
    public Page<PostDto> postListTransportNewest(@RequestBody int startIndex, @RequestBody String transportName) {
        Page<PostDto> postPage = postService.pagePostListTransportNewest(startIndex, transportName);
        return postPage;
    }

    @GetMapping("/post/list/transport/bestLike")
    public Page<PostDto> postListTransportBestLike(@RequestBody int startIndex, @RequestBody String transportName) {
        Page<PostDto> postPage = postService.pagePostListTransportBestLike(startIndex, transportName);
        return postPage;
    }

    @GetMapping("/post/list/region/newest")
    public Page<PostDto> postListRegionNewest(@RequestBody int startIndex, @RequestBody String regionName) {
        Page<PostDto> postPage = postService.pagePostListRegionNewest(startIndex, regionName);
        return postPage;
    }

    @GetMapping("/post/list/region/bestLike")
    public Page<PostDto> postListRegionBestLike(@RequestBody int startIndex, @RequestBody String regionName) {
        Page<PostDto> postPage = postService.pagePostListRegionBestLike(startIndex, regionName);
        return postPage;
    }

    @PatchMapping("/post/{postId}/like")
    public void postLike(@PathVariable Long postId) {
        postService.likeCount(postId);
    }

    @PatchMapping("/post/{postId}/like/cancel")
    public void postLikeCancel(@PathVariable Long postId) {
        postService.likeCancelCount(postId);
    }

    @PostMapping("/post/createPost")
    public void createPost(@RequestBody PostInput postInput) {

    }
}
