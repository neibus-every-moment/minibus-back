package com.minibus.moment.controller;

import com.minibus.moment.domain.transport.Transport;
import com.minibus.moment.dto.TransportDto;
import com.minibus.moment.service.TransService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class TransController {

    private final TransService transService;

    @GetMapping("/transport/list")
    public TransportDto getTransportList() {
        TransportDto transportList = transService.getTransportList();
        return transportList;
    }
}
