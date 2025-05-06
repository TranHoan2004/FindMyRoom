package com.FindMyRoom.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    USER_EXISTED(1001, "User existed"),
    USER_INVALID(1002, "User invalid");

    int code;
    String message;
}
