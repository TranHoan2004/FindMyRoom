package com.FindMyRoom.service;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.dto.request.UserRequestDTO;
import com.FindMyRoom.dto.response.UserResponseDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<String> getAllEmails() throws Exception;

    UserResponseDTO getUserDTOByEmail(String email) throws Exception;

    void addAnNewAccount(UserRequestDTO userDTO);

    void updateUserDTO(UserDTO userDTO);

    Optional<UserResponseDTO> getAllUserDTOs() throws Exception;

    boolean isPhoneNumberExisting(String phoneNumber);
}
