package com.projectbackend.projectbackend.controller;

import com.projectbackend.projectbackend.payload.*;
import com.projectbackend.projectbackend.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/placement/auth")
public class AuthController {

    private AuthService authService;
    private ModelMapper modelMapper;
    public AuthController(AuthService authService,ModelMapper modelMapper){
        this.authService=authService;
        this.modelMapper=modelMapper;
    }

    @PostMapping(value = {"/student/login","/student/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody StudentLoginDto studentLoginDto){
        System.out.println(studentLoginDto.getPassword());
        System.out.println(studentLoginDto.getFname());
        String token=authService.login(studentLoginDto);
        System.out.println(token);
        JWTAuthResponse jwtAuthResponse=new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping(value = {"/student/register","/student/signup"})
    public ResponseEntity<String> register(@RequestBody StudentRegisterDto studentRegisterDto){
        String response= authService.register(studentRegisterDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping(value = {"/admin/login","/admin/signin"})
    public ResponseEntity<JWTAuthResponse> adminLogin(@RequestBody AdminLoginDto adminLoginDto){
        System.out.println(adminLoginDto.getPassword());
        System.out.println(adminLoginDto.getName());
        String token=authService.adminLogin(adminLoginDto);
        System.out.println(token);
        JWTAuthResponse jwtAuthResponse=new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping(value = {"/admin/register","/admin/signup"})
    public ResponseEntity<String> adminRegister(@RequestBody AdminRegisterDto adminRegisterDto){
        String response= authService.adminRegister(adminRegisterDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping(value = {"/company/login","/company/signin"})
    public ResponseEntity<JWTAuthResponse> companyLogin(@RequestBody CompanyLoginDto companyLoginDto){
        System.out.println(companyLoginDto.getPassword());
        System.out.println(companyLoginDto.getName());
        String token=authService.companyLogin(companyLoginDto);
        System.out.println(token);
        JWTAuthResponse jwtAuthResponse=new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping(value = {"/company/register","/company/signup"})
    public ResponseEntity<String> companyRegister(@RequestBody CompanyRegisterDto companyRegisterDto){
        String response= authService.companyRegister(companyRegisterDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
