package com.minibus.moment.controller;

import com.minibus.moment.dto.RegionDto;
import com.minibus.moment.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/region/list")
    public RegionDto getRegionList() {
        RegionDto regionList = regionService.getRegionList();
        return regionList;
    }
}
