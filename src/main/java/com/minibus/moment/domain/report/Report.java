package com.minibus.moment.domain.report;

import com.minibus.moment.domain.BaseTimeEntity;
import com.minibus.moment.domain.comment.Comment;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.reportEtcDetail.ReportEtcDetail;
import com.minibus.moment.domain.reportReason.ReportReason;
import com.minibus.moment.domain.user.User;
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
    @JoinColumn(name = "REPORT_REASON_ID")
    private ReportReason reportReason;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;

    @OneToOne(mappedBy = "report")
    private ReportEtcDetail reportEtcDetail;

    @Enumerated(EnumType.STRING)
    private ReportStatus reportStatus;

    public void complete() {
        reportStatus = ReportStatus.COMPLETE;
    }

    public void keep() {
        reportStatus = ReportStatus.KEEP;
    }

}
