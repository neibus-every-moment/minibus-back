package com.minibus.moment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minibus.moment.domain.comment.Comment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommentDto {

    private Long id;

    private UserDto user;

    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    public static CommentDto from(Comment comment){
        return CommentDto.builder()
                .id(comment.getId())
                .user(UserDto.toDto(comment.getUser()))
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
