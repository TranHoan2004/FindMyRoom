package com.FindMyRoom.repository;

import com.FindMyRoom.model.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
    List<String> getEmails();
    Admin getByEmail(String email);
    Admin getById(long id);
}
