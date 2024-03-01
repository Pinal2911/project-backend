package com.projectbackend.projectbackend.security;

import com.projectbackend.projectbackend.entity.Student;
import com.projectbackend.projectbackend.repository.StudentRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class CustomStudentDetailsService implements UserDetailsService {

    private StudentRepository studentRepository;

    public CustomStudentDetailsService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student=studentRepository.findByFnameOrEmail(username,username)
                .orElseThrow(()-> new UsernameNotFoundException("student not found with username or email"+username));

        Set<GrantedAuthority> authorities=student.getRoles()
                .stream()
                .map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(student.getEmail(),student.getPassword(),authorities);
    }
}
