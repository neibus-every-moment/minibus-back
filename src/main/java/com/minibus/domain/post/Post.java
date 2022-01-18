package com.minibus.domain.post;

import com.minibus.domain.BaseTimeEntity;
import com.minibus.domain.emoticon.Emoticon;
import com.minibus.domain.image.Image;
import com.minibus.domain.region.Region;
import com.minibus.domain.report.Report;
import com.minibus.domain.transport.Transport;
import com.minibus.type.PostStatus;
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
    @JoinColumn(name = "TRANSPROT_ID")
    private Transport transport;

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
}
