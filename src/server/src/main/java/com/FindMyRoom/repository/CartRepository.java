package com.FindMyRoom.repository;

import com.FindMyRoom.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
}