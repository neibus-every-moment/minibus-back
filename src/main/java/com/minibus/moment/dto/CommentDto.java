package com.minibus.moment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minibus.moment.domain.comment.Comment;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommentDto {

    private Long id;

    private PostDto.UserDto user;

    private String text;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updatedAt;

    public static CommentDto from(Comment comment){
        return CommentDto.builder()
                .id(comment.getId())
                .user(PostDto.UserDto.from(comment.getUser()))
                .text(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
