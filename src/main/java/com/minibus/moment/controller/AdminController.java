package com.minibus.moment.controller;


import com.minibus.moment.dto.RegionDto;
import com.minibus.moment.dto.ReportReasonDto;
import com.minibus.moment.dto.TransportationDto;
import com.minibus.moment.dto.api.admin.BlindPost;
import com.minibus.moment.dto.api.admin.RestorePost;
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

    @PutMapping("/transportationName")
    public void editTransportationName(@RequestBody TransportationDto.Request request) {
        transportationService.editTransportationNameInTable(request);
    }

    @PutMapping("/postTransportation")
    public void editPostTransportation(@RequestBody TransportationDto.Request request) {
        transportationService.editPostTransportation(request);
    }

    @DeleteMapping("/transportation")
    public void deleteTransportation(@RequestBody TransportationDto.Request request) {
        transportationService.deleteTransportationInTable(request);
    }

    // Region CRUD
    @PostMapping("/region")
    public void createRegion(@RequestBody RegionDto.Request request) {
        regionService.createRegion(request);
    }

    @PutMapping("/regionName")
    public void editRegionName(@RequestBody RegionDto.Request request) {
        regionService.editRegionNameInTable(request);
    }

    @PutMapping("/postRegion")
    public void editPostRegion(@RequestBody RegionDto.Request request) {
        regionService.editPostRegion(request);
    }

    @DeleteMapping("/region")
    public void deleteRegion(@RequestBody RegionDto.Request request) {
        regionService.deleteRegionInTable(request);
    }

    
    // ReportReason CRUD
    @PostMapping("/reportReason")
    public void createReportReason(@RequestBody ReportReasonDto.Request request) {
        blindService.createReportReason(request);
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