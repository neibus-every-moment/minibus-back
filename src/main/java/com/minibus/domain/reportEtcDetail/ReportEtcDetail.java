package com.minibus.domain.reportEtcDetail;

import com.minibus.domain.report.Report;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "REPORT_ETC_DETAIL")
public class ReportEtcDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "REPORT_ID")
    private Report report;

    private String content;
}
