package com.minibus.moment.dto.api;

import com.minibus.moment.dto.EmoticonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class GetEmoticonList {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        List<EmoticonDto> data;
    }
}
