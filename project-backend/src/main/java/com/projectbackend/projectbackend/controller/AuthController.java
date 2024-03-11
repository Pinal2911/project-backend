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

    @PostMapping(value = {"/user/login"})
    public ResponseEntity<JWTAuthResponse> userLogin(@RequestBody UserLoginDto userLoginDto){
        String token=authService.userLogin(userLoginDto);
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




    @PostMapping(value = {"/admin/register","/admin/signup"})
    public ResponseEntity<String> adminRegister(@RequestBody AdminRegisterDto adminRegisterDto){
        String response= authService.adminRegister(adminRegisterDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }




    @PostMapping(value = {"/company/register","/company/signup"})
    public ResponseEntity<String> companyRegister(@RequestBody CompanyRegisterDto companyRegisterDto){
        String response= authService.companyRegister(companyRegisterDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
