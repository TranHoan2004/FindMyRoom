package com.FindMyRoom.mapping;

import com.FindMyRoom.controller.utils.URLIdEncoder;
import com.FindMyRoom.dto.request.UserRequestDTO;
import com.FindMyRoom.dto.response.UserResponseDTO;
import com.FindMyRoom.model.Users;
import org.jetbrains.annotations.NotNull;

public class UserMapping {
    public UserResponseDTO convert(@NotNull Users users) {
        String role = "";
        switch (users.getRole()) {
            case ROLE_ADMIN -> role = "Admin";
            case ROLE_USER -> role = "User";
            case ROLE_EMPLOYEE -> role = "Employee";
            case ROLE_BUSINESSMAN -> role = "Business Manager";
        }
        return UserResponseDTO.builder()
                .encodeId(URLIdEncoder.encodeId(users.getId()))
                .email(users.getEmail())
                .password(users.getPassword())
                .fullname(users.getFullname())
                .imgURL(users.getImgURL())
                .status(users.getStatus())
                .createdDate(users.getCreatedDate())
                .role(role)
                .systemRole(users.getRole())
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
