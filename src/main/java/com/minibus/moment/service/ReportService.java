package com.minibus.moment.service;

import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.report.Report;
import com.minibus.moment.domain.report.ReportRepository;
import com.minibus.moment.domain.reportCategory.ReportCategory;
import com.minibus.moment.domain.reportCategory.ReportCategoryRepository;
import com.minibus.moment.domain.reportEtcDetail.ReportEtcDetail;
import com.minibus.moment.dto.ReportDto;
import com.minibus.moment.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final ReportCategoryRepository reportCategoryRepository;
    private final PostRepository postRepository;

//    public boolean reportPost(int reportCategoryId, Long postId) {
//        ReportCategory ReportCategoryId = reportCategoryRepository.findById(reportCategoryId)
//                .orElseThrow();

//        Post poId = postRepository.findById(postId)
//                .orElseThrow(() -> new PostNotFoundException("해당 게시글을 찾을 수 없습니다."));
//
//        Report report = Report.builder()
//                .post(poId)
//                .reportCategory(ReportCategoryId)
//                .reportEtcDetail()
//                .reportStatus()
//                .build();
//
//        reportRepository.save(report);
//        if (report.getId() == null) {
//            return false;
//        }
//        return true;
//    }
}