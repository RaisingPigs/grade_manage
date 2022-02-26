package com.pan.bean;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-21 15:23
 **/
public class GradePercent {
    private Integer tId;

    private Integer usualGrd;
    private Integer examGrd;
    private Integer exprGrd;

    public GradePercent() {
    }

    public GradePercent(Integer tId, Integer usualGrd, Integer examGrd, Integer exprGrd) {
    
        this.tId = tId;
        this.usualGrd = usualGrd;
        this.examGrd = examGrd;
        this.exprGrd = exprGrd;
    }

    public Integer gettId() {
    
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getUsualGrd() {
        return usualGrd;
    }

    public void setUsualGrd(Integer usualGrd) {
        this.usualGrd = usualGrd;
    }

    public Integer getExamGrd() {
        return examGrd;
    }

    public void setExamGrd(Integer examGrd) {
        this.examGrd = examGrd;
    }

    public Integer getExprGrd() {
        return exprGrd;
    }

    public void setExprGrd(Integer exprGrd) {
        this.exprGrd = exprGrd;
    }

    @Override
    public String toString() {
        return "GradePercent{" +
                "tId=" + tId +
                ", usualGrd=" + usualGrd +
                ", examGrd=" + examGrd +
                ", exprGrd=" + exprGrd +
                '}';
    }
}
