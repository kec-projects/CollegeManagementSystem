package com.collegemanagementsystem.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="User",uniqueConstraints = @UniqueConstraint(columnNames = "User_email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_userid")
    private Long userId;
    @Column(name = "User_name")
    private String name;
    @Column(name = "User_email")
    private String email;
    @Column(name = "User_password")
    private String password;
    @Column(name = "User_accountstatus")
    private String accountStatus;
    @Column(name = "User_registeredDate")
    private Date registeredDate;
    @Column(name = "User_updatedDate")
    private Date updatedDate;

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public User() {
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

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }


}
