package com.minibus.moment.dto.region;

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


    public static RegionDto from(Region region) {
        return RegionDto.builder()
                .id(region.getId())
                .name(region.getName())
                .build();
    }
}
