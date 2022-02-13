package com.minibus.moment.controller;

import com.minibus.moment.dto.api.GetCommentList;
import com.minibus.moment.dto.api.GetPostList;
import com.minibus.moment.dto.api.UpdateProfile;
import com.minibus.moment.service.CommentService;
import com.minibus.moment.service.PostService;
import com.minibus.moment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;

    @PutMapping("/user/{userId}")
    public UpdateProfile.Response updateProfile(
            @PathVariable Long userId,
            @RequestPart("avatar") MultipartFile profileImage
    ) {
        return new UpdateProfile.Response(userService.updateProfile(userId, profileImage));
    }

//    @PutMapping("/user/nickname/{userId}")
    public UpdateProfile.Response updateNickname(
            @PathVariable Long userId,
            @RequestBody UpdateProfile.Request request
    ) {
        return new UpdateProfile.Response(userService.updateNickname(userId, request));
    }

    @GetMapping("/my-posts/{userId}")
    public GetPostList.Response getPostList(@PathVariable Long userId){
        return new GetPostList.Response(postService.getPostListByUser(userId));
    }

    @GetMapping("/my-comments/{userId}")
    public GetCommentList.Response getCommentListByUser(@PathVariable Long userId){
        return new GetCommentList.Response(commentService.getCommentListByUser(userId));
    }
}
