package com.projectbackend.projectbackend.controller;

import com.projectbackend.projectbackend.entity.UnplacedStudents;
import com.projectbackend.projectbackend.payload.CurrentCompDto;
import com.projectbackend.projectbackend.payload.PlacedStudentsDto;
import com.projectbackend.projectbackend.payload.UnplacedStudentsDto;
import com.projectbackend.projectbackend.payload.UpcomingCompDto;
import com.projectbackend.projectbackend.service.AdminService;
import com.projectbackend.projectbackend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student/placement/")
public class StudentController {

    public StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/getCurrentCompany")
    public ResponseEntity<List<CurrentCompDto>> getCurrentCompanies(){
        return new ResponseEntity<>(studentService.currentComp(), HttpStatus.OK);
    }

    @GetMapping("/getUpcomingCompany")
    public ResponseEntity<List<UpcomingCompDto>> getUpComingComp(){
        return new ResponseEntity<>(studentService.upComingComp(),HttpStatus.OK);
    }

    @GetMapping("/getPlacedStudents")
    public ResponseEntity<List<PlacedStudentsDto>> getPlaced(){
        return new ResponseEntity<>(studentService.placedStudents(),HttpStatus.OK);
    }

    @GetMapping("/getUnplacedStudents")
    public ResponseEntity<List<UnplacedStudentsDto>> getUnplaced(){
        return new ResponseEntity<>(studentService.unplacedStudents(),HttpStatus.OK);
    }


}
