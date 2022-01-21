package com.minibus.moment.dto;

import com.minibus.moment.domain.region.Region;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionDto {

    private List<Region> data;

}
