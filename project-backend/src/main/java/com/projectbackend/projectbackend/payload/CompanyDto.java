package com.projectbackend.projectbackend.payload;

import com.projectbackend.projectbackend.entity.Company;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private long id;
    private String email;
    private String password;
    private String name;

}
