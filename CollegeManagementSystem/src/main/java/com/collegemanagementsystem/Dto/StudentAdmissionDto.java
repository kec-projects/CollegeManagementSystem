package com.collegemanagementsystem.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StudentAdmissionDto {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotNull
    private Long mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }
}
