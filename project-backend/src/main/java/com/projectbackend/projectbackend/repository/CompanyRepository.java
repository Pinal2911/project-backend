package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.Admin;
import com.projectbackend.projectbackend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    Optional<Company> findByEmail(String email);
    Optional<Company> findByNameOrEmail(String name,String email);
    Optional<Company> findByName(String name);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
}
