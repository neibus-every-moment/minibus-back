package com.minibus.moment.controller;

import com.minibus.moment.dto.api.admin.BlindPost;
import com.minibus.moment.dto.api.admin.RestorePost;
import com.minibus.moment.service.BlindService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/admin")
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final BlindService blindService;

    @PostMapping("/blind")
    public boolean blindPost(@RequestBody BlindPost.Request request){
        return blindService.blindPost(request);
    }

    @PostMapping("/restore")
    public boolean restorePost(@RequestBody RestorePost.Request request){
        return blindService.restorePost(request);
    }

}
