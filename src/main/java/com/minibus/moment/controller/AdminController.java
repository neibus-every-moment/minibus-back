package com.minibus.moment.controller;


import com.minibus.moment.dto.region.CreateRegion;
import com.minibus.moment.dto.region.UpdateRegion;
import com.minibus.moment.dto.report.CreateReportReason;
import com.minibus.moment.dto.report.ReportReasonDto;
import com.minibus.moment.dto.report.UpdateReportReason;
import com.minibus.moment.dto.transportation.CreateTransportation;
import com.minibus.moment.dto.admin.BlindPost;
import com.minibus.moment.dto.admin.RestorePost;
import com.minibus.moment.dto.transportation.UpdateTransportation;
import com.minibus.moment.service.BlindService;
import com.minibus.moment.service.RegionService;
import com.minibus.moment.service.ReportService;
import com.minibus.moment.service.TransportationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/admin")
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final TransportationService transportationService;
    private final RegionService regionService;
    private final ReportService reportService;
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
    public boolean deleteTransportation(@PathVariable Integer transportationId) {
        return transportationService.deleteTransportation(transportationId);
    }

    // Region CRUD
    @PostMapping("/region")
    public CreateRegion.Response createRegion(@RequestBody CreateRegion.Request request) {
        return new CreateRegion.Response(regionService.createRegion(request));
    }

    @PutMapping("/region/{regionId}")
    public UpdateRegion.Response updateRegion(
            @PathVariable Integer regionId,
            @RequestBody UpdateRegion.Request request) {
        return new UpdateRegion.Response(regionService.updateRegion(regionId,request));
    }

    @DeleteMapping("/region/{regionId}")
    public boolean deleteRegion(@PathVariable Integer regionId) {
        return regionService.deleteRegion(regionId);
    }

    // ReportReason CRUD
    @PostMapping("/reportReason")
    public CreateReportReason.Response createReportReason(@RequestBody CreateReportReason.Request request) {
        return new CreateReportReason.Response(reportService.createReportReason(request));
    }

    @PutMapping("/reportReason/{reportReasonId}")
    public UpdateReportReason.Response updateReportReason(
            @PathVariable Integer reportReasonId,
            @RequestBody UpdateReportReason.Request request
    ) {
        return new UpdateReportReason.Response(reportService.updateReportReason(reportReasonId,request));
    }

    @DeleteMapping("/reportReason/{reportReasonId}")
    public boolean deleteReportReason(@PathVariable Integer reportReasonId) {
        return reportService.deleteReportReason(reportReasonId);
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