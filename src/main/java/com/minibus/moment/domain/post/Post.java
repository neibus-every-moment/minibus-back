package com.minibus.moment.domain.post;

import com.minibus.moment.domain.BaseTimeEntity;
import com.minibus.moment.domain.emoticon.Emoticon;
import com.minibus.moment.domain.image.Image;
import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.report.Report;
import com.minibus.moment.domain.transportation.Transportation;
import com.minibus.moment.type.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "TRANSPORT_ID")
    private Transportation transportation;

    @ManyToOne
    @JoinColumn(name = "EMOTICON_ID")
    private Emoticon emoticon;

    private Long likeCount;

    @OneToMany(mappedBy = "post")
    private List<Image> imageList = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Report> reportList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

    public void upLikeCount() {
        likeCount = getLikeCount()+1L;
    }
    public void downLikeCount(){
        likeCount = getLikeCount()-1L;
    }

}
