package com.pan.bean;

public class Grade {
    private Integer sId;

    private Integer java;

    private Integer c;

    private Integer cpp;

    public Grade() {
    }

    public Grade(Integer sId, Integer java, Integer c, Integer cpp) {
    
        this.sId = sId;
        this.java = java;
        this.c = c;
        this.cpp = cpp;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getJava() {
        return java;
    }

    public void setJava(Integer java) {
        this.java = java;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getCpp() {
        return cpp;
    }

    public void setCpp(Integer cpp) {
        this.cpp = cpp;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "sId=" + sId +
                ", java=" + java +
                ", c=" + c +
                ", cpp=" + cpp +
                '}';
    }
}