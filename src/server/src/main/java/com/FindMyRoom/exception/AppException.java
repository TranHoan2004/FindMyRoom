package com.FindMyRoom.exception;

import lombok.*;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AppException extends RuntimeException {
    private ErrorCode errorCode;

    public AppException(@NotNull ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
/*
throw new RuntimeException("User existed")
=> throw new AppException(ErrorCode.USER_EXISTED)
 */
