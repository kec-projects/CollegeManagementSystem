package com.collegemanagementsystem.Dto;



import javax.validation.constraints.NotEmpty;
import java.sql.Date;

public class FacultyDto {
    private Long sr;
    
    private Long userId;
    private String name;
    private String employmentId;
    private String department;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private Date dateOfLeaving;
    private String bloodGroup;
    private Long aadhaarNo;
    private Byte[] profilePic;


    public FacultyDto() {
    }

    public FacultyDto(Long sr, Long userId, String name, String employmentId, String department, Date dateOfBirth, Date dateOfJoining, Date dateOfLeaving, String bloodGroup, Long aadhaarNo, Byte[] profilePic) {
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
