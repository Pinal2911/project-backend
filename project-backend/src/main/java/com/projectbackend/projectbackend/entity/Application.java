package com.projectbackend.projectbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public  class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    @ManyToOne
    @JoinColumn(name="s_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name="c_id")
    private Company company;


}