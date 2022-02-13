package com.minibus.moment.dto;

import com.minibus.moment.domain.region.Region;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionDto {

    private Integer id;
    private String name;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Integer id;
        private String region;
        private Long postId;
    }

    public static RegionDto from(Region region) {
        return RegionDto.builder()
                .id(region.getId())
                .name(region.getName())
                .build();
    }
}
