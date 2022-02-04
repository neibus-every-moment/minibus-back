package com.minibus.moment.domain.post;

import com.minibus.moment.type.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    Post post = Post.builder()
            .content("test")
            .build();

    @DisplayName("1. 포스트 리스트 조회(페이지를 통한 소팅)")
    @Test
    public void getPostListTest() {
        //given
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "likeCount"));
        //when
        List<Post> postList = postRepository.findAllByStatus(Status.VISIBLE, pageRequest);

        //then
        assertEquals(postList.get(0).getLikeCount(), 100L);
    }
}