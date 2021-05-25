package com.collegemanagementsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentAdmissionDto {
    private Long userId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotNull
    private Long mobile;

}
