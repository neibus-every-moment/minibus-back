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
    public boolean newTransportation(TransportationDto.Request request) {
        //Todo Validation
        if(!transportationRepository.findByNameEquals(request.getTransportationName()).isPresent()) {
            Transportation newTransportation = Transportation.builder()
                    .name(request.getTransportationName())
                    .emoji(request.getEmoji())
                    .build();
            transportationRepository.save(newTransportation);
            return true;
        } else return false;
    }

    // 교통수단 테이블의 교통수단 이름 변경
    @Transactional
    public void editTransportationNameInTable(TransportationDto.Request request){
        transportationRepository.findById(request.getId()).orElseThrow().builder()
                .name(request.getTransportationName())
                .build();
    }

    // 포스트의 교통수단 변경
    @Transactional
    public void editTransportationInPost(TransportationDto.RequestIncludingPost request){
        postRepository.findById(request.getPostId()).orElseThrow().builder().transportation(transportationRepository.findByNameEquals(request.getTransportationName()).orElseThrow()).build();
    }

    // 교통수단 테이블에서 교통수단 삭제
    public void deleteTransportationInTable(TransportationDto.Request request) {
        transportationRepository.delete(transportationRepository.findByNameEquals(request.getTransportationName()).orElseThrow());
    }
}
