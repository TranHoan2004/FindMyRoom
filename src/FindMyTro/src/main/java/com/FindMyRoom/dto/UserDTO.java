package com.FindMyRoom.dto;

import com.FindMyRoom.model.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDTO {
    private long id;
    private String email;
    private String password;
    private String rewritePassword;
    private String fullname;
    private String phoneNumber;
    private Boolean gender;
    private byte[] imgURL;
    private Boolean status;
    private Date createdDate;
    private Role role;
}
