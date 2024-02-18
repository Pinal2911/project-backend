package com.projectbackend.projectbackend.service;

import com.projectbackend.projectbackend.payload.CurrentCompDto;
import com.projectbackend.projectbackend.payload.PlacedStudentsDto;
import com.projectbackend.projectbackend.payload.UnplacedStudentsDto;
import com.projectbackend.projectbackend.payload.UpcomingCompDto;

public interface AdminService {

    PlacedStudentsDto addPlacedStudents(PlacedStudentsDto placedStudentsDto);
    UnplacedStudentsDto addUnplacedStudents(UnplacedStudentsDto unplacedStudentsDto);

    CurrentCompDto addCurrentComp(CurrentCompDto currentCompDto);
    UpcomingCompDto addUpcomingComp(UpcomingCompDto upcomingCompDto);

    PlacedStudentsDto updatePlacedStudents(PlacedStudentsDto placedStudentsDto,Long id);


    PlacedStudentsDto updatePlacedStudents(PlacedStudentsDto placedStudentsDto, long id);
}
