package com.projectbackend.projectbackend.service.impl;

import com.projectbackend.projectbackend.entity.Company;
import com.projectbackend.projectbackend.entity.CompanyDetails;
import com.projectbackend.projectbackend.entity.Notifications;
import com.projectbackend.projectbackend.entity.PlacedStudents;
import com.projectbackend.projectbackend.exception.ResourceNotFoundException;
import com.projectbackend.projectbackend.payload.CompanyDetailsDto;
import com.projectbackend.projectbackend.payload.NotificationDto;
import com.projectbackend.projectbackend.payload.PlacedStudentsDto;
import com.projectbackend.projectbackend.repository.*;
import com.projectbackend.projectbackend.service.AdminService;
import com.projectbackend.projectbackend.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {


   private CompanyListRepository companyListRepository;
   private CompanyRepository companyRepository;
   private PlacedRepository placedRepository;
   private ModelMapper modelMapper;
   private NotificationRepository notificationRepository;
   private CompanyServiceImpl(CompanyListRepository companyListRepository,CompanyRepository companyRepository,ModelMapper modelMapper,
                              NotificationRepository notificationRepository,PlacedRepository placedRepository){
       this.companyListRepository=companyListRepository;
       this.companyRepository=companyRepository;
       this.modelMapper=modelMapper;
       this.notificationRepository=notificationRepository;
       this.placedRepository=placedRepository;
   }

//post process of company


    @Override
    public String editProcess(CompanyDetailsDto process, Long id) {
        CompanyDetails companyDetails=companyListRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("company","id","id"));
        companyDetails.setProcess(process.getProcess());
        companyListRepository.save(companyDetails);
        return "process saved successfully";

    }

    @Override
    public String editProfile(Company company, Long id) {
       Company comp=companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("company","id","id" ));
       comp.setEmail(company.getEmail());
       comp.setPassword(company.getPassword());
       companyRepository.save(comp);
        return "details updated!";
    }

    @Override
    public NotificationDto addNotification(NotificationDto notificationDto) {
        Notifications notification=modelMapper.map(notificationDto, Notifications.class);
        Notifications newNotification=notificationRepository.save(notification);


        return modelMapper.map(newNotification, NotificationDto.class);
    }

    @Override
    public NotificationDto updateNotification(NotificationDto notification, Long id) {
       Notifications notifications=notificationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("notification","id","id"));
       notifications.setNotify(notification.getNotify());
       notificationRepository.save(notifications);
        return modelMapper.map(notifications, NotificationDto.class);
    }

    @Override
    public List<PlacedStudentsDto> getPPOStudents(String companyName) {
        List<PlacedStudentsDto> students=new ArrayList<>();
        Iterable<PlacedStudents> placedStudents=placedRepository.findAll();
        for(PlacedStudents s:placedStudents){
            if(s.isPpo()  && companyName.equalsIgnoreCase(s.getCompanyName()) ){
                students.add(modelMapper.map(s, PlacedStudentsDto.class));
            }
        }
        return students;
    }

    //put process/edit process of company
}
