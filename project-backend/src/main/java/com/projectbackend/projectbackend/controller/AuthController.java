package com.projectbackend.projectbackend.controller;

import com.projectbackend.projectbackend.payload.JWTAuthResponse;
import com.projectbackend.projectbackend.payload.StudentLoginDto;
import com.projectbackend.projectbackend.payload.StudentRegisterDto;
import com.projectbackend.projectbackend.service.AuthService;
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
    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping(value = {"/student/login","/student/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody StudentLoginDto studentLoginDto){
        String token=authService.login(studentLoginDto);
        JWTAuthResponse jwtAuthResponse=new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping(value = {"/student/register","/student/signup"})
    public ResponseEntity<String> register(@RequestBody StudentRegisterDto studentRegisterDto){
        String response= authService.register(studentRegisterDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
