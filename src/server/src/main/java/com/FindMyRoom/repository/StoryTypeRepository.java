package com.FindMyRoom.repository;

import com.FindMyRoom.model.StoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface StoryTypeRepository extends JpaRepository<StoryType, Long> {
    @Query("""
            SELECT s.name
            FROM StoryType s
            WHERE s.id=:id
            """)
    String findStoryTypeById(@Param("id") long id);
}
