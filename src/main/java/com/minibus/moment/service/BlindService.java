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

    @Transactional
    public Long blindPost(BlindPost.Request request){

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

        return post.getId();
    }

    @Transactional
    public void checkReport(Post post){
        reportRepository.findByPost(post).ifPresent(Report::complete);
    }

    @Transactional
    public Long restorePost(RestorePost.Request request){
        Post post = postRepository.findById(request.getId()).orElseThrow(
                () -> new PostNotFoundException("해당 글을 찾지 못했습니다.")// Todo 예외 처리
        );
        post.restore();

        Blind blind = blindRepository.findByPost(post).orElseThrow(
                () -> new BlindNotFoundException("신고 사유를 선택해주세요")// Todo 예외 처리
        );
        blindRepository.delete(blind);

        return post.getId();
    }


}
