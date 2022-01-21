package com.minibus.moment.controller;

import com.minibus.moment.dto.EmoticonDto;
import com.minibus.moment.service.EmoticonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class EmoticonController {

    private final EmoticonService emoticonService;

    @GetMapping("/transport/list")
    public EmoticonDto getTransportList() {
        EmoticonDto emoticonList = emoticonService.getEmoticonList();
        return emoticonList;
    }
}
