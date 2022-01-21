package com.minibus.moment.domain.reportEtcDetail;

import com.minibus.moment.domain.report.Report;
import lombok.*;

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
