package com.collegemanagementsystem.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {

    private Long userId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String youAre;





}
