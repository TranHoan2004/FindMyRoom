package com.FindMyRoom.repository;

import com.FindMyRoom.model.BoardingHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardingHouseRepository extends CrudRepository<BoardingHouse, Long> {

}
