package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.Admin;
import com.projectbackend.projectbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    Optional<Admin> findByEmail(String email);
    Optional<Admin> findByNameOrEmail(String name,String email);
    Optional<Admin> findByName(String name);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);






}
