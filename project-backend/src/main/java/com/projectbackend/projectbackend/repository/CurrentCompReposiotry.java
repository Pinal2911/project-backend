package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.CurrentCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentCompReposiotry extends JpaRepository<CurrentCompany,Long> {
}
