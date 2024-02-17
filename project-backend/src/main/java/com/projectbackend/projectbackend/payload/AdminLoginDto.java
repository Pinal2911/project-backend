package com.projectbackend.projectbackend.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoginDto {
    private String email;
    private String password;
}
