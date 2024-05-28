//package com.projectbackend.projectbackend.entity;
//
//
//import com.projectbackend.projectbackend.utils.ApplicationStatus;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name="applications")
//public class Application {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @ManyToOne
//    @JoinColumn(name="student_id",nullable = false)
//    private long sid;
//
//    @ManyToOne
//    @JoinColumn(name = "company_id",nullable = false)
//    private long cid;
//
//    @Enumerated(EnumType.STRING)
//    private ApplicationStatus status;
//
//    public Application(long sid, long cid, ApplicationStatus status) {
//        this.sid = sid;
//        this.cid = cid;
//        this.status = status;
//    }
//}
