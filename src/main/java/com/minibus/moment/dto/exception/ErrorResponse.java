package com.minibus.moment.dto.exception;

import com.minibus.moment.exception.MinibusErrorCode;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private MinibusErrorCode errorCode;
    private String message;
}
