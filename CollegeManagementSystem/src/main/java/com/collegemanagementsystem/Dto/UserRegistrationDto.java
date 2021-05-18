package com.collegemanagementsystem.Dto;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

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


    public String getYouAre() {
        return youAre;
    }
    public void setYouAre(String youAre) {
        this.youAre = youAre;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
