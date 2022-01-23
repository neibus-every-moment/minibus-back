package com.minibus.moment.service;

import com.minibus.moment.domain.transportation.TransportationRepository;
import com.minibus.moment.dto.TransportationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransportationService {

    private final TransportationRepository transportationRepository;

    public List<TransportationDto> getTransportationList() {
        return transportationRepository.findAll().stream()
                .map(TransportationDto::from)
                .collect(Collectors.toList());
    }

    // Todo 교통 수단 추가, 업데이트, 삭제 메서드 구현
}
