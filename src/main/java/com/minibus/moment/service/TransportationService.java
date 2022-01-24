package com.minibus.moment.service;

import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.domain.transportation.TransportationRepository;
import com.minibus.moment.dto.TransportationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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

    // Todo 교통 수단 추가, 업데이트, 삭제 메서드 구현

    // 교통수단 테이블에 새로운 교통수단 추가
    public void newTransportation(TransportationDto transportationDto) {
        Transportation newTransportation = Transportation.builder()
                .name(transportationDto.getTransportation())
                .build();
        transportationRepository.save(newTransportation);
    }

    // 교통수단 테이블의 교통수단 이름 변경
    @Transactional
    public void editTransportationNameInTable(TransportationDto transportationDto){
        transportationRepository.findById(transportationDto.getId()).orElseThrow().builder().name(transportationDto.getTransportation()).build();
    }

    // 포스트의 교통수단 변경
    @Transactional
    public void editTransportationInPost(Long postId, String transportation){
        postRepository.findById(postId).orElseThrow().builder().transportation(transportationRepository.findByNameEquals(transportation).orElseThrow()).build();
    }

    // 교통수단 테이블에서 교통수단 삭제
    public void deleteTransportationInTable(String transportation) {
        transportationRepository.delete(transportationRepository.findByNameEquals(transportation).orElseThrow());
    }
}
