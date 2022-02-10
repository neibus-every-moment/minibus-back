package com.minibus.moment.dto;

import com.minibus.moment.domain.transportation.Transportation;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransportationDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Integer id;
        private String transportation;
        private Long postId;
    }

    private Integer id;
    private String name;

    public static TransportationDto from(Transportation transportation) {
        return TransportationDto.builder()
                .id(transportation.getId())
                .name(transportation.getName())
                .build();
    }
}
