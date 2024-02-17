package com.projectbackend.projectbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student",uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fname;
    private String lname;
    private String mname;
    private String email;
    private String alterEmail;
    private long number;
    private long alterNumber;
    private Date dob;
    private String gender;
    private String address;
    private String permAddress;
    private String branch;
    private String division;
    private long rollno;
    private String prnNumber;
    private String pictNumber;
    private long sscPer;
    private String board;
    private int sscYear;
    private int sscGap;
    private  long hscPer;
    private String hscBoard;
    private int hscYear;
    private int hscGap;
    private long diplomaPer;
    private int diplomaYear;
    private int diplomaGap;
    private int mhCetPer;
    private int jeeMains;
    private int startYear;
    private int fe1SGPA;
    private int fe2SGPA;
    private int se1SGPA;
    private int se2SGPA;
    private int te1SGPA;
    private int te2SGPA;
    private int backlogs;
    private boolean yd;
    private long adhar;
    private String pan;
    private long passport;
    private String citizenship;
    private boolean higherEducation;
    private boolean amcat;





}
