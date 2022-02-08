package com.minibus.moment.domain.user;


import lombok.*;
import com.minibus.moment.domain.like.LikePost;
import com.minibus.moment.domain.post.Post;

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

    @Enumerated(EnumType.STRING)
    private Role role;
    
    public User update(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
