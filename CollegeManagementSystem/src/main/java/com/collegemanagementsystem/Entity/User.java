package com.collegemanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="User",uniqueConstraints = @UniqueConstraint(columnNames = "User_email"))
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    private LocalDate registeredDate;
    @Column(name = "User_updatedDate")
    private LocalDate updatedDate;
    @Column(name = "User_youAre")
    private String youAre;
    @Column(name = "User_mobile")
    private Long mobile;



}
