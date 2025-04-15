package com.FindMyRoom.mapping;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.model.Users;
import org.jetbrains.annotations.NotNull;

public class UserMapping {
    public UserDTO convert(@NotNull Users users) {
        return UserDTO.builder()
                .id(users.getId())
                .email(users.getEmail())
                .password(users.getPassword())
                .fullname(users.getFullname())
                .phoneNumber(users.getPhoneNumber())
                .imgURL(users.getImgURL())
                .status(users.getStatus())
                .createdDate(users.getCreatedDate())
                .gender(users.getGender())
                .role(users.getRole())
                .build();
    }

    public Users convert(@NotNull UserDTO dto) {
        return Users.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .fullname(dto.getFullname())
                .phoneNumber(dto.getPhoneNumber())
                .imgURL(dto.getImgURL())
                .status(dto.getStatus())
                .createdDate(dto.getCreatedDate())
                .gender(dto.getGender())
                .role(dto.getRole())
                .build();
    }
}
