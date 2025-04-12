package com.FindMyRoom.repository;

import com.FindMyRoom.model.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    @Query("""
            SELECT a.user.email
            FROM Admin a
            """)
    List<String> getEmails();

    @Query("""
            FROM Admin a
            WHERE a.user.email = :email
            """)
    Admin getByEmail(@Param("email") String email);
}
