package com.projectbackend.projectbackend.service;

import com.projectbackend.projectbackend.entity.Application;
import com.projectbackend.projectbackend.entity.Company;
import com.projectbackend.projectbackend.entity.Student;
import com.projectbackend.projectbackend.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ApplicationService {


  List<Application> getAllApplications();
  Application getApplicationById(Long id);
  Application saveApplication(Application application);
  List<Application> getApplicationsByStudentId(Long sid);
  List<Application> getApplicationsByCompanyId(Long cid);

  void applyToCompanies(Long sid,List<Long> cid);







}
