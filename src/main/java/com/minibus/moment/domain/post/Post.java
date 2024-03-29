package com.minibus.moment.domain.post;

import com.minibus.moment.domain.BaseTimeEntity;
import com.minibus.moment.domain.comment.Comment;
import com.minibus.moment.domain.image.Image;
import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.report.Report;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.type.Status;
import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.minibus.moment.type.Status.BLIND;
import static com.minibus.moment.type.Status.VISIBLE;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "POST")
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "TRANSPORT_ID")
    private Transportation transportation;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<LikePost> likePostList = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Image> imageList = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Report> reportList = new ArrayList<>();

    @Basic(fetch = FetchType.LAZY)
    @Formula("(select count(1) from like_post c where c.post_id = id)")
    private Long likeCount;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Long update(String content) {
        this.content = content;
        return id;
    }

    public void blind() {
        status = BLIND;
    }

    public void restore() {
        status = VISIBLE;
    }
}
