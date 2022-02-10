package com.minibus.moment.dto.api;

import com.minibus.moment.dto.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserInfoList {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private UserInfoDto data;
    }
}
