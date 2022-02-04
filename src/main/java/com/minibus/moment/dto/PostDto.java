package com.minibus.moment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private UserDto user;

    private String content;

    private String transportation;

    private String region;

    private List<String> imageList;

    private Long likeCount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    public static PostDto from(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .user(UserDto.toDto(post.getUser()))
                .content(post.getContent())
                .region(post.getRegion().getName())
                .transportation(post.getTransportation().getName())
                .imageList(post.getImageList().stream()
                        .map(Image::getPath)
                        .collect(Collectors.toList()))
                .likeCount(post.getLikeCount())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
