package com.projectbackend.projectbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="placedStudents", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class PlacedStudents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private Long number;
    private String gender;
    private String branch;
    private String pictNumber;
    private String companyName;
    private int pkgAmt;
    private boolean ppo;
}
