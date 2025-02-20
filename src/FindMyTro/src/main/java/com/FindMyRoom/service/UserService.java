package com.FindMyRoom.service;

import com.FindMyRoom.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<String> getAllEmails();

    UserDTO getUserDTOByEmail(String email);

    void addAnNewAccount(UserDTO userDTO) throws ParseException;

    void updateUserDTO(UserDTO userDTO);

    Optional<UserDTO> getAllUserDTOs() throws Exception;
}
