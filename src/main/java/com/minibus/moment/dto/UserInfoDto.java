package com.minibus.moment.dto;

import com.minibus.moment.domain.comment.Comment;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.user.User;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserInfoDto {

    private Long id;
    private String nickname;
    private String email;
    private String avatar;
    private List<Long> postId;
    private List<Long> commentId;

    public static UserInfoDto from(User user) {
        List<Long> postId = user.getPostList().stream().map(Post::getId).collect(Collectors.toList());
        List<Long> commentId = user.getCommentList().stream().map(Comment::getId).collect(Collectors.toList());
        return UserInfoDto.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .avatar(user.getProfileImage())
                .postId(postId)
                .commentId(commentId)
                .build();
    }
}
