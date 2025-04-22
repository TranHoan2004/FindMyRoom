package com.FindMyRoom.repository;

import com.FindMyRoom.model.Business;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends CrudRepository<Business, Long> {
}
