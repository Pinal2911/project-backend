package com.projectbackend.projectbackend.service;

import com.projectbackend.projectbackend.payload.*;

public interface AuthService {

    String register(StudentRegisterDto studentRegisterDto);

    String adminRegister(AdminRegisterDto adminRegisterDto);


    String companyRegister(CompanyRegisterDto companyRegisterDto);

    String userLogin(UserLoginDto userLoginDto);
}
