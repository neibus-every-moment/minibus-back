package com.minibus.moment.dto;

import com.minibus.moment.domain.transportation.Transportation;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransportationDto {

    private Integer id;

    private String transportation;

    public static TransportationDto from(Transportation transportation){
        return TransportationDto.builder()
                .id(transportation.getId())
                .transportation(transportation.getEmoji() + " " + transportation.getName())
                .build();
    }
}
