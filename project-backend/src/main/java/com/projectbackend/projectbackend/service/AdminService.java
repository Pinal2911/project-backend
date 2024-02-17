package com.projectbackend.projectbackend.service;

import com.projectbackend.projectbackend.payload.PlacedStudentsDto;
import com.projectbackend.projectbackend.payload.UnplacedStudentsDto;

public interface AdminService {

    PlacedStudentsDto addPlacedStudents(PlacedStudentsDto placedStudentsDto);
    UnplacedStudentsDto addUnplacedStudents(UnplacedStudentsDto unplacedStudentsDto);


}
