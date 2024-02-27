package com.projectbackend.projectbackend.controller;

import com.projectbackend.projectbackend.entity.UnplacedStudents;
import com.projectbackend.projectbackend.payload.*;
import com.projectbackend.projectbackend.service.AdminService;
import com.projectbackend.projectbackend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/placement/")
public class StudentController {

    public StudentService studentService;
    public AdminService adminService;
    public StudentController(StudentService studentService,AdminService adminService){
        this.studentService=studentService;
        this.adminService=adminService;
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

    @PutMapping("/editStudentProfile/{id}")
    public ResponseEntity<String> editStudentProfile(@RequestBody StudentRegisterDto studentRegisterDto,@PathVariable long id){
        return new ResponseEntity<>(adminService.editStudent(studentRegisterDto,id),HttpStatus.CREATED);
    }

    @GetMapping("/onboard")
    public ResponseEntity<List<UpcomingCompDto>> applyCompany(){
        return new ResponseEntity<>(studentService.onBoardApply(),HttpStatus.OK);
    }

}
