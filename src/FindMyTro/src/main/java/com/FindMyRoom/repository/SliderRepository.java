package com.FindMyRoom.repository;

import com.FindMyRoom.model.Slider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SliderRepository extends CrudRepository<Slider, Long> {
}
