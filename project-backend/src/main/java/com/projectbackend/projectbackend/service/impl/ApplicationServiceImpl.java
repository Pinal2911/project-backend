//package com.projectbackend.projectbackend.service.impl;
//
//import com.projectbackend.projectbackend.entity.Application;
//import com.projectbackend.projectbackend.entity.Company;
//import com.projectbackend.projectbackend.entity.Student;
//import com.projectbackend.projectbackend.exception.GlobalExceptionHandler;
//import com.projectbackend.projectbackend.exception.TnpApiException;
//import com.projectbackend.projectbackend.repository.ApplicationRepository;
//import com.projectbackend.projectbackend.service.ApplicationService;
//import com.projectbackend.projectbackend.utils.ApplicationStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class ApplicationServiceImpl implements ApplicationService {
//
//    private ApplicationRepository applicationRepository;
//    public ApplicationServiceImpl(ApplicationRepository applicationRepository){
//        this.applicationRepository=applicationRepository;
//    }
//    @Override
//    public Application applyToCompany(long sid, long cid) {
//        if(applicationRepository.exitsByStudentAndCompany(sid,cid)){
//            throw new TnpApiException(HttpStatus.BAD_REQUEST,"already applied by studet");
//
//        }
//        Application application=new Application(sid,cid, ApplicationStatus.PENDING);
//
//        return applicationRepository.save(application);
//
//    }
//
//    @Override
//    public List<Application> getApplicationsByCompany(long cid) {
//        return applicationRepository.findByCompany(cid);
//    }
//
//    @Override
//    public List<Application> getApplicationsByStudent(long sid) {
//        return applicationRepository.findByStudent(sid);
//    }
//}
