package com.projectbackend.projectbackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="company",uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns =@JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Set<Roles> roles;
}
