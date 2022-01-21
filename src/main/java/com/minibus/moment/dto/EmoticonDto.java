package com.minibus.moment.dto;

import com.minibus.moment.domain.emoticon.Emoticon;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmoticonDto {

    private List<Emoticon> data;
}
