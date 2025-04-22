package com.FindMyRoom.service;

import com.FindMyRoom.dto.AdminDTO;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<String> getAllEmails() throws Exception;

    AdminDTO getAdminDTOByID(long id) throws Exception;

    Optional<AdminDTO> getAllAdminDTOs();
}
