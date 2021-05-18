package com.collegemanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name = "UserRoles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserRoles_sr")
    private Long sr;
    @Column(name="UserRoles_userId")
    private Long userId;
    @Column(name="UserRoles_roleName")
    private String roleName;

    public Long getUserid() {
        return userId;
    }

    public void setUserid(Long userid) {
        this.userId = userid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }



}
