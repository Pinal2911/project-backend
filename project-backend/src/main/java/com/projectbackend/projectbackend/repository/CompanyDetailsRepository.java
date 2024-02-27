package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails,Long> {
}
