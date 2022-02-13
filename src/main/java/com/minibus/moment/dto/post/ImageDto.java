package com.minibus.moment.dto.post;

import com.minibus.moment.domain.image.Image;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDto {

    private Long id;
    private String url;

    public static ImageDto from(Image image) {
        return ImageDto.builder()
                .id(image.getId())
                .url(image.getPath())
                .build();
    }
}
