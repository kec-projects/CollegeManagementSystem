package com.collegemanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "UserRoles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserRoles_sr")
    private Long sr;
    @Column(name="UserRoles_userId")
    private Long userId;
    @Column(name="UserRoles_roleName")
    private String roleName;



}
