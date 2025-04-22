package com.FindMyRoom.repository;

import com.FindMyRoom.model.Booking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>{
}
