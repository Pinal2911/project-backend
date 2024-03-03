package com.projectbackend.projectbackend.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyLoginDto {
    private String email;
    private String password;
    private String name;
}
