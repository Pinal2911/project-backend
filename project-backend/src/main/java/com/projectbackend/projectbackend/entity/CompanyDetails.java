package com.projectbackend.projectbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="companyDetails",uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class CompanyDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Long packageAmt;
    //note->eligible and criteria both are same
    private String eligible;
    private Long rounds;
    private String process;



}






