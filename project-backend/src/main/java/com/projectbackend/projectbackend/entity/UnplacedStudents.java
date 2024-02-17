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
@Table(name="unplacedStudents",uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class UnplacedStudents {
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
}
