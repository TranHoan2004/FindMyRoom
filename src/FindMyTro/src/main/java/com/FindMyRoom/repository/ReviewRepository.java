package com.FindMyRoom.repository;

import com.FindMyRoom.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
