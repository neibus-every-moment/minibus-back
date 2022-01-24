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
    private String Region;

    public static RegionDto from(Region region) {
        return RegionDto.builder()
                .id(region.getId())
                .Region(region.getName())
                .build();
    }
}
