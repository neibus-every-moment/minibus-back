package com.minibus.moment.service;

import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.region.RegionRepository;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.dto.region.CreateRegion;
import com.minibus.moment.dto.region.RegionDto;
import com.minibus.moment.dto.region.UpdateRegion;
import com.minibus.moment.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
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

    // 지역 테이블에 새로운 지역 추가
    @Transactional
    public Integer createRegion(CreateRegion.Request request) {
        regionRepository.findByName(request.getRegionName())
                .ifPresent(r -> new RegionAlreadyExistException("이미 존재하는 지역 입니다."));
        Region region = Region.builder()
                .name(request.getRegionName())
                .build();
        return regionRepository.save(region).getId();
    }

    // 지역 테이블의 지역 이름 변경
    @Transactional
    public Integer updateRegion(Integer regionId, UpdateRegion.Request request){
        regionRepository.findByName(request.getRegionName())
                .ifPresent(t -> new RegionAlreadyExistException("이미 존재하는 지역 입니다."));
        Region region = regionRepository.findById(regionId).orElseThrow(
                () -> new RegionNotFoundException("지역이 존재하지 않습니다.")
        );
        return region.update(request.getRegionName());
    }

    // 지역 테이블에서 지역 삭제
    public boolean deleteRegion(Integer regionId) {
        Region region = regionRepository.findById(regionId).orElseThrow(
                () -> new RegionNotFoundException("지역이 존재하지 않습니다.")
        );
        regionRepository.delete(region);
        return true;
    }
}
