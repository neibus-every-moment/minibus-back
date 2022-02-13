package com.minibus.moment.dto.user;

import com.minibus.moment.domain.comment.Comment;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.user.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Login {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private UserDto user;

        private List<Long> posts;
        private List<Long> comments;

        public static Login.Response of(User user) {

            List<Long> posts = new ArrayList<>();
            List<Long> comments = new ArrayList<>();
            if(user.getPostList() != null){
                posts = user.getPostList().stream().map(Post::getId).collect(Collectors.toList());
            }
            if(user.getCommentList() != null){
                comments = user.getCommentList().stream().map(Comment::getId).collect(Collectors.toList());
            }

            return Response.builder()
                    .user(UserDto.from(user))
                    .posts(posts)
                    .comments(comments)
                    .build();
        }
    }
}