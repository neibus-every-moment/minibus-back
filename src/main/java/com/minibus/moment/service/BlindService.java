package com.minibus.moment.service;

import com.minibus.moment.domain.blind.Blind;
import com.minibus.moment.domain.blind.BlindRepository;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.report.Report;
import com.minibus.moment.domain.report.ReportRepository;
import com.minibus.moment.dto.admin.BlindPost;
import com.minibus.moment.dto.admin.RestorePost;
import com.minibus.moment.exception.MinibusException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.minibus.moment.exception.MinibusErrorCode.BLIND_NOT_FOUND;
import static com.minibus.moment.exception.MinibusErrorCode.POST_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class BlindService {

    private final BlindRepository blindRepository;
    private final ReportRepository reportRepository;
    private final PostRepository postRepository;

    @Transactional
    public Long blindPost(BlindPost.Request request) {

        Post post = postRepository.findById(request.getId()).orElseThrow(
                () -> new MinibusException(POST_NOT_FOUND)
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
    public void checkReport(Post post) {
        reportRepository.findByPost(post).ifPresent(Report::complete);
    }

    @Transactional
    public Long restorePost(RestorePost.Request request) {
        Post post = postRepository.findById(request.getId()).orElseThrow(
                () -> new MinibusException(POST_NOT_FOUND)
        );
        post.restore();

        Blind blind = blindRepository.findByPost(post).orElseThrow(
                () -> new MinibusException(BLIND_NOT_FOUND)
        );
        blindRepository.delete(blind);

        return post.getId();
    }


}
