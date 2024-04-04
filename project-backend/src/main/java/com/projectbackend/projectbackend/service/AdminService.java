package com.projectbackend.projectbackend.service;

import com.projectbackend.projectbackend.payload.*;

import java.util.List;

public interface AdminService {

    PlacedStudentsDto addPlacedStudents(PlacedStudentsDto placedStudentsDto);
    UnplacedStudentsDto addUnplacedStudents(UnplacedStudentsDto unplacedStudentsDto);

    CurrentCompDto addCurrentComp(CurrentCompDto currentCompDto);
    UpcomingCompDto addUpcomingComp(UpcomingCompDto upcomingCompDto);


    UnplacedStudentsDto updateUnPlacedStudents(UnplacedStudentsDto unplacedStudentsDto,long id);

    PlacedStudentsDto updatePlacedStudents(PlacedStudentsDto placedStudentsDto, long id);

    StudentRegisterDto editStudent(StudentRegisterDto studentRegisterDto,long id);

    String updateAdmin(AdminRegisterDto adminRegisterDto,long id);
    CompanyDetailsDto addCompany(CompanyDetailsDto companyDetailsDto);

    String updateCompanyDetails(CompanyDetailsDto companyDetailsDto,Long id);

    List<PlacedStudentsDto> getPPOStud();



}
