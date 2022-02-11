package com.minibus.moment.mockApi.service;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Token {

    private String token;

    public Token(String token) {
        this.token = token;
    }
}