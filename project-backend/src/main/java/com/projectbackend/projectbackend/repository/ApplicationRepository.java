//package com.projectbackend.projectbackend.repository;
//
//import com.projectbackend.projectbackend.entity.Application;
//import com.projectbackend.projectbackend.entity.Company;
//import com.projectbackend.projectbackend.entity.Student;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//public interface ApplicationRepository extends JpaRepository<Application,Long> {
//    List<Application> findByCompany(long cid);
//    List<Application> findByStudent(long sid);
//
//    boolean existsByStudent(Student student);
//    boolean existsByCompany(Company company);
////    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Application a WHERE a.student = :student AND a.company = :company")
////    boolean exitsByStudentAndCompany(long sid,long cid);
//}
