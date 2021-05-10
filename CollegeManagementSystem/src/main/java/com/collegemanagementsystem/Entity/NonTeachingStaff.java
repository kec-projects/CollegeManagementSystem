package com.collegemanagementsystem.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NonTeachingStaff")
public class NonTeachingStaff {
    @Id
    private long userID;
    private String name;
    private long employeeID;
    private String bloodGroup;
    private long aadhaarNo;
    private String designation;
    private String dateOfJoining;
    private String dateOfBirth;

    public NonTeachingStaff() {
    }

    public NonTeachingStaff(long userID, String name, long employeeID, String bloodGroup, long aadhaarNo, String designation, String dateOfJoining, String dateOfBirth) {
        this.userID = userID;
        this.name = name;
        this.employeeID = employeeID;
        this.bloodGroup = bloodGroup;
        this.aadhaarNo = aadhaarNo;
        this.designation = designation;
        this.dateOfJoining = dateOfJoining;
        this.dateOfBirth = dateOfBirth;
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

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public long getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(long aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
