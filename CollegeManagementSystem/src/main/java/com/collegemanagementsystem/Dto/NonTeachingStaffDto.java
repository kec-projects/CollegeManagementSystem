package com.collegemanagementsystem.Dto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;


public class NonTeachingStaffDto {
    private Long sr;
    private Long userId;
    private String name;
    private String employeeId;
    private String bloodGroup;
    private Long aadhaarNo;
    private String designation;
    private Date dateOfJoining;
    private Date dateOfBirth;
    private Date dateOfLeaving;
    private Byte[] profilePic;


    public NonTeachingStaffDto() {
    }

    public NonTeachingStaffDto(Long sr, Long userId, String name, String employeeId, String bloodGroup, Long aadhaarNo, String designation, Date dateOfJoining, Date dateOfBirth, Date dateOfLeaving, Byte[] profilePic) {
        this.sr = sr;
        this.userId = userId;
        this.name = name;
        this.employeeId = employeeId;
        this.bloodGroup = bloodGroup;
        this.aadhaarNo = aadhaarNo;
        this.designation = designation;
        this.dateOfJoining = dateOfJoining;
        this.dateOfBirth = dateOfBirth;
        this.dateOfLeaving = dateOfLeaving;
        this.profilePic = profilePic;
    }

    public Long getSr() {
        return sr;
    }

    public void setSr(Long sr) {
        this.sr = sr;
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Long getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(Long aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfLeaving() {
        return dateOfLeaving;
    }

    public void setDateOfLeaving(Date dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
    }

    public Byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Byte[] profilePic) {
        this.profilePic = profilePic;
    }
}
