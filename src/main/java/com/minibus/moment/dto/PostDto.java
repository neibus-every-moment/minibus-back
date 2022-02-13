package com.minibus.moment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minibus.moment.domain.like.LikePost;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PostDto {

    private Long id;

    private UserDto user;

    private String text;

    private String transportation;

    private String region;

    private List<ImageDto> images;

    private LikeInfo like;

    private Comments comments;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updatedAt;

    public static PostDto from(Post post) {

        List<CommentDto> contents = post.getCommentList().stream().map(CommentDto::from).collect(Collectors.toList());
        List<Long> userIds = post.getLikePostList().stream()
                .map(LikePost::getUser)
                .map(User::getId)
                .collect(Collectors.toList());

        return PostDto.builder()
                .id(post.getId())
                .user(UserDto.from(post.getUser()))
//                .user(UserDto.from(post.getUser()))
                .text(post.getContent())
                .region(post.getRegion().getName())
                .transportation(post.getTransportation().getName())
                .images(post.getImageList().stream()
                        .map(ImageDto::from)
                        .collect(Collectors.toList()))
                .like(new LikeInfo(Long.valueOf(userIds.size()), userIds))
                .comments(new Comments(contents.size(), contents))
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Comments {
        private Integer count;
        private List<CommentDto> contents;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class LikeInfo {
        private Long count;
        private List<Long> users;
    }

//    @Getter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Builder
//    public static class UserDto {
//        private Long id;
//        private String avatar;
//        private String nickname;
//
//        public static UserDto from(User user){
//            return UserDto.builder()
//                    .id(user.getId())
//                    .avatar(user.getProfileImage())
//                    .nickname(user.getNickname())
//                    .build();
//        }
//    }
}

