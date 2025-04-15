package com.FindMyRoom.service;

import com.FindMyRoom.dto.UserDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<String> getAllEmails();

    UserDTO getUserDTOByEmail(String email) throws Exception;

    void addAnNewAccount(UserDTO userDTO) throws ParseException;

    void updateUserDTO(UserDTO userDTO);

    Optional<UserDTO> getAllUserDTOs() throws Exception;

    boolean isEmailExist(String email);
}
