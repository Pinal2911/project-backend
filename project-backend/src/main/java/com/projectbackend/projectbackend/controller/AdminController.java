package com.projectbackend.projectbackend.controller;

import com.projectbackend.projectbackend.entity.CurrentCompany;
import com.projectbackend.projectbackend.entity.UpcomingCompany;
import com.projectbackend.projectbackend.payload.CurrentCompDto;
import com.projectbackend.projectbackend.payload.PlacedStudentsDto;
import com.projectbackend.projectbackend.payload.UnplacedStudentsDto;
import com.projectbackend.projectbackend.payload.UpcomingCompDto;
import com.projectbackend.projectbackend.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/placement")
public class AdminController {
    private AdminService adminService;
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }

    @PostMapping("/addPlacedStud")
    public ResponseEntity<PlacedStudentsDto> addPlacedStudent(@RequestBody PlacedStudentsDto placedStudentsDto){
        return new ResponseEntity<>(adminService.addPlacedStudents(placedStudentsDto), HttpStatus.CREATED);
    }

    @PostMapping("/unPlacedStud")
    public ResponseEntity<UnplacedStudentsDto> unPlacedStudent(@RequestBody UnplacedStudentsDto unplacedStudentsDto){
        return new ResponseEntity<>(adminService.addUnplacedStudents(unplacedStudentsDto),HttpStatus.CREATED);
    }

    @PostMapping("/currentComp")
    public ResponseEntity<CurrentCompDto> CurrentComp(@RequestBody CurrentCompDto currentCompDto){
        return new ResponseEntity<>(adminService.addCurrentComp(currentCompDto),HttpStatus.CREATED);
    }

    @PostMapping("/upcomingComp")
    public ResponseEntity<UpcomingCompDto> UpcomingComp(@RequestBody UpcomingCompDto upcomingCompDto){
        return new ResponseEntity<>(adminService.addUpcomingComp(upcomingCompDto),HttpStatus.CREATED);
    }

    @PostMapping("/updatePlacedStud/{id}")
    public ResponseEntity<PlacedStudentsDto> UpdatePlacedStudents(@RequestBody PlacedStudentsDto placedStudentsDto,@PathVariable long id){
        //to be implemented
       return null;

    }

}
