package com.FindMyRoom.repository;

import com.FindMyRoom.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Integer> {
    List<String> getEmails();
    Users getByEmail(String email);
}
