package com.projectbackend.projectbackend.service;

import com.projectbackend.projectbackend.entity.Company;
import com.projectbackend.projectbackend.entity.CompanyDetails;
import com.projectbackend.projectbackend.entity.Notifications;
import com.projectbackend.projectbackend.payload.CompanyDetailsDto;
import com.projectbackend.projectbackend.payload.NotificationDto;
import com.projectbackend.projectbackend.payload.PlacedStudentsDto;

import java.util.List;

public interface CompanyService {


    String editProcess(CompanyDetailsDto process, Long id);
    String editProfile(Company company,Long id);
    NotificationDto addNotification(NotificationDto notificationDto);

    NotificationDto updateNotification(NotificationDto notification,Long id);

    List<PlacedStudentsDto> getPPOStudents(String companyName);
}
