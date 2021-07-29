package com.collegemanagementsystem.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalDto {

    private Long sr;
    @NotNull
    private String name;
    @NotNull
    private String id;
    @NotNull
    private String startDate;
    @NotNull
    private String endDate;
}
