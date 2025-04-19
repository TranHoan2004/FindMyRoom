package com.FindMyRoom.mapping;

import com.FindMyRoom.dto.request.UserRequestDTO;
import com.FindMyRoom.dto.response.UserResponseDTO;
import com.FindMyRoom.model.Users;
import org.jetbrains.annotations.NotNull;

public class UserMapping {
    public UserResponseDTO convert(@NotNull Users users) {
        return UserResponseDTO.builder()
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

    public Users convert(@NotNull UserRequestDTO dto) {
        return Users.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }
}
