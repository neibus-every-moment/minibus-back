package com.minibus.moment.service;

import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.report.Report;
import com.minibus.moment.domain.report.ReportRepository;
import com.minibus.moment.domain.reportCategory.ReportCategory;
import com.minibus.moment.domain.reportCategory.ReportCategoryRepository;
import com.minibus.moment.domain.reportEtcDetail.ReportEtcDetail;
import com.minibus.moment.dto.ReportDto;
import com.minibus.moment.dto.ReportEtcDetailDto;
import com.minibus.moment.exception.PostNotFoundException;
import com.minibus.moment.type.PostStatus;
import com.minibus.moment.type.ReportStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final ReportCategoryRepository reportCategoryRepository;
    private final PostRepository postRepository;

    public boolean reportPost(@RequestBody ReportDto reportDto) {
        ReportCategory reportCatId = reportCategoryRepository.findById(reportDto.getReportCategoryId())
                .orElseThrow();

        Post poId = postRepository.findById(reportDto.getId())
                .orElseThrow(() -> new PostNotFoundException("해당 게시글을 찾을 수 없습니다."));

        Report report = Report.builder()
                .post(poId)
                .reportCategory(reportCatId)
                .reportEtcDetail(reportDto.getReportEtcDetail())
                .reportStatus(ReportStatus.BEFORE)
                .build();

        reportRepository.save(report);
        if (report.getId() == null) {
            return false;
        }
        return true;
    }
}