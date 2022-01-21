package com.minibus.moment.service;

import com.minibus.moment.domain.transport.Transport;
import com.minibus.moment.domain.transport.TransportRepository;
import com.minibus.moment.dto.TransportDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransService {

    private final TransportRepository transportRepository;

//    public List<String> getTransportList() {
//        List<Transport> all = transportRepository.findAll();
//
//    }
    public TransportDto getTransportList() {
        List<Transport> transports = transportRepository.findAll();
        return TransportDto.builder()
                .data(transports)
                .build();
    }
}
