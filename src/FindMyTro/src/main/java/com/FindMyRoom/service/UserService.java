package com.FindMyRoom.service;

import com.FindMyRoom.dto.request.UserRequestDTO;
import com.FindMyRoom.dto.response.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<String> getAllEmails() throws Exception;

    UserResponseDTO getUserDTOByEmail(String email) throws Exception;

    void addAnNewAccount(UserRequestDTO userDTO);

    void updateUserDTO(String email, String password) throws Exception;

    Optional<UserResponseDTO> getAllUserDTOs() throws Exception;

    boolean isPhoneNumberExisting(String phoneNumber);
}
