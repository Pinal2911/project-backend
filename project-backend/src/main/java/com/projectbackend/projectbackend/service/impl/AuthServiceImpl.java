package com.projectbackend.projectbackend.service.impl;
import com.projectbackend.projectbackend.entity.Admin;
import com.projectbackend.projectbackend.entity.Company;
import com.projectbackend.projectbackend.entity.Roles;
import com.projectbackend.projectbackend.entity.Student;
import com.projectbackend.projectbackend.exception.TnpApiException;
import com.projectbackend.projectbackend.payload.*;
import com.projectbackend.projectbackend.repository.AdminRepository;
import com.projectbackend.projectbackend.repository.CompanyRepository;
import com.projectbackend.projectbackend.repository.RoleRepository;
import com.projectbackend.projectbackend.repository.StudentRepository;
import com.projectbackend.projectbackend.security.JWTTokenProvider;
import com.projectbackend.projectbackend.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private StudentRepository studentRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private JWTTokenProvider jwtTokenProvider;
    private AdminRepository adminRepository;
    private CompanyRepository companyRepository;

    public AuthServiceImpl(AuthenticationManager authenticationManager, StudentRepository studentRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, JWTTokenProvider jwtTokenProvider
    ,AdminRepository adminRepository,
                           CompanyRepository companyRepository) {
        this.authenticationManager = authenticationManager;
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.adminRepository=adminRepository;
        this.companyRepository=companyRepository;
    }

    @Override
    public String login(StudentLoginDto studentLoginDto) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(studentLoginDto.getFname(),studentLoginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token=jwtTokenProvider.generateToken(authentication);
        System.out.println(token);
        return token;
    }

    @Override
    public String register(StudentRegisterDto studentRegisterDto) {
        if(studentRepository.existsByFname(studentRegisterDto.getFname())){
            throw new TnpApiException(HttpStatus.BAD_REQUEST,"username already exists");

        }
        //add check for exists by email
        if(studentRepository.existsByEmail(studentRegisterDto.getEmail())){
            throw new TnpApiException(HttpStatus.BAD_REQUEST,"email already exists");
        }

        //or else ass user in db
        Student student=new Student();
        student.setFname(studentRegisterDto.getFname());
        student.setEmail(studentRegisterDto.getEmail());
        student.setPassword(passwordEncoder.encode(studentRegisterDto.getPassword()));
        

        Set<Roles> roles= new HashSet<>();
        Roles userRole=roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        student.setRoles(roles);

        studentRepository.save(student);
        return "student registered successfully";
    }

    @Override
    public String adminLogin(AdminLoginDto adminLoginDto) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(adminLoginDto.getName(),adminLoginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token=jwtTokenProvider.generateToken(authentication);
        System.out.println(token);
        return token;
    }

    @Override
    public String adminRegister(AdminRegisterDto adminRegisterDto) {
        if(adminRepository.existsByName(adminRegisterDto.getName())){
            throw new TnpApiException(HttpStatus.BAD_REQUEST,"username already exists");

        }
        //add check for exists by email
        if(adminRepository.existsByEmail(adminRegisterDto.getEmail())){
            throw new TnpApiException(HttpStatus.BAD_REQUEST,"email already exists");
        }

        //or else ass user in db
        Admin admin=new Admin();
        admin.setName(adminRegisterDto.getName());
        admin.setEmail(adminRegisterDto.getEmail());
        admin.setPassword(passwordEncoder.encode(adminRegisterDto.getPassword()));


        Set<Roles> roles= new HashSet<>();
        Roles userRole=roleRepository.findByName("ROLE_ADMIN").get();
        roles.add(userRole);
        admin.setRoles(roles);

        adminRepository.save(admin);
        return "admin registered successfully";
    }

    @Override
    public String companyLogin(CompanyLoginDto companyLoginDto) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(companyLoginDto.getName(),companyLoginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token=jwtTokenProvider.generateToken(authentication);
        System.out.println(token);
        return token;

    }

    @Override
    public String companyRegister(CompanyRegisterDto companyRegisterDto) {
        if(companyRepository.existsByName(companyRegisterDto.getName())){
            throw new TnpApiException(HttpStatus.BAD_REQUEST,"username already exists");

        }
        //add check for exists by email
        if(companyRepository.existsByEmail(companyRegisterDto.getEmail())){
            throw new TnpApiException(HttpStatus.BAD_REQUEST,"email already exists");
        }

        //or else ass user in db
        Company company=new Company();
        company.setName(companyRegisterDto.getName());
        company.setEmail(companyRegisterDto.getEmail());
        company.setPassword(passwordEncoder.encode(companyRegisterDto.getPassword()));


        Set<Roles> roles= new HashSet<>();
        Roles userRole=roleRepository.findByName("ROLE_COMPANY").get();
        roles.add(userRole);
        company.setRoles(roles);

        companyRepository.save(company);
        return "company registered successfully";

    }
}

