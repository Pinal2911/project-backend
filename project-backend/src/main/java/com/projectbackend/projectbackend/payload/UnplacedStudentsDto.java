package com.projectbackend.projectbackend.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnplacedStudentsDto {
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private Long number;
    private String gender;
    private String branch;
    private String pictNumber;
}
