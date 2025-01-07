package com.FindMyRoom.service;

import com.FindMyRoom.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<String> getAllEmails();
    UserDTO getUserDTOByEmail(String email);
}
