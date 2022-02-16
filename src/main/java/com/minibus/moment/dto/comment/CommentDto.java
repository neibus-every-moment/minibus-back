package com.minibus.moment.dto.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minibus.moment.domain.comment.Comment;
import com.minibus.moment.domain.user.User;
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

    private UserInfo user;

    private String text;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updatedAt;

    public static CommentDto from(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .user(UserInfo.from(comment.getUser()))
                .text(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserInfo {
        private Long id;
        private String avatar;
        private String nickname;

        public static UserInfo from(User user) {
            return UserInfo.builder()
                    .id(user.getId())
                    .avatar(user.getProfileImage())
                    .nickname(user.getNickname())
                    .build();
        }
    }
}
