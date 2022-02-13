package com.minibus.moment.service;

import com.minibus.moment.domain.report.ReportReason;
import com.minibus.moment.domain.report.ReportReasonRepository;
import com.minibus.moment.domain.report.ReportRepository;
import com.minibus.moment.dto.report.CreateReportReason;
import com.minibus.moment.dto.report.UpdateReportReason;
import com.minibus.moment.exception.MinibusException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.minibus.moment.exception.MinibusErrorCode.DUPLICATED_REPORT_REASON;
import static com.minibus.moment.exception.MinibusErrorCode.REPORT_REASON_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportReasonRepository reportReasonRepository;
    private final ReportRepository reportRepository;

    // 신고사유 추가
    @Transactional
    public Integer createReportReason(CreateReportReason.Request request) {
        reportReasonRepository.findByContent(request.getContent()).ifPresent(
                reportReason -> new MinibusException(DUPLICATED_REPORT_REASON)
        );
        ReportReason reportReason = ReportReason.builder()
                .content(request.getContent())
                .build();
        return reportReasonRepository.save(reportReason).getId();
    }

    @Transactional
    public Integer updateReportReason(Integer reportReasonId, UpdateReportReason.Request request) {
        reportReasonRepository.findByContent(request.getContent()).ifPresent(
                reportReason -> new MinibusException(DUPLICATED_REPORT_REASON)
        );
        ReportReason reportReason = reportReasonRepository.findById(reportReasonId).orElseThrow(
                () -> new MinibusException(REPORT_REASON_NOT_FOUND)
        );
        return reportReason.update(request.getContent());
    }

    @Transactional
    public boolean deleteReportReason(Integer reportReasonId) {
        ReportReason reportReason = reportReasonRepository.findById(reportReasonId).orElseThrow(
                () -> new MinibusException(REPORT_REASON_NOT_FOUND)
        );
        reportReasonRepository.delete(reportReason);
        return true;
    }
}
