package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyListRepository extends JpaRepository<CompanyDetails,Long> {
}
