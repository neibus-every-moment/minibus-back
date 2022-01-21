package com.minibus.moment.service;

import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.region.RegionRepository;
import com.minibus.moment.domain.transport.Transport;
import com.minibus.moment.domain.transport.TransportRepository;
import com.minibus.moment.dto.PostDto;
import com.minibus.moment.dto.ResponseError;
import com.minibus.moment.exception.PostNotFoundException;
import com.minibus.moment.exception.RegionNotFoundException;
import com.minibus.moment.exception.TransportNotFoundException;
import com.minibus.moment.type.PostStatus;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final TransportRepository transportRepository;
    private final RegionRepository regionRepository;

    //Transport
    @ExceptionHandler(TransportNotFoundException.class)
    public ResponseEntity<?> TransportNotFoundException(TransportNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
    public Page<PostDto> pagePostListTransportNewest(int startIndex, String transportName) {
        PageRequest pageRequest = PageRequest.of(startIndex, 10);
        Transport transport = transportRepository.findByName(transportName).orElseThrow(() ->
                new TransportNotFoundException("대중교통을 선택해주세요."));
        Page<Post> transportSortNewest = postRepository.findAllByPostStatusEqualsAndTransportEqualsOrderByCreatedAtDesc(PostStatus.VISIBLE, transport, pageRequest);
        return transportSortNewest.map(PostDto::from); // from -> PostDto(from)
    }

    public Page<PostDto> pagePostListTransportBestLike(int startIndex, String transportName) {
        PageRequest pageRequest = PageRequest.of(startIndex, 10);
        Transport transport = transportRepository.findByName(transportName).orElseThrow(() ->
                new TransportNotFoundException("대중교통을 선택해주세요."));
        Page<Post> transportSortBestLike = postRepository.findAllByPostStatusEqualsAndTransportEqualsOrderByLikeCountDesc(PostStatus.VISIBLE, transport, pageRequest);
        return transportSortBestLike.map(PostDto::from);
    }

    //Region
    @ExceptionHandler(RegionNotFoundException.class)
    public ResponseEntity<?> RegionNotFoundException(RegionNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
    public Page<PostDto> pagePostListRegionNewest(int startIndex, String regionName) {
        PageRequest pageRequest = PageRequest.of(startIndex, 10);
        Region region = regionRepository.findByName(regionName).orElseThrow(() ->
                new RegionNotFoundException("지역을 선택해주세요."));
        Page<Post> regionSortNewest = postRepository.findAllByPostStatusEqualsAndRegionEqualsOrderByCreatedAtDesc(PostStatus.VISIBLE, region, pageRequest);
        return regionSortNewest.map(PostDto::from);
    }

    public Page<PostDto> pagePostListRegionBestLike(int startIndex, String regionName) {
        PageRequest pageRequest = PageRequest.of(startIndex, 10);
        Region region = regionRepository.findByName(regionName).orElseThrow(() ->
                new RegionNotFoundException("지역을 선택해주세요."));
        Page<Post> regionSortBestLike = postRepository.findAllByPostStatusEqualsAndRegionEqualsOrderByLikeCountDesc(PostStatus.VISIBLE, region, pageRequest);
        return regionSortBestLike.map(PostDto::from);
    }

    public void likeCount(@PathVariable Long postId, Errors errors) {
        List<ResponseError> responseErrorList = new ArrayList<>();
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach((e) -> {
                responseErrorList.add(ResponseError.of((FieldError) e));
            });
        }
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("해당 게시글은 존재하지 않습니다."));

        post.upCountLike();
    }

    public void likeCancelCount(@PathVariable Long postId, Errors errors) {
        List<ResponseError> responseErrorList = new ArrayList<>();
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach((e) -> {
                responseErrorList.add(ResponseError.of((FieldError) e));
            });
        }
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("해당 게시글은 존재하지 않습니다."));

        post.downCountLike();
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<?> PostNotFoundExceptionHandler(PostNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
