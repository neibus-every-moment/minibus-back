package com.minibus.moment.controller;

import com.minibus.moment.dto.PostDto;
import com.minibus.moment.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("/default")
    public String create(){
        return postService.setDefault();
    }

    @GetMapping("/create")
    public String createPost(){
        return postService.create();
    }

    @GetMapping("/list")
    public List<PostDto> getPostList(int offset){
        return postService.getPostList(offset);
    }
}
