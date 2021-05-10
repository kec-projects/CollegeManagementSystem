package com.collegemanagementsystem.Entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "id_gen")
    @SequenceGenerator(name="id_gen",initialValue = 1290,allocationSize = 10)
    @Column(name="userid")
    private Integer userId;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="accountstatus")
    private String accountStatus;
    @Column(name="registeredon")
    private Date registeredOn;
    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public User() {

    }

    public Date getRegisteredOn() {
        return registeredOn;
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
