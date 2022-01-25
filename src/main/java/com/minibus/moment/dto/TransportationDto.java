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
        private String emoji;
        private String transportationName;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestIncludingPost {
        private Integer id;
        private String emoji;
        private String transportationName;
        private Long postId;
    }

    private Integer id;

    private String transportation; // = 이모티콘 + 이름

    public static TransportationDto from(Transportation transportation) {
        return TransportationDto.builder()
                .id(transportation.getId())
                .transportation(transportation.getEmoji() + " " + transportation.getName())
                .build();
    }
}
