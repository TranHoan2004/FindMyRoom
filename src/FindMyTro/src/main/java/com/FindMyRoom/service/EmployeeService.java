package com.FindMyRoom.service;

import com.FindMyRoom.dto.EmployeeDTO;

import java.util.Optional;

public interface EmployeeService {
    Optional<EmployeeDTO> getAllEmployeeDTOs();
}
