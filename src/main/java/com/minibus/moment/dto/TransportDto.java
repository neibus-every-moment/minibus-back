package com.minibus.moment.dto;

import com.minibus.moment.domain.transport.Transport;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransportDto {
//    private Integer id;
//    private String name;
    private List<Transport> data;

}
