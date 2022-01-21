package com.minibus.moment.controller;

import com.minibus.moment.dto.ReportDto;
import com.minibus.moment.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

//    public boolean reportPost(int reportCategoryId, Long postId, ReportDto reportDto) {
//        boolean report = reportService.reportPost(reportCategoryId, postId, reportDto);
//        if (!report) {
//            return false;
//        }
//        return true;
//    }
}
