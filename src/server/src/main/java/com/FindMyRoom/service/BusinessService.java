package com.FindMyRoom.service;

import com.FindMyRoom.dto.BusinessDTO;

import java.util.Optional;

public interface BusinessService {
    Optional<BusinessDTO> getAllBusinessAccount();
}
