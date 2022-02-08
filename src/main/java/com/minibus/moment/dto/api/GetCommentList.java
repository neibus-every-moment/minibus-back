package com.minibus.moment.dto.api;

import com.minibus.moment.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class GetCommentList {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private List<CommentDto> data;
    }
}
