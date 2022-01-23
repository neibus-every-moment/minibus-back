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
@ToString
public class PostDto {

    private Long id;

    private String content;

    private String transportation;

    private String regionName;

    private String emoticon;

    private List<String> imageList;

    private Long likeCount;

    private LocalDateTime createdAt;

    public static PostDto from(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .content(post.getContent())
                .regionName(post.getRegion().getName())
                .transportation(post.getTransportation().getEmoji() + " " + post.getTransportation().getName())
                .emoticon(post.getEmoticon().getEmoji() + " " + post.getEmoticon().getName())
                .imageList(post.getImageList().stream()
                        .map(Image::getPath)
                        .collect(Collectors.toList()))
                .likeCount(post.getLikeCount())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
