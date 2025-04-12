package com.FindMyRoom.mapping;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.model.Users;
import org.jetbrains.annotations.NotNull;

public class UserMapping {
    public UserDTO convertUser(@NotNull Users users) {
        return UserDTO.builder()
                .id(users.getId())
                .email(users.getEmail())
                .password(users.getPassword())
                .fullname(users.getFullname())
                .phoneNumber(users.getPhoneNumber())
                .imgURL(users.getImgURL())
                .status(users.getStatus())
                .createdDate(users.getCreatedDate())
                .role(users.getRole())
                .build();
    }

    public Users convertUser(@NotNull UserDTO users) {
        return Users.builder()
                .id(users.getId())
                .email(users.getEmail())
                .password(users.getPassword())
                .fullname(users.getFullname())
                .phoneNumber(users.getPhoneNumber())
                .imgURL(users.getImgURL())
                .status(users.getStatus())
                .createdDate(users.getCreatedDate())
                .role(users.getRole())
                .build();
    }
}
