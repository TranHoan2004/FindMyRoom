package com.FindMyRoom.repository;

import com.FindMyRoom.model.Services;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<Services, Long> {
}
