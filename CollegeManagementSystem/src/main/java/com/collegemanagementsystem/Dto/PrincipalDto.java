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
public class PrincipalDto {

    private Long sr;
    private String name;
    private String id;
    private Date startDate;
    private Date endDate;
}
