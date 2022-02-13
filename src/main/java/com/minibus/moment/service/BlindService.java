package com.minibus.moment.service;

import com.minibus.moment.domain.blind.Blind;
import com.minibus.moment.domain.blind.BlindRepository;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.report.Report;
import com.minibus.moment.domain.report.ReportRepository;
import com.minibus.moment.domain.reportReason.ReportReason;
import com.minibus.moment.domain.reportReason.ReportReasonRepository;
import com.minibus.moment.dto.report.ReportReasonDto;
import com.minibus.moment.dto.admin.BlindPost;
import com.minibus.moment.dto.admin.RestorePost;
import com.minibus.moment.exception.BlindNotFoundException;
import com.minibus.moment.exception.PostNotFoundException;
import com.minibus.moment.exception.ReportReasonAlreadyExistException;
import com.minibus.moment.exception.ReportReasonNotFoundException;
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
                () -> new PostNotFoundException("해당 포스트를 찾지 못했습니다.")// Todo 예외 처리
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
                () -> new PostNotFoundException("해당 글을 찾지 못했습니다.")// Todo 예외 처리
        );
        post.restore();

        Blind blind = blindRepository.findByPost(post).orElseThrow(
                () -> new BlindNotFoundException("신고 사유를 선택해주세요")// Todo 예외 처리
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
            throw new ReportReasonAlreadyExistException("해당 신고사유가 이미 존재합니다.");// reportReasonAlreadyExistException
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
            throw new ReportReasonAlreadyExistException("해당 신고사유가 이미 존재합니다.");// reportReasonAlreadyExistException
        }
    }

    // Report 의 신고사유 변경
    @Transactional
    public void editReportReasonInReport(ReportReasonDto.Request request){
        reportRepository.findById(request.getReportId()).ifPresentOrElse(
                entity -> entity.setReportReason(reportReasonRepository.findByContent(request.getReportReason()).orElseThrow()),
                () -> new ReportReasonNotFoundException("존재하지않는 신고 사유입니다.") //ReportNotExistException
        );
    }

    // 신고사유 테이블에서 신고사유 삭제
    public void deleteReportReasonInTable(ReportReasonDto.Request request) {
        reportReasonRepository.findByContent(request.getReportReason()).ifPresentOrElse(
                entity -> reportReasonRepository.delete(entity),
                () -> new ReportReasonNotFoundException("해당 신고사유를 찾지 못했습니다.") //reportReasonNotExistException
        );
    }
}
