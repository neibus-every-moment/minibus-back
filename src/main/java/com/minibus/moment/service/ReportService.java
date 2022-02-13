package com.minibus.moment.service;

import com.minibus.moment.domain.comment.Comment;
import com.minibus.moment.domain.comment.CommentRepository;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.report.Report;
import com.minibus.moment.domain.report.ReportRepository;
import com.minibus.moment.domain.reportEtcDetail.ReportEtcDetail;
import com.minibus.moment.domain.reportEtcDetail.ReportEtcDetailRepository;
import com.minibus.moment.domain.reportReason.ReportReason;
import com.minibus.moment.domain.reportReason.ReportReasonRepository;
import com.minibus.moment.dto.ReportReasonDto;
import com.minibus.moment.dto.api.ReportComment;
import com.minibus.moment.dto.api.ReportPost;
import com.minibus.moment.exception.PostNotFoundException;
import com.minibus.moment.exception.ReportReasonNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.minibus.moment.type.ReportStatus.BEFORE;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final PostRepository postRepository;
    private final ReportReasonRepository reportReasonRepository;
    private final ReportRepository reportRepository;
    private final ReportEtcDetailRepository reportEtcDetailRepository;
    private final CommentRepository commentRepository;

    // 신고 사유 조회
    public List<ReportReasonDto> getReportReasonList() {
        return reportReasonRepository.findAll().stream()
                .map(ReportReasonDto::from)
                .collect(Collectors.toList());
    }

    // 글 신고 등록
    @Transactional
    public boolean reportPost(ReportPost.Request request) {
        ReportReason reportReason = reportReasonRepository.findByContent(request.getReportReason())
                .orElseThrow(() -> new ReportReasonNotFoundException("신고 사유가 존재하지 않습니다."));

        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new PostNotFoundException("해당 포스트를 찾지 못했습니다."));

        Report report = Report.builder()
                .reportReason(reportReason)
                .post(post)
                .reportStatus(BEFORE)
                .build();
        reportRepository.save(report);

        if (!ObjectUtils.isEmpty(request.getDetail())) {
            ReportEtcDetail reportEtcDetail = ReportEtcDetail.builder()
                    .report(report)
                    .content(request.getDetail())
                    .build();
            reportEtcDetailRepository.save(reportEtcDetail);
        }
        return true;
    }

    // 댓글 신고
    @Transactional
    public boolean reportComment(ReportComment.Request request) {
        ReportReason reportReason = reportReasonRepository.findByContent(request.getReportReason())
                .orElseThrow(() -> new ReportReasonNotFoundException("신고 사유가 존재하지 않습니다."));

        Comment comment = commentRepository.findById(request.getCommentId())
                .orElseThrow(() -> new PostNotFoundException("해당 포스트를 찾지 못했습니다."));

        Report report = Report.builder()
                .reportReason(reportReason)
                .comment(comment)
                .reportStatus(BEFORE)
                .build();
        reportRepository.save(report);

        //댓글 기타 신고
        if (!ObjectUtils.isEmpty(request.getDetail())) {
            ReportEtcDetail reportEtcDetail = ReportEtcDetail.builder()
                    .report(report)
                    .content(request.getDetail())
                    .build();
            reportEtcDetailRepository.save(reportEtcDetail);
        }
        return true;
    }
}
