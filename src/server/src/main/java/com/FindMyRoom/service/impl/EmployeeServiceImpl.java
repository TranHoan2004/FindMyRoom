package com.FindMyRoom.service.impl;

import com.FindMyRoom.repository.EmployeeRepository;
import com.FindMyRoom.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

//    @Override
//    public Optional<EmployeeDTO> getAllEmployeeDTOs() {
//        return Optional.empty();
//    }
}
