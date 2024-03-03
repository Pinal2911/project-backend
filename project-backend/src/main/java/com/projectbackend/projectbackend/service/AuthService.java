package com.projectbackend.projectbackend.service;

import com.projectbackend.projectbackend.payload.*;
import com.projectbackend.projectbackend.repository.AdminRepository;

public interface AuthService {
    String login(StudentLoginDto studentLoginDto);
    String register(StudentRegisterDto studentRegisterDto);
    String adminLogin(AdminLoginDto adminLoginDto);
    String adminRegister(AdminRegisterDto adminRegisterDto);

    String companyLogin(CompanyLoginDto companyLoginDto);
    String companyRegister(CompanyRegisterDto companyRegisterDto);
}
