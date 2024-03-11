package com.projectbackend.projectbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    //one user to mapped to set of roles
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    //creating thrid table and linking the columns to it
    @JoinTable(name = "users_roles",
            //user table linked with id(user id)
            joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
            //roles table liked with id(roles id)
            inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
    private Set<Roles> roles;

}
