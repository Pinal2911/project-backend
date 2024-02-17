package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.UnplacedStudents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnplacedRepository extends JpaRepository<UnplacedStudents,Long> {
}
