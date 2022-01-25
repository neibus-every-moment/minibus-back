package com.minibus.moment.service;

import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.region.RegionRepository;
import com.minibus.moment.dto.RegionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;
    private final PostRepository postRepository;

    public List<RegionDto> getRegionList() {
        return regionRepository.findAll().stream()
                .map(RegionDto::from)
                .collect(Collectors.toList());
    }

    // Todo  지역 추가, 업데이트, 삭제 메서드 구현

    // 지역 테이블에 새로운 지역 추가
    public boolean newRegion(RegionDto.Request request) {
        if(!regionRepository.findByNameEquals(request.getRegion()).isPresent()) {
            Region newRegion = Region.builder()
                    .name(request.getRegion())
                    .build();
            regionRepository.save(newRegion);
            return true;
        } else return false;
    }

    // 지역 테이블의 지역 이름 변경
    @Transactional
    public void editRegionNameInTable(RegionDto.Request request){
        regionRepository.findById(request.getId()).orElseThrow().builder().name(request.getRegion()).build();
    }

    // 포스트의 지역 변경
    @Transactional
    public void editRegionInPost(RegionDto.RequestIncludingPost request){
        postRepository.findById(request.getPostId()).orElseThrow().builder().region(regionRepository.findByNameEquals(request.getRegion()).orElseThrow()).build();
    }

    // 지역 테이블에서 지역 삭제
    public void deleteRegionInTable(String region) {
        regionRepository.delete(regionRepository.findByNameEquals(region).orElseThrow());
    }
}
