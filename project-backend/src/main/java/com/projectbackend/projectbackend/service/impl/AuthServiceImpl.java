package com.projectbackend.projectbackend.service.impl;
import com.projectbackend.projectbackend.entity.*;
import com.projectbackend.projectbackend.exception.TnpApiException;
import com.projectbackend.projectbackend.payload.*;
import com.projectbackend.projectbackend.repository.*;
import com.projectbackend.projectbackend.security.JWTTokenProvider;
import com.projectbackend.projectbackend.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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

    private UserRepository userRepository;
    public AuthServiceImpl(AuthenticationManager authenticationManager, StudentRepository studentRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, JWTTokenProvider jwtTokenProvider
    ,AdminRepository adminRepository,
                           CompanyRepository companyRepository,
                           UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.adminRepository=adminRepository;
        this.companyRepository=companyRepository;
        this.userRepository=userRepository;
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
        User user=new User();
        user.setUsername(studentRegisterDto.getFname());
        user.setPassword(passwordEncoder.encode(studentRegisterDto.getPassword()));
        user.setEmail(studentRegisterDto.getEmail());

        Set<Roles> roles= new HashSet<>();
        Roles userRole=roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
    user.setRoles(roles);
        userRepository.save(user);
        studentRepository.save(student);
        return "student registered successfully";
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

        User user=new User();
        user.setUsername(adminRegisterDto.getName());
        user.setPassword(passwordEncoder.encode(adminRegisterDto.getPassword()));
        user.setEmail(adminRegisterDto.getEmail());
        //or else ass user in db
        Admin admin=new Admin();
        admin.setName(adminRegisterDto.getName());
        admin.setEmail(adminRegisterDto.getEmail());
        admin.setPassword(passwordEncoder.encode(adminRegisterDto.getPassword()));


        Set<Roles> roles= new HashSet<>();
        Roles userRole=roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(roles);
        roles.add(userRole);


        userRepository.save(user);
        adminRepository.save(admin);

        return "admin registered successfully";
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

        User user=new User();
        user.setUsername(companyRegisterDto.getName());
        user.setPassword(passwordEncoder.encode(companyRegisterDto.getPassword()));
        user.setEmail(companyRegisterDto.getEmail());

        Set<Roles> roles= new HashSet<>();
        Roles userRole=roleRepository.findByName("ROLE_COMPANY").get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);
        companyRepository.save(company);
        return "company registered successfully";

    }

    @Override
    public String userLogin(UserLoginDto userLoginDto) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginDto.getUsernameOrEmail(),userLoginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token=jwtTokenProvider.generateToken(authentication);
        System.out.println(token);
        return token;
    }
}

