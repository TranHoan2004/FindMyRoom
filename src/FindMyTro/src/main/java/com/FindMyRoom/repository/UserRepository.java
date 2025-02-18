package com.FindMyRoom.repository;

import com.FindMyRoom.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users, Long> {
    List<String> getEmails();

    Users getByEmail(String email);
}
