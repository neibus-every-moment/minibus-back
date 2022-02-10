package com.minibus.moment.service;

import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.domain.transportation.TransportationRepository;
import com.minibus.moment.dto.TransportationDto;
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
    public void newTransportation(TransportationDto.Request request) {
        // 등록하려는 Transportation 이 이미 테이블에 있는지 확인하고 없으면 추가 있으면 throw TransportationAlreadyExist
        Optional<Transportation> transportation = transportationRepository.findByNameEquals(request.getTransportation());
        if(!transportation.isPresent()) {
            transportationRepository.save(Transportation.builder()
                            .name(request.getTransportation())
                            .build());
        } else {
            // TransportationAlreadyExistException
        }
    }

    // 교통수단 테이블의 교통수단 이름 변경
    @Transactional
    public void editTransportationNameInTable(TransportationDto.Request request){
        // 등록하려는 Transportation 검색하여 이름 변경, 이미 테이블에 있는 명칭으로는 변경 불가
        Optional<Transportation> transportation = transportationRepository.findByNameEquals(request.getTransportation());
        if(!transportation.isPresent()) {
            transportationRepository.findById(request.getId()).ifPresent(
                    entity -> entity.setName(request.getTransportation())
            );
        } else {
            // TransportationAlreadyExistException
        }
    }

    // 포스트의 교통수단 변경
    @Transactional
    public void editPostTransportation(TransportationDto.Request request){
        postRepository.findById(request.getPostId()).ifPresentOrElse(
                entity -> entity.setTransportation(transportationRepository.findByNameEquals(request.getTransportation()).orElseThrow()),
                () -> new Exception() //PostNotExistException
        );
    }

    // 교통수단 테이블에서 교통수단 삭제
    public void deleteTransportationInTable(TransportationDto.Request request) {
        transportationRepository.findByNameEquals(request.getTransportation()).ifPresentOrElse(
            entity -> transportationRepository.delete(entity),
            () -> new Exception() //TransportationNotExistException
        );

    }
}
