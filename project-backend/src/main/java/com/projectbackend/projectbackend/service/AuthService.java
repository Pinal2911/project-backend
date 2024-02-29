package com.projectbackend.projectbackend.service;

import com.projectbackend.projectbackend.payload.StudentLoginDto;
import com.projectbackend.projectbackend.payload.StudentRegisterDto;

public interface AuthService {
    String login(StudentLoginDto studentLoginDto);
    String register(StudentRegisterDto studentRegisterDto);
}
