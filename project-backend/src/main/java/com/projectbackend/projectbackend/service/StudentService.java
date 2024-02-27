package com.projectbackend.projectbackend.service;

import com.projectbackend.projectbackend.payload.CurrentCompDto;
import com.projectbackend.projectbackend.payload.PlacedStudentsDto;
import com.projectbackend.projectbackend.payload.UnplacedStudentsDto;
import com.projectbackend.projectbackend.payload.UpcomingCompDto;

import java.util.List;

public interface StudentService {

    List<CurrentCompDto> currentComp();
    List<UpcomingCompDto> upComingComp();
    List<PlacedStudentsDto> placedStudents();
    List<UnplacedStudentsDto> unplacedStudents();
    List<UpcomingCompDto> onBoardApply();

}



















