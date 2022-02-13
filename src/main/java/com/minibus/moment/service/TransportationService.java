package com.minibus.moment.service;

import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.domain.transportation.TransportationRepository;
import com.minibus.moment.dto.transportation.CreateTransportation;
import com.minibus.moment.dto.transportation.TransportationDto;
import com.minibus.moment.dto.transportation.UpdateTransportation;
import com.minibus.moment.exception.PostNotExistException;
import com.minibus.moment.exception.TransportationAlreadyExistException;
import com.minibus.moment.exception.TransportationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransportationService {

    private final TransportationRepository transportationRepository;
    private final PostRepository postRepository;

    public List<TransportationDto> getTransportationList() {
        return transportationRepository.findAll().stream()
                .map(TransportationDto::from)
                .collect(Collectors.toList());
    }

    // 교통수단 테이블에 새로운 교통수단 추가
    @Transactional
    public Integer createTransportation(CreateTransportation.Request request) {
        transportationRepository.findByName(request.getTransportationName())
                .ifPresent(t -> new TransportationAlreadyExistException("이미 존재하는 교통수단 입니다."));
        Transportation transportation = Transportation.builder()
                .name(request.getTransportationName())
                .build();
        return transportationRepository.save(transportation).getId();
    }

    // 교통수단 테이블의 교통수단 이름 변경
    @Transactional
    public Integer updateTransportation(Integer transportationId, UpdateTransportation.Request request){
        transportationRepository.findByName(request.getTransportationName())
                .ifPresent(t -> new TransportationAlreadyExistException("이미 존재하는 교통수단 입니다."));
        Transportation transportation = transportationRepository.findById(transportationId).orElseThrow(
                () -> new TransportationNotFoundException("교통수단이 존재 하지 않습니다.")
        );
        return transportation.update(request.getTransportationName());
    }

    // 교통수단 테이블에서 교통수단 삭제
    public boolean deleteTransportation(Integer transportationId) {
        Transportation transportation = transportationRepository.findById(transportationId).orElseThrow(
                () -> new TransportationNotFoundException("교통수단이 존재 하지 않습니다.")
        );
        transportationRepository.delete(transportation);
        return true;
    }
}
