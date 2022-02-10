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
import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.CommentDto;
import com.minibus.moment.dto.api.CreateComment;
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

@RequiredArgsConstructor
@Service
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    private final ReportReasonRepository reportReasonRepository;
    private final ReportRepository reportRepository;
    private final ReportEtcDetailRepository reportEtcDetailRepository;

    public List<CommentDto> getCommentList(Long postId){

        Post post = postRepository.findById(postId).orElseThrow();

        return commentRepository.findAllByPost(post)
                .stream().map(CommentDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long createComment(CreateComment.Request request){
        Post post = postRepository.findById(request.getPostId()).orElseThrow();
        User user = userRepository.findById(request.getUserId()).orElseThrow();

        Comment comment = Comment.builder()
                .content(request.getContent())
                .user(user)
                .post(post)
                .build();

        return commentRepository.save(comment).getId();
    }

    public List<CommentDto> getCommentListByUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow();

        return commentRepository.findAllByUser(user)
                .stream().map(CommentDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean reportComment(ReportComment.Request request) {
        ReportReason reportReason = reportReasonRepository.findByContent(request.getReportReason())
                .orElseThrow(() -> new ReportReasonNotFoundException("신고 사유가 존재하지 않습니다.")
                );
        Comment comment = commentRepository.findById(request.getCommentId())
                .orElseThrow(() -> new PostNotFoundException("해당 포스트를 찾지 못했습니다.")
                );

        Report report = Report.builder()
                .reportReason(reportReason)
                .comment(comment)
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

    @Transactional
    public Long updateComment(Long commentId, String content){
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        return comment.update(content);
    }

    @Transactional
    public boolean deleteComment(Long commentId){
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        commentRepository.delete(comment);
        return true;
    }
}
