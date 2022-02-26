package com.pan.bean;

public class Admin {
    private Integer admId;

    private String admName;

    private String admSex;

    private Integer admAge;

    private String admFaculty;

    private String admDepartment;

    private String admPhone;

    private String admUsername;

    private String admPassword;

    public Admin() {
    }

    public Admin(Integer admId, String admName, String admSex, Integer admAge, String admFaculty, String admDepartment, String admPhone, String admUsername, String admPassword) {
    
        this.admId = admId;
        this.admName = admName;
        this.admSex = admSex;
        this.admAge = admAge;
        this.admFaculty = admFaculty;
        this.admDepartment = admDepartment;
        this.admPhone = admPhone;
        this.admUsername = admUsername;
        this.admPassword = admPassword;
    }

    public Integer getAdmId() {
        return admId;
    }

    public void setAdmId(Integer admId) {
        this.admId = admId;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName == null ? null : admName.trim();
    }

    public String getAdmSex() {
        return admSex;
    }

    public void setAdmSex(String admSex) {
        this.admSex = admSex == null ? null : admSex.trim();
    }

    public Integer getAdmAge() {
        return admAge;
    }

    public void setAdmAge(Integer admAge) {
        this.admAge = admAge;
    }

    public String getAdmFaculty() {
        return admFaculty;
    }

    public void setAdmFaculty(String admFaculty) {
        this.admFaculty = admFaculty == null ? null : admFaculty.trim();
    }

    public String getAdmDepartment() {
        return admDepartment;
    }

    public void setAdmDepartment(String admDepartment) {
        this.admDepartment = admDepartment == null ? null : admDepartment.trim();
    }

    public String getAdmPhone() {
        return admPhone;
    }

    public void setAdmPhone(String admPhone) {
        this.admPhone = admPhone == null ? null : admPhone.trim();
    }

    public String getAdmUsername() {
        return admUsername;
    }

    public void setAdmUsername(String admUsername) {
        this.admUsername = admUsername == null ? null : admUsername.trim();
    }

    public String getAdmPassword() {
        return admPassword;
    }

    public void setAdmPassword(String admPassword) {
        this.admPassword = admPassword == null ? null : admPassword.trim();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admId=" + admId +
                ", admName='" + admName + '\'' +
                ", admSex='" + admSex + '\'' +
                ", admAge=" + admAge +
                ", admFaculty='" + admFaculty + '\'' +
                ", admDepartment='" + admDepartment + '\'' +
                ", admPhone='" + admPhone + '\'' +
                ", admUsername='" + admUsername + '\'' +
                ", admPassword='" + admPassword + '\'' +
                '}';
    }
}

