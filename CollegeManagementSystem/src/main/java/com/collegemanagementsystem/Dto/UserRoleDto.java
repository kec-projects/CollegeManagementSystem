package com.collegemanagementsystem.Dto;

import javax.persistence.Column;

public class UserRoleDto {
    private Long sr;
    private Long userId;
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
