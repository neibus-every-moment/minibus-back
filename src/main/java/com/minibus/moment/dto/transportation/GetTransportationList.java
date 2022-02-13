package com.minibus.moment.dto.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class GetTransportationList {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private List<String> data;

        public static Response toResponse(List<TransportationDto> transportationDtoList) {
            Response response = new Response();
            response.data = transportationDtoList.stream()
                    .map(TransportationDto::getName)
                    .collect(Collectors.toList());
            return response;
        }
    }
}
