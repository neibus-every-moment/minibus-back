package com.minibus.moment.domain.report;

import com.minibus.moment.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {

    boolean findByReportCategoryAndPost(Report report, Post post);
}
