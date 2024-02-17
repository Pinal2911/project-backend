package com.projectbackend.projectbackend.service.impl;

import com.projectbackend.projectbackend.entity.PlacedStudents;
import com.projectbackend.projectbackend.entity.UnplacedStudents;
import com.projectbackend.projectbackend.payload.PlacedStudentsDto;
import com.projectbackend.projectbackend.payload.UnplacedStudentsDto;
import com.projectbackend.projectbackend.repository.PlacedRepository;
import com.projectbackend.projectbackend.repository.UnplacedRepository;
import com.projectbackend.projectbackend.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private PlacedRepository placedRepository;
    private ModelMapper modelMapper;
    private UnplacedRepository unplacedRepository;
    private AdminServiceImpl(PlacedRepository placedRepository,ModelMapper modelMapper,UnplacedRepository unplacedRepository){
        this.placedRepository=placedRepository;
        this.unplacedRepository=unplacedRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public PlacedStudentsDto addPlacedStudents(PlacedStudentsDto placedStudentsDto) {

        PlacedStudents placedStudents=modelMapper.map(placedStudentsDto, PlacedStudents.class);
        PlacedStudents newStud=placedRepository.save(placedStudents);

        PlacedStudentsDto addedStudent=modelMapper.map(newStud,PlacedStudentsDto.class);
        return addedStudent;
    }

    @Override
    public UnplacedStudentsDto addUnplacedStudents(UnplacedStudentsDto unplacedStudentsDto) {
        UnplacedStudents unplacedStudents=modelMapper.map(unplacedStudentsDto, UnplacedStudents.class);
        UnplacedStudents newStud=unplacedRepository.save(unplacedStudents);

        UnplacedStudentsDto addedStudent=modelMapper.map(newStud, UnplacedStudentsDto.class);

        return  addedStudent;


    }


}
