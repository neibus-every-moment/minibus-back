package com.minibus.moment.controller;

import com.minibus.moment.domain.reportEtcDetail.ReportEtcDetail;
import com.minibus.moment.dto.ReportDto;
import com.minibus.moment.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    //    @PostMapping("/post/report")
//    public boolean reportPost(@RequestBody int reportCategoryId, Long postId, ReportEtcDetail content) {
//        boolean report = reportService.reportPost(reportCategoryId, postId, content);
//        if (!report) {
//            return false;
//        }
//        return true;
//    }

    @PostMapping("/post/report")
    public boolean reportPost(@RequestBody ReportDto reportDto) {
        boolean report = reportService.reportPost(reportDto);
        if (!report) {
            return false;
        }
        return true;
    }
}
