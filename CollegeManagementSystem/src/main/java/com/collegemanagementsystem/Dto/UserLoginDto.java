package com.collegemanagementsystem.Dto;

import javax.validation.constraints.NotEmpty;

public class UserLoginDto {
    @NotEmpty
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
@NotEmpty
    private String password;
}
