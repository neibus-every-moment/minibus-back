package com.minibus.moment.service;

import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.domain.transportation.TransportationRepository;
import com.minibus.moment.dto.transportation.CreateTransportation;
import com.minibus.moment.dto.transportation.TransportationDto;
import com.minibus.moment.dto.transportation.UpdateTransportation;
import com.minibus.moment.exception.MinibusException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.minibus.moment.exception.MinibusErrorCode.DUPLICATED_TRANSPORTATION;
import static com.minibus.moment.exception.MinibusErrorCode.TRANSPORTATION_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TransportationService {

    private final TransportationRepository transportationRepository;

    public List<TransportationDto> getTransportationList() {
        return transportationRepository.findAll().stream()
                .map(TransportationDto::from)
                .collect(Collectors.toList());
    }

    // 교통수단 테이블에 새로운 교통수단 추가
    @Transactional
    public Integer createTransportation(CreateTransportation.Request request) {
        Optional<Transportation> check = transportationRepository.findByName(request.getTransportationName());
        if(check.isPresent()){
            throw new MinibusException(DUPLICATED_TRANSPORTATION);
        }
        Transportation transportation = Transportation.builder()
                .name(request.getTransportationName())
                .build();
        return transportationRepository.save(transportation).getId();
    }

    // 교통수단 테이블의 교통수단 이름 변경
    @Transactional
    public Integer updateTransportation(Integer transportationId, UpdateTransportation.Request request) {
        Optional<Transportation> check = transportationRepository.findByName(request.getTransportationName());
        if(check.isPresent()){
            throw new MinibusException(DUPLICATED_TRANSPORTATION);
        }
        Transportation transportation = transportationRepository.findById(transportationId).orElseThrow(
                () -> new MinibusException(TRANSPORTATION_NOT_FOUND)
        );
        return transportation.update(request.getTransportationName());
    }

    // 교통수단 테이블에서 교통수단 삭제
    @Transactional
    public boolean deleteTransportation(Integer transportationId) {
        Transportation transportation = transportationRepository.findById(transportationId).orElseThrow(
                () -> new MinibusException(TRANSPORTATION_NOT_FOUND)
        );
        transportationRepository.delete(transportation);
        return true;
    }
}
