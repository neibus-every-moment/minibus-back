package com.minibus.moment.dto;

import com.minibus.moment.domain.image.Image;
import com.minibus.moment.domain.post.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {

    private String content;

    private String transportName;

    private String regionName;

    private String emoticonUrl;

    private List<String> imageUrlList;

    private Long likeCount;

    private LocalDateTime createdAt;

    public static PostDto from(Post post){
        return PostDto.builder()
                .content(post.getContent())
                .transportName(post.getContent())
                .regionName(post.getRegion().getName())
                .transportName(post.getTransport().getName())
                .emoticonUrl("resource/emoticon/" + post.getEmoticon().getName())
                .imageUrlList(post.getImageList().stream()
                                .map(Image::getPath)
                                .collect(Collectors.toList()))
                .likeCount(post.getLikeCount())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
