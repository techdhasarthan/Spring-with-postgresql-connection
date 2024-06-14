package com.java.server.server.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface studentRepository extends JpaRepository<student,Long> {
    @Query("SELECT s FROM student s WHERE s.email = ?1")
    Optional<student> findemail (String email);
}
