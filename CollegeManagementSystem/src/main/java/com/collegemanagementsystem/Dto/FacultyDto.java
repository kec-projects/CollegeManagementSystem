package com.collegemanagementsystem.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class FacultyDto {
    @Id
    @GeneratedValue
    private long userID;
    private  String name;
    private long employmentID;
    private String department;
    private String dateOfBirth;
    private String dateOfJoining;
    private String bloodGroup;
    private long emergencyContactNo;
    private long aadhaarNo;

    public FacultyDto() {
    }

    public FacultyDto(long userID, String name, long employmentID, String department, String dateOfBirth, String dateOfJoining, String bloodGroup, long emergencyContactNo, long aadhaarNo) {
        this.userID = userID;
        this.name = name;
        this.employmentID = employmentID;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.bloodGroup = bloodGroup;
        this.emergencyContactNo = emergencyContactNo;
        this.aadhaarNo = aadhaarNo;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEmploymentID() {
        return employmentID;
    }

    public void setEmploymentID(long employmentID) {
        this.employmentID = employmentID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
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
}
