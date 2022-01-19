package com.minibus.moment.domain.report;

import com.minibus.moment.domain.BaseTimeEntity;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.reportCategory.ReportCategory;
import com.minibus.moment.domain.reportEtcDetail.ReportEtcDetail;
import com.minibus.moment.type.ReportStatus;
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
@Table(name = "REPORT")
public class Report extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "REPORT_CAT_ID")
    private ReportCategory reportCategory;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @OneToOne(mappedBy = "report")
    private ReportEtcDetail reportEtcDetail;

    private ReportStatus reportStatus;
}
