package com.minibus.moment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minibus.moment.domain.post.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    private Long likeCount;

    private Comments comments;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updatedAt;

    public static PostDto from(Post post) {

        List<CommentDto> contents = post.getCommentList().stream().map(CommentDto::from).collect(Collectors.toList());
        return PostDto.builder()
                .id(post.getId())
                .user(UserDto.from(post.getUser()))
                .text(post.getContent())
                .region(post.getRegion().getName())
                .transportation(post.getTransportation().getName())
                .images(post.getImageList().stream()
                        .map(ImageDto::from)
                        .collect(Collectors.toList()))
                .likeCount(post.getLikeCount())
                .comments(new Comments(contents.size(),contents))
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
}

