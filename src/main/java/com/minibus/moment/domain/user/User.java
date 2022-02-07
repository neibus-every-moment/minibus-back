package com.minibus.moment.domain.user;

import com.minibus.moment.domain.like.LikePost;
import com.minibus.moment.domain.post.Post;
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
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String profileImage;

    private String nickname;

    @OneToMany(mappedBy = "user")
    private List<LikePost> likeList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Post> postList = new ArrayList<>();
}
