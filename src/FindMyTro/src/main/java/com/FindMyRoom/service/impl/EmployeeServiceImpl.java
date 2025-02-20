package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.EmployeeDTO;
import com.FindMyRoom.repository.EmployeeRepository;
import com.FindMyRoom.repository.impl.EmployeeRepositoryImpl;
import com.FindMyRoom.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepositoryImpl repo) {
        this.repo = repo;
    }

    @Override
    public Optional<EmployeeDTO> getAllEmployeeDTOs() {
        return Optional.empty();
    }
}
