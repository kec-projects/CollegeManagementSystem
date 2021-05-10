package com.collegemanagementsystem.Dto;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class UserRegistrationDto {

    private Integer userId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    private String accountStatus;
    private Date registeredOn;
    @NotEmpty
    private String youAre;


    public String getYouAre() {
        return youAre;
    }
    public void setYouAre(String youAre) {
        this.youAre = youAre;
    }
    public Date getRegisteredOn() {
        return registeredOn;
    }
    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
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

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }



}
