package com.projectbackend.projectbackend.service.impl;

import com.projectbackend.projectbackend.entity.Application;
import com.projectbackend.projectbackend.entity.Company;
import com.projectbackend.projectbackend.entity.Student;
import com.projectbackend.projectbackend.exception.GlobalExceptionHandler;
import com.projectbackend.projectbackend.exception.TnpApiException;
import com.projectbackend.projectbackend.repository.ApplicationRepository;
import com.projectbackend.projectbackend.repository.CompanyRepository;
import com.projectbackend.projectbackend.repository.StudentRepository;
import com.projectbackend.projectbackend.service.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;
    private StudentRepository studentRepository;
    private CompanyRepository companyRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, StudentRepository studentRepository, CompanyRepository companyRepository) {
        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @Override
    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getApplicationsByStudentId(Long sid) {
        return applicationRepository.findByStudentId(sid);
    }

    @Override
    public List<Application> getApplicationsByCompanyId(Long cid) {
        return applicationRepository.findByCompanyId(cid);
    }

    @Override
    public void applyToCompanies(Long sid, List<Long> cid) {
        Student student=studentRepository.findById(sid).orElseThrow(()->new RuntimeException("student not found"));
        for(Long id:cid){
            Company company=companyRepository.findById(id).orElseThrow(()-> new RuntimeException("company not found"));
            if (applicationRepository.findByStudentIdAndCompanyId(sid, id).isEmpty()) {
                Application application = new Application();

                application.setStudent(student);
                application.setCompany(company);
                application.setStatus("Applied");
                applicationRepository.save(application);
            }

        }
    }
}
