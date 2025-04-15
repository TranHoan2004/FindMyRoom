package com.FindMyRoom.repository;

import com.FindMyRoom.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    @Query("""
            SELECT u.email
            FROM Users u
            """)
    List<String> getEmails();

    @Query("""
            FROM Users u
            WHERE u.email = :email
            """)
    Users getByEmail(@Param("email") String email);

    boolean existsByEmail(String email);
}
