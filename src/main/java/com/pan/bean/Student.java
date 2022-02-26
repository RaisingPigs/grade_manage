package com.pan.bean;

import java.util.List;

public class Student {
    private Integer stuId;

    private String stuName;

    private String stuSex;

    private Integer stuAge;

    private String stuMajor;

    private Integer stuClass;

    private String stuPwd;

    private List<Grade> grades;

    public Student() {
    }

    public Student(Integer stuId, String stuName, String stuSex, Integer stuAge, String stuMajor, Integer stuClass, String stuPwd, List<Grade> grades) {
    
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
        this.stuMajor = stuMajor;
        this.stuClass = stuClass;
        this.stuPwd = stuPwd;
        this.grades = grades;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex == null ? null : stuSex.trim();
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor == null ? null : stuMajor.trim();
    }

    public Integer getStuClass() {
        return stuClass;
    }

    public void setStuClass(Integer stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd == null ? null : stuPwd.trim();
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuAge=" + stuAge +
                ", stuMajor='" + stuMajor + '\'' +
                ", stuClass=" + stuClass +
                ", stuPwd='" + stuPwd + '\'' +
                ", grades=" + grades +
                '}';
    }
}