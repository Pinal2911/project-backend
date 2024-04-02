package com.projectbackend.projectbackend.service;

import com.projectbackend.projectbackend.payload.*;

import java.util.List;

public interface StudentService {

    List<CurrentCompDto> currentComp();
    List<UpcomingCompDto> upComingComp();
    List<PlacedStudentsDto> placedStudents();
    List<UnplacedStudentsDto> unplacedStudents();
    List<UpcomingCompDto> onBoardApply();
    List<RoundDetailsDto> getRoundDetails();
    List<StudentRegisterDto> getStudentByID(Long id);

}



















