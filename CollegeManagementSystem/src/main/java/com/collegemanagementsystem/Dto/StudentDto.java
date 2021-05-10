package com.collegemanagementsystem.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class StudentDto {
    @Id
    @GeneratedValue
    private long userID;
    private long registrationNo;
    private long rollNo;
    private String name;
    private String department;
    private long batch;
    private String category;
    private String fatherName;
    private String motherName;
    private long fatherContactNo;
    private long emergencyContactNo;
    private long aadhaarNo;
    private String dateOfBirth;
    private String bloodGroup;

    public StudentDto() {
    }

    public StudentDto(long userID, long registrationNo, long rollNo, String name, String department, long batch, String category, String fatherName, String motherName, long fatherContactNo, long emergencyContactNo, long aadhaarNo, String dateOfBirth, String bloodGroup) {
        this.userID = userID;
        this.registrationNo = registrationNo;
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        this.batch = batch;
        this.category = category;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.fatherContactNo = fatherContactNo;
        this.emergencyContactNo = emergencyContactNo;
        this.aadhaarNo = aadhaarNo;
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(long registrationNo) {
        this.registrationNo = registrationNo;
    }

    public long getRollNo() {
        return rollNo;
    }

    public void setRollNo(long rollNo) {
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

    public long getBatch() {
        return batch;
    }

    public void setBatch(long batch) {
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

    public long getFatherContactNo() {
        return fatherContactNo;
    }

    public void setFatherContactNo(long fatherContactNo) {
        this.fatherContactNo = fatherContactNo;
    }

    public long getEmergencyContactNo() {
        return emergencyContactNo;
    }

    public void setEmergencyContactNo(long emergencyContactNo) {
        this.emergencyContactNo = emergencyContactNo;
    }

    public long getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(long aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
