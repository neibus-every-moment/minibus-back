package com.minibus.moment.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Role {

    ADMIN("ROLE_ADMIN", "관리자"),
    USER("ROLE_USER", "사용자");

    private final String key;
    private final String role;

//    public static Role of(String key) {
//        return Arrays.stream(Role.values())
//                .filter(r -> r.getKey().equals(key))
//                .findAny()
//                .orElse(USER);
//    }
}
