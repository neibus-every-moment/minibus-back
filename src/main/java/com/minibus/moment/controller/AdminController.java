package com.minibus.moment.controller;


import com.minibus.moment.dto.RegionDto;
import com.minibus.moment.dto.TransportationDto;
import com.minibus.moment.service.RegionService;
import com.minibus.moment.service.TransportationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.minibus.moment.dto.api.admin.BlindPost;
import com.minibus.moment.dto.api.admin.RestorePost;
import com.minibus.moment.service.BlindService;


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

    private final BlindService blindService;

    @PostMapping("/blind")
    public boolean blindPost(@RequestBody BlindPost.Request request){
        return blindService.blindPost(request);
    }

    @PostMapping("/restore")
    public boolean restorePost(@RequestBody RestorePost.Request request){
        return blindService.restorePost(request);
    }
}