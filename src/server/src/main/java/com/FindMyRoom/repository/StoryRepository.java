package com.FindMyRoom.repository;

import com.FindMyRoom.model.Story;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {
    @NotNull
    List<Story> findAll();

    @Query("""
            FROM Story s
            WHERE s.id=:id
            """)
    Story getById(@Param("id") Long id);
}
