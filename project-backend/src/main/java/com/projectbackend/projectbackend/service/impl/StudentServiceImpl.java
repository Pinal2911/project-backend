package com.projectbackend.projectbackend.service.impl;

import com.projectbackend.projectbackend.entity.*;
import com.projectbackend.projectbackend.payload.*;
import com.projectbackend.projectbackend.repository.*;
import com.projectbackend.projectbackend.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    CurrentCompReposiotry currentCompReposiotry;
    UpcomingCompRepository upcomingCompRepository;
    PlacedRepository placedRepository;
    UnplacedRepository unplacedRepository;
    RoundDetailsRepository roundDetailsRepository;
    ModelMapper modelMapper;

    public StudentServiceImpl(CurrentCompReposiotry currentCompReposiotry,
                              ModelMapper modelMapper,
                              UpcomingCompRepository upcomingCompRepository,
                              PlacedRepository placedRepository,
                              UnplacedRepository unplacedRepository,
                              RoundDetailsRepository roundDetailsRepository) {
        this.currentCompReposiotry = currentCompReposiotry;
        this.modelMapper=modelMapper;
        this.upcomingCompRepository=upcomingCompRepository;
        this.placedRepository=placedRepository;
        this.unplacedRepository=unplacedRepository;
        this.roundDetailsRepository=roundDetailsRepository;
    }

    @Override
    public List<CurrentCompDto> currentComp() {
        List<CurrentCompDto> currentComp=new ArrayList<>();
        Iterable<CurrentCompany> compList=currentCompReposiotry.findAll();


        for(CurrentCompany comp:compList){
            currentComp.add(modelMapper.map(comp, CurrentCompDto.class));
        }
        return currentComp;
    }

    @Override
    public List<UpcomingCompDto> upComingComp() {
        List<UpcomingCompDto> upcomingComp=new ArrayList<>();
        Iterable< UpcomingCompany> compList=upcomingCompRepository.findAll();

        for(UpcomingCompany comp:compList){
            upcomingComp.add(modelMapper.map(comp, UpcomingCompDto.class));
        }
        return upcomingComp;
    }

    @Override
    public List<PlacedStudentsDto> placedStudents() {
        List<PlacedStudentsDto> placedStudentsDtos=new ArrayList<>();
        Iterable<PlacedStudents> placedStudents=placedRepository.findAll();
        for(PlacedStudents stud:placedStudents){
            placedStudentsDtos.add(modelMapper.map(stud, PlacedStudentsDto.class));
        }
        return  placedStudentsDtos;
    }

    @Override
    public List<UnplacedStudentsDto> unplacedStudents() {
        List<UnplacedStudentsDto> unplacedStudentsDtos=new ArrayList<>();
        Iterable<UnplacedStudents> unplacedStudents=unplacedRepository.findAll();
        for(UnplacedStudents stud:unplacedStudents){
            unplacedStudentsDtos.add(modelMapper.map(stud, UnplacedStudentsDto.class));
        }
        return unplacedStudentsDtos;
    }

    @Override
    public List<UpcomingCompDto> onBoardApply() {
        List<UpcomingCompDto> upcomingCompApply=new ArrayList<>();
        Iterable<UpcomingCompany> upcomingCompanies=upcomingCompRepository.findAll();
        for(UpcomingCompany upcomingCompany:upcomingCompanies){
            if(upcomingCompany.isOnBoard()){
                upcomingCompApply.add(modelMapper.map(upcomingCompany, UpcomingCompDto.class));
            }
        }
        return upcomingCompApply;
    }

    @Override
    public List<RoundDetailsDto> getRoundDetails() {
        List<RoundDetailsDto> roundDetailsDtos=new ArrayList<>();
        Iterable<RoundDetails> roundDetails=roundDetailsRepository.findAll();
        for(RoundDetails roundDetails1:roundDetails){
            roundDetailsDtos.add(modelMapper.map(roundDetails1,RoundDetailsDto.class));
        }
        return roundDetailsDtos;
    }

    @Override
    public List<StudentRegisterDto> getStudentByID(Long id) {
        return null;
    }
}
