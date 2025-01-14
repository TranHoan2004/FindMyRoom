package com.FindMyRoom.repository;

import com.FindMyRoom.model.Admin;
import com.FindMyRoom.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
