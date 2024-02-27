package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {

}
