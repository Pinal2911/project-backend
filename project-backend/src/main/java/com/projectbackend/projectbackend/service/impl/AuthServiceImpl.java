package com.projectbackend.projectbackend.service.impl;

import com.projectbackend.projectbackend.entity.Roles;
import com.projectbackend.projectbackend.entity.Student;
import com.projectbackend.projectbackend.exception.TnpApiException;
import com.projectbackend.projectbackend.payload.StudentLoginDto;
import com.projectbackend.projectbackend.payload.StudentRegisterDto;

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

    public AuthServiceImpl(AuthenticationManager authenticationManager, StudentRepository studentRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, JWTTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.jwtTokenProvider = jwtTokenProvider;
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
}

