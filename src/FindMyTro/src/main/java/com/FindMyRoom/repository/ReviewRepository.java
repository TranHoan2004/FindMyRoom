package com.FindMyRoom.repository;

import com.FindMyRoom.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Admin, Integer> {
}
