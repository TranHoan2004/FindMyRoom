package com.FindMyRoom.service;

import com.FindMyRoom.dto.UserDTO;

import java.text.ParseException;
import java.util.*;

public interface UserService {
    List<String> getAllEmails();
    UserDTO getUserDTOByEmail(String email);
    void addAnNewAccount(UserDTO userDTO) throws ParseException;
    void updateUserDTO(UserDTO userDTO);
    Optional<UserDTO> getAllUserDTOs();
}
