package com.pan.bean;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-25 17:39
 **/
public class Experiment {
    private Integer exprId;
    private Integer sId;
    private Integer tId;
    private String question;
    private String answer;
    private Integer exprGrd;

    public Experiment() {
    }

    public Experiment(Integer exprId, Integer sId, Integer tId, String question, String answer, Integer exprGrd) {
    
        this.exprId = exprId;
        this.sId = sId;
        this.tId = tId;
        this.question = question;
        this.answer = answer;
        this.exprGrd = exprGrd;
    }

    public Integer getExprId() {
    
        return exprId;
    }

    public void setExprId(Integer exprId) {
        this.exprId = exprId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getExprGrd() {
        return exprGrd;
    }

    public void setExprGrd(Integer exprGrd) {
        this.exprGrd = exprGrd;
    }

    @Override
    public String toString() {
        return "Experiment{" +
                "exprId=" + exprId +
                ", sId=" + sId +
                ", tId=" + tId +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", exprGrd=" + exprGrd +
                '}';
    }
}
