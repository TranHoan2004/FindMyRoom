package com.FindMyRoom.dto.request;

import com.FindMyRoom.config.Constants;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDTO implements Constants.Regex {
    @Pattern(regexp = EMAIL_REGEX, message = "Email must follow the format <name>@<domain>")
    String email;

    @Size(min = 8, max = 32, message = "Password must have 8 to 32 characters")
    @Pattern(regexp = PASSWORD_REGEX,
            message = "Password must have at least one uppercase letter, a digit, a special character")
    String password;

    @Pattern(regexp = PHONE_REGEX, message = "Phone number must contain 10 characters")
    String phoneNumber;
}
