package com.minibus.moment.controller;

import com.minibus.moment.dto.api.GetTransportationList;
import com.minibus.moment.service.TransportationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class TransportationController {

    private final TransportationService transportationService;

    //대중교통 목록 조회
    @GetMapping("/transportations")
    public GetTransportationList.Response getTransportationList() {
        return GetTransportationList.Response.toResponse(transportationService.getTransportationList());
    }
}
