package com.FindMyRoom.dto.response;

import com.FindMyRoom.model.utils.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDTO {
    String encodeId;
    String email;
    String password;
    String fullname;
    byte[] imgURL;
    Boolean status;
    LocalDate createdDate;
    String role;
    Role systemRole;
}
