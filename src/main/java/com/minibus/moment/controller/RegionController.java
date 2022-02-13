package com.minibus.moment.controller;

import com.minibus.moment.dto.api.GetRegionList;
import com.minibus.moment.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class RegionController {

    private final RegionService regionService;

    //지역 목록 조회
    @GetMapping("/regions")
    public GetRegionList.Response getRegionList() {
        return GetRegionList.Response.toResponse(regionService.getRegionList());
    }
}
