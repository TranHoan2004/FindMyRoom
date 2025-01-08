package com.FindMyRoom.repository;

import com.FindMyRoom.model.Admin;
import com.FindMyRoom.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<String> getEmails();
    User getByEmail(String email);
}
