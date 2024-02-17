package com.projectbackend.projectbackend.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpcomingCompDto {
    private Long id;
    private String companyName;
    private int packageAmt;
}
