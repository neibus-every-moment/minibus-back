package com.minibus.moment.service;

import com.minibus.moment.domain.region.RegionRepository;
import com.minibus.moment.dto.RegionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public List<RegionDto> getRegionList() {
        return regionRepository.findAll().stream()
                .map(RegionDto::from)
                .collect(Collectors.toList());
    }

    // Todo  지역 추가, 업데이트, 삭제 메서드 구현
}
