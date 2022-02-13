package com.minibus.moment.controller;


import com.minibus.moment.dto.region.RegionDto;
import com.minibus.moment.dto.report.ReportReasonDto;
import com.minibus.moment.dto.transportation.TransportationDto;
import com.minibus.moment.dto.admin.BlindPost;
import com.minibus.moment.dto.admin.RestorePost;
import com.minibus.moment.service.BlindService;
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
    private final BlindService blindService;

    // Transportation CRUD
    @PostMapping("/transportation")
    public void createTransportation(@RequestBody TransportationDto.Request request) {
        transportationService.createTransportation(request);
    }

    @PutMapping("/transportation/{transportationId}")
    public void editTransportationName(@RequestBody TransportationDto.Request request) {
        transportationService.editTransportationNameInTable(request);
    }

    // 포스트에 있는 교통수단 카테고리 수정
    public void editPostTransportation(@RequestBody TransportationDto.Request request) {
        transportationService.editPostTransportation(request);
    }

    @DeleteMapping("/transportation")
    public void deleteTransportation(@RequestBody TransportationDto.Request request) {
        transportationService.deleteTransportationInTable(request);
    }


    // Region CRUD
    @PostMapping("/region")
    public void newRegion(@RequestBody RegionDto.Request request) {
        regionService.newRegion(request);
    }

    @PutMapping("/regionName")
    public void editRegionName(@RequestBody RegionDto.Request request) {
        regionService.editRegionNameInTable(request);
    }

    // 포스트에 있는 지역 카테고리 수정
    public void editPostRegion(@RequestBody RegionDto.Request request) {
        regionService.editPostRegion(request);
    }

    @DeleteMapping("/region")
    public void deleteRegion(@RequestBody RegionDto.Request request) {
        regionService.deleteRegionInTable(request);
    }

    
    // ReportReason CRUD
    @PostMapping("/reportReason")
    public void newReportReason(@RequestBody ReportReasonDto.Request request) {
        blindService.newReportReason(request);
    }

    @PutMapping("/reportReasonName")
    public void editReportReasonName(@RequestBody ReportReasonDto.Request request) {
        blindService.editReportReasonContentInTable(request);
    }

    @PutMapping("/postReportReason")
    public void editPostReportReason(@RequestBody ReportReasonDto.Request request) {
        blindService.editReportReasonInReport(request);
    }

    @DeleteMapping("/reportReason")
    public void deleteReportReason(@RequestBody ReportReasonDto.Request request) {
        blindService.deleteReportReasonInTable(request);
    }
    
    
    // Blind CRUD
    @PostMapping("/blind")
    public boolean blindPost(@RequestBody BlindPost.Request request){
        return blindService.blindPost(request);
    }

    @PostMapping("/restore")
    public boolean restorePost(@RequestBody RestorePost.Request request){
        return blindService.restorePost(request);
    }



}