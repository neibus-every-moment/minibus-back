package com.minibus.moment.dto.api;

import com.minibus.moment.dto.RegionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class GetRegionList {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private List<RegionDto> data;
    }
}
