package com.minibus.moment.service;

import com.minibus.moment.domain.blind.Blind;
import com.minibus.moment.domain.blind.BlindRepository;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.report.Report;
import com.minibus.moment.domain.report.ReportRepository;
import com.minibus.moment.dto.api.admin.BlindPost;
import com.minibus.moment.dto.api.admin.RestorePost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BlindService {

    private final BlindRepository blindRepository;
    private final ReportRepository reportRepository;
    private final PostRepository postRepository;

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

}
