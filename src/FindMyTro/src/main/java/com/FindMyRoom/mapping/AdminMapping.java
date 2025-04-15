package com.FindMyRoom.mapping;

import com.FindMyRoom.dto.AdminDTO;
import com.FindMyRoom.model.Admin;
import org.jetbrains.annotations.NotNull;

public class AdminMapping {
    public AdminDTO convert(@NotNull Admin users) {
        return AdminDTO.builder()
                .id(users.getId().getAdminID())
                .email(users.getUser().getEmail())
                .password(users.getUser().getPassword())
                .fullname(users.getUser().getFullname())
                .phoneNumber(users.getUser().getPhoneNumber())
                .imgURL(users.getUser().getImgURL())
                .status(users.getUser().getStatus())
                .createdDate(users.getUser().getCreatedDate())
                .gender(users.getUser().getGender())
                .role(users.getUser().getRole())
                .build();
    }
}
