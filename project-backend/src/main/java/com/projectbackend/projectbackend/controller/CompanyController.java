package com.projectbackend.projectbackend.controller;

import com.projectbackend.projectbackend.entity.Company;
import com.projectbackend.projectbackend.entity.CompanyDetails;
import com.projectbackend.projectbackend.entity.Notifications;
import com.projectbackend.projectbackend.payload.CompanyDetailsDto;
import com.projectbackend.projectbackend.payload.NotificationDto;
import com.projectbackend.projectbackend.payload.PlacedStudentsDto;
import com.projectbackend.projectbackend.service.AdminService;
import com.projectbackend.projectbackend.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/company/placement")
public class CompanyController {

    private AdminService adminService;
    private CompanyService companyService;
    public CompanyController(AdminService adminService,CompanyService companyService){
        this.companyService=companyService;
        this.adminService=adminService;
    }



    @PutMapping("/editCompany/{id}")

    public ResponseEntity<String> editCompany(@RequestBody CompanyDetailsDto companyDetailsDto, @PathVariable(name = "id") Long id){
        return new ResponseEntity<>(adminService.updateCompanyDetails(companyDetailsDto,id), HttpStatus.CREATED);

    }

    @PreAuthorize("hasRole('ROLE_COMPANY')")
    @PutMapping("/editProcess/{id}")
    public ResponseEntity<String> editProcess(@RequestBody CompanyDetailsDto process, @PathVariable Long id){
        return new ResponseEntity<>(companyService.editProcess(process,id),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_COMPANY')")
    @PutMapping("/editProfile/{id}")
    public ResponseEntity<String> editProfile(@RequestBody Company company,@PathVariable Long id){
        return new ResponseEntity<>(companyService.editProfile(company,id),HttpStatus.OK);
    }

    @PostMapping("/notification")
    public ResponseEntity<NotificationDto> addNotification(@RequestBody NotificationDto notificationDto){
        return new ResponseEntity<>(companyService.addNotification(notificationDto),HttpStatus.CREATED);
    }

    @PutMapping("/editNotification/{id}")
    public ResponseEntity<NotificationDto> editNotification(@RequestBody NotificationDto notify,@PathVariable Long id){
        return new ResponseEntity<>(companyService.updateNotification(notify,id),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_COMPANY')")

    @GetMapping("/ppo/{companyName}")
    public ResponseEntity<List<PlacedStudentsDto>> getPPOList(@PathVariable String companyName){
        return new ResponseEntity<>(companyService.getPPOStudents(companyName),HttpStatus.OK);
    }




}
