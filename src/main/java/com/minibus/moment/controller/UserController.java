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

    //카카오가 아닌 앱 내에서 사용자 프로필 사진 변경
    @PutMapping("/user/{userId}")
    public UpdateProfile.Response updateProfileImage(
            @PathVariable Long userId,
            @RequestPart("avatar") MultipartFile profileImage
    ) {
        return new UpdateProfile.Response(userService.updateProfile(userId, profileImage));
    }

    //내 글 조회
    @GetMapping("/my-posts/{userId}")
    public GetPostList.Response getPostList(@PathVariable Long userId){
        return new GetPostList.Response(postService.getPostListByUser(userId));
    }

    //내 댓글 조회
    @GetMapping("/my-comments/{userId}")
    public GetCommentList.Response getCommentListByUser(@PathVariable Long userId){
        return new GetCommentList.Response(commentService.getCommentListByUser(userId));
    }

    /**
     * 추후 닉네임 수정이 필요할 경우 사용
     */
    //사용자 닉네임 수정
//    @PutMapping("/user/nickname/{userId}")
    public UpdateProfile.Response updateNickname(
            @PathVariable Long userId,
            @RequestBody UpdateProfile.Request request
    ) {
        return new UpdateProfile.Response(userService.updateNickname(userId, request));
    }
}
