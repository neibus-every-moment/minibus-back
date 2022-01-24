package com.minibus.moment.dto.api;

import com.minibus.moment.dto.TransportationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class GetTransportationList {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private List<TransportationDto> data;
    }
}
