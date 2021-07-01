package com.collegemanagementsystem.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RoleDto {
    private Long id;
    @NotNull
    private String name;

}
