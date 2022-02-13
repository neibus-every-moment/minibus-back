package com.minibus.moment.controller;

import com.minibus.moment.dto.api.GetReportReasonList;
import com.minibus.moment.dto.api.ReportComment;
import com.minibus.moment.dto.api.ReportPost;
import com.minibus.moment.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReportController {

    private final ReportService reportService;

    //신고 사유 조회
    @GetMapping("/reasons")
    public GetReportReasonList.Response getReportReasonList() {
        return GetReportReasonList.Response.toResponse(reportService.getReportReasonList());
    }

    //글 신고
    @PostMapping("/report")
    public boolean reportPost(@RequestBody ReportPost.Request request) {
        return reportService.reportPost(request);
    }

    // 댓글 신고
    @PostMapping("/comment/report")
    public boolean reportComment(@RequestBody ReportComment.Request request){
        return reportService.reportComment(request);
    }
}
