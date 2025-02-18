package com.FindMyRoom.repository;

import com.FindMyRoom.model.Booking;

import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long>{
}
