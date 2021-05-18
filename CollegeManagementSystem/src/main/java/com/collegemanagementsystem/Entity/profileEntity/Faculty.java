package com.collegemanagementsystem.Entity.profileEntity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Faculty_sr")
    private Long sr;
    @Column(name = "Faculty_userId")
    private Long userId;
    @Column(name = "Faculty_name")
    private String name;
    @Column(name = "Faculty_employId")
    private String employmentId;
    @Column(name = "Faculty_department")
    private String department;
    @Column(name = "Faculty_dob")
    private Date dateOfBirth;
    @Column(name = "Faculty_doj")
    private Date dateOfJoining;
    @Column(name = "Faculty_dol")
    private Date dateOfLeaving;
    @Column(name = "Faculty_blood")
    private String bloodGroup;
    @Column(name = "Faculty_aadhaar")
    private Long aadhaarNo;
    @Column(name = "Faculty_profilePic")
    @Lob
    private Byte[] profilePic;

    public Faculty() {
    }

    public Faculty(Long sr, Long userId, String name, String employmentId, String department, Date dateOfBirth, Date dateOfJoining, Date dateOfLeaving, String bloodGroup, Long aadhaarNo, Byte[] profilePic) {
        this.sr = sr;
        this.userId = userId;
        this.name = name;
        this.employmentId = employmentId;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.dateOfLeaving = dateOfLeaving;
        this.bloodGroup = bloodGroup;
        this.aadhaarNo = aadhaarNo;
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

    public String getEmploymentId() {
        return employmentId;
    }

    public void setEmploymentId(String employmentId) {
        this.employmentId = employmentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Date getDateOfLeaving() {
        return dateOfLeaving;
    }

    public void setDateOfLeaving(Date dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
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

    public Byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Byte[] profilePic) {
        this.profilePic = profilePic;
    }
}
