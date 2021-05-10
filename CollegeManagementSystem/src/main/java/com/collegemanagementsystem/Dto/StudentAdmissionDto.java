package com.collegemanagementsystem.Dto;

import javax.validation.constraints.NotEmpty;

public class StudentAdmissionDto {
    private Integer sid;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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


}
