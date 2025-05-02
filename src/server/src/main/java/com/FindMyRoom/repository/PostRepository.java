package com.FindMyRoom.repository;

import com.FindMyRoom.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    Page<Post> findAll(Pageable pageable);

    @Query("""
        FROM Post p
        WHERE p.address LIKE :str
        OR p.content LIKE :str
        OR p.title LIKE :str
        OR p.media LIKE :str
        OR p.specialItem LIKE :str
        """)
    Page<Post> findAllWithFilter(Pageable pageable, @Param("str") String string);

    Page<Post> findAllByUserId(Long userId, Pageable pageable);
}
