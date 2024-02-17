package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.PlacedStudents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacedRepository extends JpaRepository<PlacedStudents,Long> {
}
