package com.projectbackend.projectbackend.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRegisterDto {
    private String email;
    private String password;
    private String name;
}
