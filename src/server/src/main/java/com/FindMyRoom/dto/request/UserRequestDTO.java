package com.FindMyRoom.dto.request;

import com.FindMyRoom.model.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserRequestDTO {
    private String email;
    private String password;
    private String phoneNumber;
}
