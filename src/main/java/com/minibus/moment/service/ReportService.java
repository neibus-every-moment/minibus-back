package com.minibus.moment.service;

import com.minibus.moment.domain.report.ReportRepository;
import com.minibus.moment.domain.reportReason.ReportReason;
import com.minibus.moment.domain.reportReason.ReportReasonRepository;
import com.minibus.moment.dto.report.CreateReportReason;
import com.minibus.moment.dto.report.UpdateReportReason;
import com.minibus.moment.exception.ReportReasonAlreadyExistException;
import com.minibus.moment.exception.ReportReasonNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportReasonRepository reportReasonRepository;
    private final ReportRepository reportRepository;

    // 신고사유 추가
    @Transactional
    public Integer createReportReason(CreateReportReason.Request request) {
        reportReasonRepository.findByContent(request.getContent()).ifPresent(
                reportReason -> new ReportReasonAlreadyExistException("해당 신고사유가 이미 존재합니다.")
        );
        ReportReason reportReason = ReportReason.builder()
                .content(request.getContent())
                .build();
        return reportReasonRepository.save(reportReason).getId();
    }

    @Transactional
    public Integer updateReportReason(Integer reportReasonId, UpdateReportReason.Request request) {
        reportReasonRepository.findByContent(request.getContent()).ifPresent(
                reportReason -> new ReportReasonAlreadyExistException("해당 신고사유가 이미 존재합니다.")
        );
        ReportReason reportReason = reportReasonRepository.findById(reportReasonId).orElseThrow(
                () -> new ReportReasonNotFoundException("해당 신고사유가 존재하지 않습니다.")
        );
        return reportReason.update(request.getContent());
    }

    @Transactional
    public boolean deleteReportReason(Integer reportReasonId) {
        ReportReason reportReason = reportReasonRepository.findById(reportReasonId).orElseThrow(
                () -> new ReportReasonNotFoundException("해당 신고사유가 존재하지 않습니다.")
        );
        reportReasonRepository.delete(reportReason);
        return true;
    }
}
