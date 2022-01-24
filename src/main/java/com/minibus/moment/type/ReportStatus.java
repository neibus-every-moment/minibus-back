package com.minibus.moment.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ReportStatus {

    BEFORE("처리 전"),
    KEEP("보류"),
    COMPLETE("처리완료");

    private final String description;
}
