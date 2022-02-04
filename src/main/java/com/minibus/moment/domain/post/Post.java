package com.minibus.moment.domain.post;

import com.minibus.moment.domain.BaseTimeEntity;
import com.minibus.moment.domain.image.Image;
import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.report.Report;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.type.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.minibus.moment.type.Status.BLIND;
import static com.minibus.moment.type.Status.VISIBLE;


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

    private Long likeCount;

    @OneToMany(mappedBy = "post")
    private List<Image> imageList = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Report> reportList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Status status;

    public Long update(String content) {
        this.content = content;
        return id;
    }

    public void blind() {
        status = BLIND;
    }

    public void restore(){
        status = VISIBLE;
    }
}
