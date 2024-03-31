package com.projectbackend.projectbackend.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RoundDetailsDto {
    private Long id;
    private String companyName;
    private Long pkgAmt;
    private Long roundsNo;
    private String role;
    private String skills;
    private String location;
    private String workingMode;
    private String criteria;
}
