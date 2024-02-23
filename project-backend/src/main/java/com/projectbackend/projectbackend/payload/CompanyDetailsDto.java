package com.projectbackend.projectbackend.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDetailsDto {
    private Long id;
    private String name;
    private Long packageAmt;
    private String eligible;
    private Long rounds;
}
