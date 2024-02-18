package com.projectbackend.projectbackend.service.impl;

import com.projectbackend.projectbackend.entity.CurrentCompany;
import com.projectbackend.projectbackend.entity.PlacedStudents;
import com.projectbackend.projectbackend.entity.UnplacedStudents;
import com.projectbackend.projectbackend.entity.UpcomingCompany;
import com.projectbackend.projectbackend.exception.ResourceNotFoundException;
import com.projectbackend.projectbackend.payload.CurrentCompDto;
import com.projectbackend.projectbackend.payload.PlacedStudentsDto;
import com.projectbackend.projectbackend.payload.UnplacedStudentsDto;
import com.projectbackend.projectbackend.payload.UpcomingCompDto;
import com.projectbackend.projectbackend.repository.CurrentCompReposiotry;
import com.projectbackend.projectbackend.repository.PlacedRepository;
import com.projectbackend.projectbackend.repository.UnplacedRepository;
import com.projectbackend.projectbackend.repository.UpcomingCompRepository;
import com.projectbackend.projectbackend.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private PlacedRepository placedRepository;
    private ModelMapper modelMapper;
    private UnplacedRepository unplacedRepository;
    private UpcomingCompRepository upcomingCompRepository;
    private CurrentCompReposiotry currentCompReposiotry;
    private AdminServiceImpl(PlacedRepository placedRepository, ModelMapper modelMapper, UnplacedRepository unplacedRepository,
                             UpcomingCompRepository upcomingCompRepository, CurrentCompReposiotry currentCompReposiotry){
        this.placedRepository=placedRepository;
        this.unplacedRepository=unplacedRepository;
        this.upcomingCompRepository=upcomingCompRepository;
        this.currentCompReposiotry=currentCompReposiotry;
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

    @Override
    public CurrentCompDto addCurrentComp(CurrentCompDto currentCompDto) {
        CurrentCompany currentCompany=modelMapper.map(currentCompDto,CurrentCompany.class);
        CurrentCompany newComp=currentCompReposiotry.save(currentCompany);
        CurrentCompDto addedComp=modelMapper.map(newComp, CurrentCompDto.class);
        return addedComp;
    }

    @Override
    public UpcomingCompDto addUpcomingComp(UpcomingCompDto upcomingCompDto) {
        UpcomingCompany upcomingCompany=modelMapper.map(upcomingCompDto, UpcomingCompany.class);
        UpcomingCompany newComp=upcomingCompRepository.save(upcomingCompany);
        UpcomingCompDto addedComp=modelMapper.map(newComp, UpcomingCompDto.class);
        return addedComp;
    }

    @Override
    public PlacedStudentsDto updatePlacedStudents(PlacedStudentsDto placedStudentsDto, Long id) {
        //to be implemented
        return null;
    }

    @Override
    public PlacedStudentsDto updatePlacedStudents(PlacedStudentsDto placedStudentsDto, long id) {

        PlacedStudents p=placedRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student","id","id"));
        p.setFname(placedStudentsDto.getFname());
        p.setLname(placedStudentsDto.getLname());
        p.setGender(placedStudentsDto.getGender());
        p.setBranch(placedStudentsDto.getBranch());
        p.setEmail(placedStudentsDto.getEmail());
        p.setPictNumber(placedStudentsDto.getPictNumber());
        p.setNumber(placedStudentsDto.getNumber());

        return null;
    }


}
