package com.minibus.moment.controller;

import com.minibus.moment.dto.RegionDto;
import com.minibus.moment.dto.TransportationDto;
import com.minibus.moment.service.RegionService;
import com.minibus.moment.service.TransportationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/admin")
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final TransportationService transportationService;
    private final RegionService regionService;

    @PostMapping("/new/transportation")
    public boolean newTransportation(@RequestBody TransportationDto.Request request) {
        return transportationService.newTransportation(request);
    }

    @PutMapping("/edit/transportationName")
    public void editTransportationName(@RequestBody TransportationDto.Request request) {
        transportationService.editTransportationNameInTable(request);
    }

    @PutMapping("/edit/postTransportation")
    public void editPostTransportation(@RequestBody TransportationDto.RequestIncludingPost request) {
        transportationService.editTransportationInPost(request);
    }

    @DeleteMapping("delete/transportation")
    public void deleteTransportation(@RequestBody TransportationDto.Request request) {
        transportationService.deleteTransportationInTable(request);
    }


    @PostMapping("/new/region")
    public boolean newRegion(@RequestBody RegionDto.Request request) {
        return regionService.newRegion(request);
    }

    @PutMapping("/edit/regionName")
    public void editRegionName(@RequestBody RegionDto.Request request) {
        regionService.editRegionNameInTable(request);
    }

    @PutMapping("/edit/postRegion")
    public void editPostRegion(@RequestBody RegionDto.RequestIncludingPost request) {
        regionService.editRegionInPost(request);
    }

    @DeleteMapping("delete/region")
    public void deleteRegion(@RequestBody RegionDto.Request request) {
        regionService.deleteRegionInTable(request.getRegion());
    }

}
//이모티콘 / 지역 / 교통 수정 및 삭제기능 추가하였습니다.
//
//1. 이모티콘
// - 프론트와 협의하 이모티콘 리스트는 자체 구현하는것으로 갈음
// - 이모티콘 엔티티에 name 만 있으면 되므로 이모지 컬럼 및 관련 코드 삭제
// - 이모티콘 테이블에 없는 이모티콘으로 등록 요청 시 새로 이모티콘 새로 등록
//
//2. 지역/교통
// - 테이블에서 지역/교통 이름 수정
// - 포스트에서 지역/교통 수정
// - 삭제