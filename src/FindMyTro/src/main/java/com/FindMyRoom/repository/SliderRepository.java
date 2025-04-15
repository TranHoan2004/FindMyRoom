package com.FindMyRoom.repository;

import com.FindMyRoom.model.Slider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliderRepository extends CrudRepository<Slider, Long> {
    @Query("""
        SELECT s.imgURL
        FROM Slider s
        """)
    List<byte[]> getAllImages();
}
