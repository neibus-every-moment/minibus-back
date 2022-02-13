package com.minibus.moment.service;

import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.domain.transportation.TransportationRepository;
import com.minibus.moment.dto.TransportationDto;
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

    // 교통수단 목록 조회
    public List<TransportationDto> getTransportationList() {
        return transportationRepository.findAll().stream()
                .map(TransportationDto::from)
                .collect(Collectors.toList());
    }

    // 교통수단 테이블에 새로운 교통수단 추가
    public void createTransportation(TransportationDto.Request request) {
        // 등록하려는 Transportation 이 이미 테이블에 있는지 확인하고 없으면 추가 있으면 throw TransportationAlreadyExist
        Optional<Transportation> transportation = transportationRepository.findByNameEquals(request.getTransportation());
        if(!transportation.isPresent()) {
            transportationRepository.save(Transportation.builder()
                            .name(request.getTransportation())
                            .build());
        } else {
            throw new TransportationAlreadyExistException("이미 존재하는 항목입니다.");
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
            throw new TransportationAlreadyExistException("이미 존재하는 항목입니다.");
        }
    }

    // 포스트의 교통수단 변경
    @Transactional
    public void editPostTransportation(TransportationDto.Request request){
        postRepository.findById(request.getPostId()).ifPresentOrElse(
                entity -> entity.setTransportation(transportationRepository.findByNameEquals(request.getTransportation()).orElseThrow( () -> new TransportationNotFoundException("교통수단을 선택해주세요."))),
                () -> new PostNotExistException("해당 포스트가 존재하지 않습니다.")
        );
    }

    // 교통수단 테이블에서 교통수단 삭제
    public void deleteTransportationInTable(TransportationDto.Request request) {
        transportationRepository.findByNameEquals(request.getTransportation()).ifPresentOrElse(
            entity -> transportationRepository.delete(entity),
            () -> new TransportationNotFoundException("해당 교통수단을 찾지 못하였습니다.")
        );
    }
}
