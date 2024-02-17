package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
