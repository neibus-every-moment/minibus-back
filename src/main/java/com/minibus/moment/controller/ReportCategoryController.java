package com.minibus.moment.controller;

import com.minibus.moment.dto.RegionDto;
import com.minibus.moment.dto.ReportCategoryDto;
import com.minibus.moment.service.RegionService;
import com.minibus.moment.service.ReportCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ReportCategoryController {

    private final ReportCategoryService reportCategoryService;

    @GetMapping("/reportCategory/list")
    public ReportCategoryDto getReportCategoryList() {
        ReportCategoryDto reportCategoryList = reportCategoryService.getReportCategoryList();
        return reportCategoryList;
    }
}
