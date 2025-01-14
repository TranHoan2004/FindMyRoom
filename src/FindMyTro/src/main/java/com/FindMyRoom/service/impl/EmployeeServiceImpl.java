package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.EmployeeDTO;
import com.FindMyRoom.repository.EmployeeRepository;
import com.FindMyRoom.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<EmployeeDTO> getAllEmployeeDTOs() {
        return Optional.empty();
    }
}
