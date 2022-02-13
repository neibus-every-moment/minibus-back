package com.minibus.moment.service;


import com.minibus.moment.domain.like.LikePost;
import com.minibus.moment.domain.like.LikePostRepository;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.PostDto;
import com.minibus.moment.dto.api.ToLikePost;
import com.minibus.moment.exception.PostNotFoundException;
import com.minibus.moment.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LikePostService {

    private final LikePostRepository likePostRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 로그인 상태에서 LikePost 호출시 Like 여부 확인하여 좋아요/취소 진행
    @Transactional
    public Long toLikePost(Long postId,ToLikePost.Request request) throws Exception {
        // 유저정보
        User targetUser = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("해당 사용자를 찾지 못했습니다."));
        // Post 정보
        Post targetPost = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("해당 글을 찾지 못했습니다."));

        // 파라미터 정보로 LikePost 테이블에서 레코드 조회
        likePostRepository.findByPostAndUser(targetPost, targetUser).ifPresentOrElse(
                entity -> likePostRepository.delete(entity),
                () -> likePostRepository.save(
                        LikePost.builder()
                                .post(targetPost)
                                .user(targetUser)
                                .build()
                )
        );
        // 좋아요 후 갯수를 반환하려면(1 증감 확인)
        return likePostRepository.countAllByPost(postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("해당 글을 찾지 못했습니다.")));
        // Boolean 반환
        // return true;
    }

    // 유저 정보를 받아 유저가 좋아요 한 글 목록을 리스트로 반환
    public List<PostDto> getMyLikePostList(Long userId) {
        List<Post> likedPostList = likePostRepository.findAllByUserEquals(userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다.")))
                .stream().map(LikePost::getPost).collect(Collectors.toList());
        return likedPostList.stream().map(PostDto::from).collect(Collectors.toList());
    }
}
