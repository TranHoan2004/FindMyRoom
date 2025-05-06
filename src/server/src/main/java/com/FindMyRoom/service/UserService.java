package com.FindMyRoom.service;

import com.FindMyRoom.dto.request.UserRequestDTO;
import com.FindMyRoom.dto.response.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<String> getAllEmails();

    UserResponseDTO getUserDTOByEmail(String email);

    void addAnNewAccount(UserRequestDTO userDTO);

    void updateUserDTO(String email, String password);

    Optional<UserResponseDTO> getAllUserDTOs();

    boolean isPhoneNumberExisting(String phoneNumber);

    void deleteUser(String email) throws Exception;
}
