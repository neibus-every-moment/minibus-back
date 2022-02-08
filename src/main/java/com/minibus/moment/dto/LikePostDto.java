package com.minibus.moment.dto;

import com.minibus.moment.domain.like.LikePost;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikePostDto {

    private Long postId;
    private Long userId;
    private String likeStatus;
    private Long postLikeCount;



    public static LikePostDto from(LikePost likePost){
        return LikePostDto.builder()
                .postId(likePost.getPost().getId())
                .userId(likePost.getUser().getId())
                .build();
    }

}
