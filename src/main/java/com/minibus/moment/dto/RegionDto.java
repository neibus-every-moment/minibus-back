package com.minibus.moment.dto;

import com.minibus.moment.domain.region.Region;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Integer id;
        @NotNull(message = "지역을 입력해주세요.")
        private String region;
        private Long postId;
    }

    private Integer id;
    private String name;


    public static RegionDto from(Region region) {
        return RegionDto.builder()
                .id(region.getId())
                .name(region.getName())
                .build();
    }
}
