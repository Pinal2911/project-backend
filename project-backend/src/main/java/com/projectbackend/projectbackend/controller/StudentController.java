package com.projectbackend.projectbackend.controller;

import com.projectbackend.projectbackend.entity.RoundDetails;
import com.projectbackend.projectbackend.entity.UnplacedStudents;
import com.projectbackend.projectbackend.payload.*;
import com.projectbackend.projectbackend.service.AdminService;
import com.projectbackend.projectbackend.service.StudentService;
import org.springframework.boot.util.LambdaSafe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/student/placement/")
public class StudentController {

    public StudentService studentService;
    public AdminService adminService;
    public StudentController(StudentService studentService,AdminService adminService){
        this.studentService=studentService;
        this.adminService=adminService;
    }

  //  @PreAuthorize("hasRole('ROLE_STUDENT')")
    @GetMapping("/getCurrentCompany")
    public ResponseEntity<List<CurrentCompDto>> getCurrentCompanies(){
        return new ResponseEntity<>(studentService.currentComp(), HttpStatus.OK);
    }


    //@PreAuthorize("hasRole('ROLE_STUDENT')")
    @GetMapping("/getUpcomingCompany")
    public ResponseEntity<List<UpcomingCompDto>> getUpComingComp(){
        return new ResponseEntity<>(studentService.upComingComp(),HttpStatus.OK);
    }
   // @PreAuthorize("hasRole('ROLE_STUDENT')")

    @GetMapping("/getPlacedStudents")
    public ResponseEntity<List<PlacedStudentsDto>> getPlaced(){
        return new ResponseEntity<>(studentService.placedStudents(),HttpStatus.OK);
    }

   // @PreAuthorize("hasRole('ROLE_STUDENT')")
    @GetMapping("/getUnplacedStudents")
    public ResponseEntity<List<UnplacedStudentsDto>> getUnplaced(){
        return new ResponseEntity<>(studentService.unplacedStudents(),HttpStatus.OK);
    }

    @PutMapping("/editStudentProfile/{id}")
    public ResponseEntity<String> editStudentProfile(@RequestBody StudentRegisterDto studentRegisterDto,@PathVariable long id){
        return new ResponseEntity<>(adminService.editStudent(studentRegisterDto,id),HttpStatus.CREATED);
    }
    //@PreAuthorize("hasRole('ROLE_STUDENT')")
    @GetMapping("/onboard")
    public ResponseEntity<List<UpcomingCompDto>> applyCompany(){
        return new ResponseEntity<>(studentService.onBoardApply(),HttpStatus.OK);
    }

    @GetMapping("/getRoundDetails")
    public ResponseEntity<List<RoundDetailsDto>> getRoundDetails(){
        return new ResponseEntity<>(studentService.getRoundDetails(),HttpStatus.OK);
    }

}
