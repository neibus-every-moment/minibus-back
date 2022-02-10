package com.minibus.moment.auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiResponse {
    private boolean success;
    private String message;

    @Builder
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}