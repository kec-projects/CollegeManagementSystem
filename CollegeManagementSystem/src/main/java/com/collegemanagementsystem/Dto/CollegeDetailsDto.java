package com.collegemanagementsystem.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollegeDetailsDto {
    private Long id;
    private String name;
    private String address;
    private Long phone;
    private String affiliationTo;
    private String established;
}
