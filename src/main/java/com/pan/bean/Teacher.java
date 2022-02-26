package com.pan.bean;

public class Teacher {
    private Integer tchId;

    private String tchName;

    private String tchSex;

    private Integer tchAge;

    private Integer tchClass;

    private String cName;

    private String tchPwd;

    public Teacher() {
    }

    public Teacher(Integer tchId, String tchName, String tchSex, Integer tchAge, Integer tchClass, String cName, String tchPwd) {
    
        this.tchId = tchId;
        this.tchName = tchName;
        this.tchSex = tchSex;
        this.tchAge = tchAge;
        this.tchClass = tchClass;
        this.cName = cName;
        this.tchPwd = tchPwd;
    }

    public Integer getTchId() {
        return tchId;
    }

    public void setTchId(Integer tchId) {
        this.tchId = tchId;
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName == null ? null : tchName.trim();
    }

    public String getTchSex() {
        return tchSex;
    }

    public void setTchSex(String tchSex) {
        this.tchSex = tchSex == null ? null : tchSex.trim();
    }

    public Integer getTchAge() {
        return tchAge;
    }

    public void setTchAge(Integer tchAge) {
        this.tchAge = tchAge;
    }

    public Integer getTchClass() {
        return tchClass;
    }

    public void setTchClass(Integer tchClass) {
        this.tchClass = tchClass;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getTchPwd() {
        return tchPwd;
    }

    public void setTchPwd(String tchPwd) {
        this.tchPwd = tchPwd == null ? null : tchPwd.trim();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tchId=" + tchId +
                ", tchName='" + tchName + '\'' +
                ", tchSex='" + tchSex + '\'' +
                ", tchAge=" + tchAge +
                ", tchClass=" + tchClass +
                ", cName='" + cName + '\'' +
                ", tchPwd='" + tchPwd + '\'' +
                '}';
    }
}