package com.FindMyRoom.service;

import com.FindMyRoom.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    List<String> getAllEmails() throws Exception;

    AdminDTO getAdminDTOByID(long id) throws Exception;
}
