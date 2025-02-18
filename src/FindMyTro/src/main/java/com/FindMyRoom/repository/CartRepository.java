package com.FindMyRoom.repository;

import com.FindMyRoom.model.Admin;
import com.FindMyRoom.model.Cart;

import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
