package com.minibus.moment.dto.comment;

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
