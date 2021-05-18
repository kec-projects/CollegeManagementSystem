package com.collegemanagementsystem.Dto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

public class StudentDto {
    private Long sr;
    private Byte[] profilePic;
    private Long userId;
    private String registrationNo;
    private Long rollNo;
    private String name;
    private String department;
    private String batch;
    private String category;
    private String fatherName;
    private String motherName;
    private Long fatherContactNo;
    private Long aadhaarNo;
    private Date dateOfBirth;
    private String bloodGroup;
    private Integer sem;

    public StudentDto() {

    }

    public StudentDto(Long sr, Byte[] profilePic, Long userId, String registrationNo, Long rollNo, String name, String department, String batch, String category, String fatherName, String motherName, Long fatherContactNo, Long aadhaarNo, Date dateOfBirth, String bloodGroup, Integer sem) {
        this.sr = sr;
        this.profilePic = profilePic;
        this.userId = userId;
        this.registrationNo = registrationNo;
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        this.batch = batch;
        this.category = category;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.fatherContactNo = fatherContactNo;
        this.aadhaarNo = aadhaarNo;
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
        this.sem = sem;
    }

    public Long getSr() {
        return sr;
    }

    public void setSr(Long sr) {
        this.sr = sr;
    }

    public Byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Byte[] profilePic) {
        this.profilePic = profilePic;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Long getRollNo() {
        return rollNo;
    }

    public void setRollNo(Long rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Long getFatherContactNo() {
        return fatherContactNo;
    }

    public void setFatherContactNo(Long fatherContactNo) {
        this.fatherContactNo = fatherContactNo;
    }

    public Long getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(Long aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Integer getSem() {
        return sem;
    }

    public void setSem(Integer sem) {
        this.sem = sem;
    }
}