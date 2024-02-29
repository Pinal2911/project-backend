package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByEmail(String email);
    Optional<Student> findByUsernameOrEmail(String username,String email);
    Optional<Student> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
