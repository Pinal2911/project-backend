package com.projectbackend.projectbackend.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentCompDto {
    private Long id;
    private String companyName;
    private int packageAmt;
}
