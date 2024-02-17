package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.UpcomingCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpcomingCompRepository extends JpaRepository<UpcomingCompany,Long> {
}
