package com.FindMyRoom.dto;

import com.FindMyRoom.model.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AdminDTO {
    private long id;
    private String email;
    private String password;
    private String rewritePassword;
    private String fullname;
    private String phoneNumber;
    private Boolean gender;
    private byte[] imgURL;
    private Boolean status;
    private LocalDate createdDate;
    private Role role;
}
