package com.collegemanagementsystem.Entity.profileEntity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "NonTeachingStaff")
public class NonTeachingStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NonTeaching_sr")
    private Long sr;
    @Column(name = "NonTeaching_userId")
    private Long userId;
    @Column(name = "NonTeaching_name")
    private String name;
    @Column(name = "NonTeaching_employeeId")
    private String employeeId;
    @Column(name = "NonTeaching_blood")
    private String bloodGroup;
    @Column(name = "NonTeaching_aadhaar")
    private Long aadhaarNo;
    @Column(name = "NonTeaching_designation")
    private String designation;
    @Column(name = "NonTeaching_doj")
    private Date dateOfJoining;
    @Column(name = "NonTeaching_dob")
    private Date dateOfBirth;
    @Column(name = "NonTeaching_dol")
    private Date dateOfLeaving;
    @Column(name="NonTeaching_profilePic")
    @Lob
    private Byte[] profilePic;

    public NonTeachingStaff() {
    }

    public NonTeachingStaff(Long sr, Long userId, String name, String employeeId, String bloodGroup, Long aadhaarNo, String designation, Date dateOfJoining, Date dateOfBirth, Date dateOfLeaving, Byte[] profilePic) {
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
