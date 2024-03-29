package com.minibus.moment.type;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum Status {

    VISIBLE("게시"),
    BLIND("블라인드");
    private final String description;
}
