package com.minibus.moment.controller;


import com.minibus.moment.dto.region.RegionDto;
import com.minibus.moment.dto.report.ReportReasonDto;
import com.minibus.moment.dto.transportation.CreateTransportation;
import com.minibus.moment.dto.admin.BlindPost;
import com.minibus.moment.dto.admin.RestorePost;
import com.minibus.moment.dto.transportation.UpdateTransportation;
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
    public CreateTransportation.Response createTransportation(@RequestBody CreateTransportation.Request request) {
        return new CreateTransportation.Response(transportationService.createTransportation(request));
    }

    @PutMapping("/transportation/{transportationId}")
    public UpdateTransportation.Response updateTransportation(
            @PathVariable Integer transportationId,
            @RequestBody UpdateTransportation.Request request) {
        return new UpdateTransportation.Response(transportationService.updateTransportation(transportationId,request));
    }

    @DeleteMapping("/transportation/{transportationId}")
    public void deleteTransportation(@PathVariable Integer transportationId) {
        transportationService.deleteTransportation(transportationId);
    }


    // Region CRUD
    @PostMapping("/region")
    public void newRegion(@RequestBody RegionDto.Request request) {
        regionService.newRegion(request);
    }

    @PutMapping("/region/{regionId}")
    public void editRegionName(@RequestBody RegionDto.Request request) {
        regionService.editRegionNameInTable(request);
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