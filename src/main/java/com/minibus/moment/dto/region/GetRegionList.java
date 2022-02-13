package com.minibus.moment.dto.region;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class GetRegionList {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private List<String> data;

        public static Response toResponse(List<RegionDto> regionDtoList){
            Response response = new Response();
            response.data = regionDtoList.stream().map(RegionDto::getName).collect(Collectors.toList());
            return response;
        }
    }
}
