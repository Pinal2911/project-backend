package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.Application;
import com.projectbackend.projectbackend.entity.Company;
import com.projectbackend.projectbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
    List<Application> findByCompanyId(long cid);
    List<Application> findByStudentId(long sid);
    Optional<Application> findByStudentIdAndCompanyId(Long sid, Long cid);


}
