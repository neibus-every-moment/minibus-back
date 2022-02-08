package com.minibus.moment.domain.reportReason;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportReasonRepository extends JpaRepository<ReportReason, Integer> {

    Optional<ReportReason> findByContent(String content);
}
