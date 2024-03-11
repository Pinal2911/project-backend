package com.projectbackend.projectbackend.controller;

import com.projectbackend.projectbackend.entity.CurrentCompany;
import com.projectbackend.projectbackend.entity.UpcomingCompany;
import com.projectbackend.projectbackend.payload.*;
import com.projectbackend.projectbackend.service.AdminService;
import com.projectbackend.projectbackend.service.CompanyService;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/admin/placement")
public class AdminController {
    private AdminService adminService;
    private CompanyService companyService;
    public AdminController(AdminService adminService,CompanyService companyService){
        this.adminService=adminService;
        this.companyService=companyService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addPlacedStud")
    public ResponseEntity<PlacedStudentsDto> addPlacedStudent(@RequestBody PlacedStudentsDto placedStudentsDto){
        return new ResponseEntity<>(adminService.addPlacedStudents(placedStudentsDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/unPlacedStud")
    public ResponseEntity<UnplacedStudentsDto> unPlacedStudent(@RequestBody UnplacedStudentsDto unplacedStudentsDto){
        return new ResponseEntity<>(adminService.addUnplacedStudents(unplacedStudentsDto),HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/currentComp")
    public ResponseEntity<CurrentCompDto> CurrentComp(@RequestBody CurrentCompDto currentCompDto){
        return new ResponseEntity<>(adminService.addCurrentComp(currentCompDto),HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/upcomingComp")
    public ResponseEntity<UpcomingCompDto> UpcomingComp(@RequestBody UpcomingCompDto upcomingCompDto){
        return new ResponseEntity<>(adminService.addUpcomingComp(upcomingCompDto),HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/updatePlacedStud/{id}")
    public ResponseEntity<PlacedStudentsDto> UpdatePlacedStudents(@RequestBody PlacedStudentsDto placedStudentsDto,@PathVariable long id){
      return new ResponseEntity<>(adminService.updatePlacedStudents(placedStudentsDto, id),HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/updateUnPlacedStud/{id}")
    public ResponseEntity<UnplacedStudentsDto> UpdateUnPlacedStudents(@RequestBody UnplacedStudentsDto unplacedStudentsDto,@PathVariable long id){
        return new ResponseEntity<>(adminService.updateUnPlacedStudents(unplacedStudentsDto,id),HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/editStudent/{id}")
    public ResponseEntity<String> editStudent(@RequestBody StudentRegisterDto studentRegisterDto,@PathVariable long id){
        return new ResponseEntity<>(adminService.editStudent(studentRegisterDto,id),HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addCompany")
    public ResponseEntity<CompanyDetailsDto> addCompany(@RequestBody CompanyDetailsDto companyDetailsDto){
        return new ResponseEntity<>(adminService.addCompany(companyDetailsDto),HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/editCompany/{id}")
    public ResponseEntity<String> editCompany(@RequestBody CompanyDetailsDto companyDetailsDto,@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(adminService.updateCompanyDetails(companyDetailsDto,id),HttpStatus.CREATED);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/ppoStudents")
    public ResponseEntity<List<PlacedStudentsDto>> ppoStudentsList(){
        return new ResponseEntity<>(adminService.getPPOStud(),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/editAdmin/{id}")
    public ResponseEntity<String> editAdmin(@RequestBody AdminRegisterDto adminRegisterDto,@PathVariable Long id){
        return new ResponseEntity<>(adminService.updateAdmin(adminRegisterDto,id),HttpStatus.CREATED);

    }


    @PostMapping("/addNotification")
    public ResponseEntity<NotificationDto> addNotification(@RequestBody NotificationDto notificationDto){
        return new ResponseEntity<>(companyService.addNotification(notificationDto),HttpStatus.CREATED);
    }



    @PutMapping("/editNotification/{id}")
    public ResponseEntity<NotificationDto> editNotification(@RequestBody NotificationDto notify,@PathVariable Long id){
        return new ResponseEntity<>(companyService.updateNotification(notify,id),HttpStatus.OK);
    }

}
