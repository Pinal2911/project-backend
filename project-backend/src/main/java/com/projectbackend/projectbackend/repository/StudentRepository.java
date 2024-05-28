package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByEmail(String email);
    Optional<Student> findByFnameOrEmail(String fname,String email);
    Optional<Student> findByFname(String fname);
    Boolean existsByFname(String fname);
    Boolean existsByEmail(String email);


}
