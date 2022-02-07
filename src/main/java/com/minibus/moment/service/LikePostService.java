package com.minibus.moment.service;

import com.minibus.moment.domain.like.LikePost;
import com.minibus.moment.domain.like.LikePostRepository;
import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.LikePostDto;
import com.minibus.moment.dto.PostDto;
import com.minibus.moment.dto.api.GetPostList;
import com.minibus.moment.type.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
    public LikePostDto likePost(Long postId, Long userId) throws Exception {

        // 로그인 체크
        if(userId == null) {
            throw new Exception("user not found");
        }

        // 유저정보
        User targetUser = userRepository.findById(userId).orElseThrow();
        // Post 정보
        Post targetPost = postRepository.findById(postId).orElseThrow();
        // Post 의 LikeCount
        Long prevLikeValue = targetPost.getLikeCount();

        // 파라미터 정보로 LikePost 테이블에서 레코드 조회
        LikePost likeCheck = likePostRepository.findAllByPostEqualsAndUserEquals(targetPost, targetUser);

        // 해당 게시글 좋아요 여부 확인하여 좋아요 이력이 없으면 좋아요 진행하고 LikePostDto 반환
        if(likeCheck == null) {
            LikePost plusLikeCount = LikePost.builder()
                    .post(targetPost)
                    .user(targetUser)
                    .build();
            likePostRepository.save(plusLikeCount);

            // 해당 Post 기존 LikeValue 에 1 추가
            targetPost.setLikeCount(prevLikeValue + 1L);

            LikePostDto response = LikePostDto.builder()
                    .postId(plusLikeCount.getPost().getId())
                    .userId(plusLikeCount.getUser().getId())
                    .likeStatus("좋아요 완료")
                    .postLikeCount(targetPost.getLikeCount())
                    .build();
            return response;
        } else {
            // 좋아요 이력이 있으면 좋아요 취소 진행
            likePostRepository.delete(likeCheck);
            targetPost.setLikeCount(prevLikeValue - 1L);
            LikePostDto response = LikePostDto.builder()
                    .postId(likeCheck.getPost().getId())
                    .userId(likeCheck.getUser().getId())
                    .likeStatus("좋아요 취소 완료")
                    .postLikeCount(targetPost.getLikeCount())
                    .build();
            return response;
        }
    }

    // 유저 정보를 받아 유저가 좋아요 한 글 ID를 리스트로 반환 //LikePostDto 출력
    public List<Long> likePostList(Long userId) {
        // 글 정보를 DTO로 반환한다면
        //return likePostRepository.findAllByUserEquals(userRepository.findById(userId).orElseThrow()).stream().map(LikePostDto::from).collect(Collectors.toList());
        List<LikePost> list = likePostRepository.findAllByUserEquals(userRepository.findById(userId).orElseThrow());
        return list.stream().map(LikePost::getId).collect(Collectors.toList());
    }

    // 유저 정보를 받아 유저가 좋아요 한 글 목록을 반환
    public List<PostDto> getMyLikePostList(GetPostList.MyRequest myRequest) {
        PageRequest pageRequest = PageRequest.of(myRequest.getStart(), myRequest.getSize());
        List<Post> postList = postRepository.findAllByStatusEqualsAndUserEqualsOrderByCreatedAtDesc(Status.VISIBLE ,userRepository.findById(myRequest.getUserId()).orElseThrow(), pageRequest);
        return postList.stream().map(PostDto::from).collect(Collectors.toList());
    }



}
