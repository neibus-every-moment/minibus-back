package com.minibus.moment.dto.transportation;

import com.minibus.moment.domain.transportation.Transportation;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransportationDto {

    private Integer id;
    private String name;

    public static TransportationDto from(Transportation transportation) {
        return TransportationDto.builder()
                .id(transportation.getId())
                .name(transportation.getName())
                .build();
    }
}
