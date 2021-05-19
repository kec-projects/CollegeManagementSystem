package com.collegemanagementsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto {
    private Long sr;
    private Long userId;
    private String roleName;

}
