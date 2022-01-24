package com.minibus.moment.dto;

import com.minibus.moment.domain.emoticon.Emoticon;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmoticonDto {

    private Integer id;

    private String emoticon;

    public static EmoticonDto from(Emoticon emoticon) {
        return EmoticonDto.builder()
                .id(emoticon.getId())
                .emoticon(emoticon.getName())
                .build();
    }
}
