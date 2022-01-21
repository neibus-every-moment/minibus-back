package com.minibus.moment.service;

import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.region.RegionRepository;
import com.minibus.moment.dto.RegionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionDto getRegionList() {
        List<Region> regions = regionRepository.findAll();
        return RegionDto.builder()
                .data(regions)
                .build();
    }
}
