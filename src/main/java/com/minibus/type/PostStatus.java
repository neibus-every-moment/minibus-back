package com.minibus.type;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum PostStatus {

    VISIBLE("게시"),
    BLIND("블라인드");
    private final String description;
}
