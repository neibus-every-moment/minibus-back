package com.minibus.moment.dto.api;

import com.minibus.moment.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyPage {
    private UserDto user;
    private Integer postCount;
    private Integer commentCount;
}
