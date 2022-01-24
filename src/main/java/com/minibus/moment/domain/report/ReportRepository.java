package com.minibus.moment.domain.report;

import com.minibus.moment.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Long> {

    Optional<Report> findByPost(Post post);
}
