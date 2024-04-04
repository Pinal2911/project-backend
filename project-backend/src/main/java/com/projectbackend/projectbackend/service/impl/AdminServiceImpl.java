package com.projectbackend.projectbackend.service.impl;

import com.projectbackend.projectbackend.entity.*;
import com.projectbackend.projectbackend.exception.ResourceNotFoundException;
import com.projectbackend.projectbackend.payload.*;
import com.projectbackend.projectbackend.repository.*;
import com.projectbackend.projectbackend.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private PlacedRepository placedRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    private AdminRepository adminRepository;
    private UnplacedRepository unplacedRepository;
    private UpcomingCompRepository upcomingCompRepository;
    private CurrentCompReposiotry currentCompReposiotry;


    private StudentRepository studentRepository;
    private CompanyListRepository companyListRepository;
    private AdminServiceImpl(PlacedRepository placedRepository, ModelMapper modelMapper, UnplacedRepository unplacedRepository,
                             UpcomingCompRepository upcomingCompRepository, CurrentCompReposiotry currentCompReposiotry,
                             StudentRepository studentRepository,CompanyListRepository companyListRepository,
                             AdminRepository adminRepository,
                             PasswordEncoder passwordEncoder){
        this.placedRepository=placedRepository;
        this.unplacedRepository=unplacedRepository;
        this.upcomingCompRepository=upcomingCompRepository;
        this.currentCompReposiotry=currentCompReposiotry;
        this.modelMapper=modelMapper;
        this.studentRepository=studentRepository;
        this.companyListRepository=companyListRepository;
        this.adminRepository=adminRepository;
        this.passwordEncoder=passwordEncoder;

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
    public UnplacedStudentsDto updateUnPlacedStudents(UnplacedStudentsDto unplacedStudentsDto,long id) {
        UnplacedStudents p=unplacedRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student","id","id"));
        //note update this only if new dto field are not empty
        //apply the same

        p.setLname(unplacedStudentsDto.getLname());
        if(unplacedStudentsDto.getFname() != null) {
            p.setFname(unplacedStudentsDto.getFname());
        }
        if(unplacedStudentsDto.getGender() !=null)
            p.setGender(unplacedStudentsDto.getGender());
        if(unplacedStudentsDto.getEmail() != null)
            p.setEmail(unplacedStudentsDto.getEmail());
        if(unplacedStudentsDto.getPictNumber() != null)
            p.setPictNumber(unplacedStudentsDto.getPictNumber());
        if(unplacedStudentsDto.getNumber() != null)
            p.setNumber(unplacedStudentsDto.getNumber());
        if(unplacedStudentsDto.getBranch() !=null)
            p.setBranch(unplacedStudentsDto.getBranch());
        if(unplacedStudentsDto.getLname() != null)
            p.setLname(unplacedStudentsDto.getLname());

        UnplacedStudents updatedStud=unplacedRepository.save(p);
        return modelMapper.map(updatedStud,UnplacedStudentsDto.class);
    }


    @Override
    public PlacedStudentsDto updatePlacedStudents(PlacedStudentsDto placedStudentsDto, long id) {

        PlacedStudents p=placedRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student","id","id"));
        if(placedStudentsDto.getFname() !=null)
            p.setFname(placedStudentsDto.getFname());
        if(placedStudentsDto.getLname() != null)
            p.setLname(placedStudentsDto.getLname());

        if(placedStudentsDto.getGender() != null)
            p.setGender(placedStudentsDto.getGender());

        if(placedStudentsDto.getBranch() !=null)
            p.setBranch(placedStudentsDto.getBranch());

        if(placedStudentsDto.getEmail() != null)
            p.setEmail(placedStudentsDto.getEmail());

        if(placedStudentsDto.getPictNumber() != null)
            p.setPictNumber(placedStudentsDto.getPictNumber());

        if(placedStudentsDto.getNumber() != null)
            p.setNumber(placedStudentsDto.getNumber());
        PlacedStudents placedStudents=placedRepository.save(p);


        return modelMapper.map(placedStudents,PlacedStudentsDto.class);
    }

    @Override
    public StudentRegisterDto editStudent(StudentRegisterDto studentRegisterDto, long id) {
        Student s=studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student","id","id"));
        if(studentRegisterDto.getFname()!=null){
            System.out.println(studentRegisterDto.getFname());
            s.setFname(studentRegisterDto.getFname());
        }
        if(studentRegisterDto.getLname()!=null){
            s.setLname(studentRegisterDto.getLname());
        }
        if(studentRegisterDto.getMname()!=null){
            s.setMname(studentRegisterDto.getMname());
        }
        if(studentRegisterDto.getEmail()!=null){
            s.setEmail(studentRegisterDto.getEmail());
        }
        if(studentRegisterDto.getAlterEmail()!=null){
            s.setFname(studentRegisterDto.getAlterEmail());
        }
        if(studentRegisterDto.getNumber() != null){
            s.setNumber(studentRegisterDto.getNumber());
        }
        if(studentRegisterDto.getDob() != null){
            s.setDob(studentRegisterDto.getDob());
        }
        if(studentRegisterDto.getAlterNumber() != null){
            s.setAlterEmail(studentRegisterDto.getAlterEmail());
        }
        if(studentRegisterDto.getGender() != null){
            System.out.println(studentRegisterDto.getGender());
            s.setGender(studentRegisterDto.getGender());
        }
        if(studentRegisterDto.getAddress() != null){
            s.setAddress(studentRegisterDto.getAddress());
        }
        if(studentRegisterDto.getPermAddress() != null){
            s.setPermAddress(studentRegisterDto.getPermAddress());
        }
        if(studentRegisterDto.getBranch() !=null){
            s.setBranch(studentRegisterDto.getBranch());
        }
        if(studentRegisterDto.getDivision()!=null){
            s.setDivision(studentRegisterDto.getDivision());
        }
        if(studentRegisterDto.getRollno() != null){
            s.setRollno(studentRegisterDto.getRollno());
        }
        if(studentRegisterDto.getPrnNumber() != null){
            s.setPrnNumber(studentRegisterDto.getPrnNumber());
        }
        if(studentRegisterDto.getPictNumber() != null){
            s.setPictNumber(studentRegisterDto.getPictNumber());
        }
        if(studentRegisterDto.getSscPer() !=null){
            s.setSscPer(studentRegisterDto.getSscPer());
        }
        if(studentRegisterDto.getBoard() != null){
            s.setBoard(studentRegisterDto.getBoard());
        }
        if(studentRegisterDto.getSscYear() != 0){
            s.setSscYear(studentRegisterDto.getSscYear());
        }
        if(studentRegisterDto.getSscGap() != 0){
            s.setSscGap(studentRegisterDto.getSscGap());
        }
        if(studentRegisterDto.getHscGap() !=0){
            s.setHscGap(studentRegisterDto.getHscGap());
        }
        if(studentRegisterDto.getHscPer() !=null){
            s.setHscPer(studentRegisterDto.getHscPer());
        }
        if(studentRegisterDto.getHscGap() !=0){
            s.setHscGap(studentRegisterDto.getHscGap());
        }
        if(studentRegisterDto.getDiplomaPer() !=null){
            s.setDiplomaPer(studentRegisterDto.getDiplomaPer());
        }
        if(studentRegisterDto.getDiplomaYear() !=0){
            s.setDiplomaYear(studentRegisterDto.getDiplomaYear());
        }
        if(studentRegisterDto.getDiplomaGap() !=0){
            s.setDiplomaGap(studentRegisterDto.getDiplomaGap());
        }
        if(studentRegisterDto.getMhCetPer()!=0){
            s.setMhCetPer(studentRegisterDto.getMhCetPer());
        }
        if(studentRegisterDto.getJeeMains() !=0){
            s.setJeeMains(studentRegisterDto.getJeeMains());
        }
        if(studentRegisterDto.getStartYear() !=0){
            s.setStartYear(studentRegisterDto.getStartYear());
        }
        if(studentRegisterDto.getFe1SGPA() !=0){
            s.setFe1SGPA(studentRegisterDto.getFe1SGPA());
        }
        if(studentRegisterDto.getFe2SGPA() !=0){
            s.setFe2SGPA(studentRegisterDto.getFe2SGPA());
        }
        if(studentRegisterDto.getSe1SGPA()!=0){
            s.setSe1SGPA(studentRegisterDto.getSe1SGPA());
        }
        if(studentRegisterDto.getSe2SGPA() !=0){
            s.setSe2SGPA(studentRegisterDto.getSe2SGPA());
        }
        if(studentRegisterDto.getTe1SGPA()!=0){
            s.setTe1SGPA(studentRegisterDto.getTe1SGPA());
        }
        if(studentRegisterDto.getTe2SGPA()!=0){
            s.setTe1SGPA(studentRegisterDto.getTe1SGPA());
        }
        if(studentRegisterDto.getBacklogs()!=0){
            s.setBacklogs(studentRegisterDto.getBacklogs());
        }
        if(studentRegisterDto.isYd()){
            s.setYd(true);
        }
        if(studentRegisterDto.getAdhar() !=null){
            s.setAdhar(studentRegisterDto.getAdhar());
        }

        if(studentRegisterDto.getPan() != null){
            s.setPan(studentRegisterDto.getPan());
        }
        if(studentRegisterDto.getPassport() != null){
            s.setPassport(studentRegisterDto.getPassport());
        }
        if(studentRegisterDto.getCitizenship() != null){
            s.setCitizenship(studentRegisterDto.getCitizenship());
        }
        if(studentRegisterDto.isHigherEducation()){
            s.setHigherEducation(true);
        }
        if(studentRegisterDto.isAmcat()){
            s.setAmcat(true);
        }

        Student editStud=studentRepository.save(s);

        return modelMapper.map(editStud,StudentRegisterDto.class);
    }

    @Override
    public String updateAdmin(AdminRegisterDto adminRegisterDto, long id) {
        Admin admin=adminRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("admin","id","id"));
        if(adminRegisterDto.getEmail() !=null)
            admin.setEmail(adminRegisterDto.getEmail());
        if(adminRegisterDto.getPassword() !=null)
            admin.setPassword(passwordEncoder.encode(adminRegisterDto.getPassword()));
        if(adminRegisterDto.getName() !=null)
            admin.setName(adminRegisterDto.getName());
        adminRepository.save(admin);
        return "admin details updated";
    }

    @Override
    public CompanyDetailsDto addCompany(CompanyDetailsDto companyDetailsDto) {

            CompanyDetails companyDetails=modelMapper.map(companyDetailsDto,CompanyDetails.class);
            CompanyDetails newComp=companyListRepository.save(companyDetails);

            CompanyDetailsDto addedComp=modelMapper.map(newComp,CompanyDetailsDto.class);
        return addedComp;
    }

    @Override
    public String updateCompanyDetails(CompanyDetailsDto companyDetailsDto, Long id) {

        CompanyDetails companyDetails=companyListRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("company","id","id"));
        companyDetails.setName(companyDetailsDto.getName());
        companyDetails.setEligible(companyDetailsDto.getEligible());
        companyDetails.setRounds(companyDetailsDto.getRounds());
        companyDetails.setPackageAmt(companyDetailsDto.getPackageAmt());
        companyDetails.setProcess(companyDetailsDto.getProcess());

        companyListRepository.save(companyDetails);
        return "company details updated!";
    }

    @Override
    public List<PlacedStudentsDto> getPPOStud() {
        List<PlacedStudentsDto> ppoResult=new ArrayList<>();
        Iterable<PlacedStudents> allComp= placedRepository.findAll();
        for(PlacedStudents comp:allComp){
            if(comp.isPpo()){
                ppoResult.add(modelMapper.map(comp,PlacedStudentsDto.class));
            }
        }

    return ppoResult;
    }


}
