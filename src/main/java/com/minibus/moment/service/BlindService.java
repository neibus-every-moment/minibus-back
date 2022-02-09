package com.minibus.moment.service;

import com.minibus.moment.domain.blind.Blind;
import com.minibus.moment.domain.blind.BlindRepository;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.report.Report;
import com.minibus.moment.domain.report.ReportRepository;
import com.minibus.moment.domain.reportReason.ReportReason;
import com.minibus.moment.domain.reportReason.ReportReasonRepository;
import com.minibus.moment.dto.ReportReasonDto;
import com.minibus.moment.dto.api.admin.BlindPost;
import com.minibus.moment.dto.api.admin.RestorePost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlindService {

    private final BlindRepository blindRepository;
    private final ReportRepository reportRepository;
    private final PostRepository postRepository;
    private final ReportReasonRepository reportReasonRepository;

    @Transactional
    public boolean blindPost(BlindPost.Request request){

        Post post = postRepository.findById(request.getId()).orElseThrow(
                // Todo 예외 처리
        );

        Blind blind = Blind.builder()
                .post(post)
                .content(request.getContent())
                .build();
        blindRepository.save(blind);
        post.blind();
        checkReport(post);

        return true;
    }

    @Transactional
    public void checkReport(Post post){
        reportRepository.findByPost(post).ifPresent(Report::complete);
    }

    @Transactional
    public boolean restorePost(RestorePost.Request request){
        Post post = postRepository.findById(request.getId()).orElseThrow(
                // Todo 예외 처리
        );
        post.restore();

        Blind blind = blindRepository.findByPost(post).orElseThrow(
                // Todo 예외 처리
        );
        blindRepository.delete(blind);

        return true;
    }

    
    // ReportReason CRUD
    // 신고사유 테이블에 새로운 신고사유 추가
    public void newReportReason(ReportReasonDto.Request request) {
        // 등록하려는 reportReason 이 이미 테이블에 있는지 확인하고 없으면 추가 있으면 throw reportReasonAlreadyExist
        Optional<ReportReason> reportReason = reportReasonRepository.findByContent(request.getReportReason());
        if(!reportReason.isPresent()) {
            reportReasonRepository.save(ReportReason.builder()
                    .content(request.getReportReason())
                    .build());
        } else {
            // reportReasonAlreadyExistException
        }
    }

    // 신고사유 테이블의 신고사유 이름 변경
    @Transactional
    public void editReportReasonContentInTable(ReportReasonDto.Request request){
        // 등록하려는 reportReason 검색하여 이름 변경, 이미 테이블에 있는 명칭으로는 변경 불가
        Optional<ReportReason> reportReason = reportReasonRepository.findByContent(request.getReportReason());
        if(!reportReason.isPresent()) {
            reportReasonRepository.findById(request.getId()).ifPresent(
                    entity -> entity.setContent(request.getReportReason())
            );
        } else {
            // reportReasonAlreadyExistException
        }
    }

    // Report 의 신고사유 변경
    @Transactional
    public void editReportReasonInReport(ReportReasonDto.Request request){
        reportRepository.findById(request.getReportId()).ifPresentOrElse(
                entity -> entity.setReportReason(reportReasonRepository.findByContent(request.getReportReason()).orElseThrow()),
                () -> new Exception() //ReportNotExistException
        );
    }

    // 신고사유 테이블에서 신고사유 삭제
    public void deleteReportReasonInTable(ReportReasonDto.Request request) {
        reportReasonRepository.findByContent(request.getReportReason()).ifPresentOrElse(
                entity -> reportReasonRepository.delete(entity),
                () -> new Exception() //reportReasonNotExistException
        );
    }
}
