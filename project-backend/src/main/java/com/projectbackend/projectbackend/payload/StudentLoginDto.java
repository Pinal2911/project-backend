package com.projectbackend.projectbackend.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentLoginDto {
    //student login detail
    private String email;
    private String fname;
    private String password;
}
