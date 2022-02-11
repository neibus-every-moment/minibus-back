package com.minibus.moment.domain.user;


import com.minibus.moment.domain.comment.Comment;
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

    private AuthProvider provider;

    @OneToMany(mappedBy = "user")
    private List<LikePost> likeList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Role role;

    public User update(String nickname, String profileImage) {
        this.nickname = nickname;
        this.profileImage = profileImage;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

//    public String getProvider() {
//    }
}
