package com.pan.bean;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-22 10:35
 **/
public class Homework {
    private Integer hwkId;
    private Integer sId;
    private Integer tId;
    private String question;
    private String answer;
    private Integer hwkGrd;

    public Homework() {
    }

    public Homework(Integer hwkId, Integer sId, Integer tId, String question, String answer, Integer hwkGrd) {
        this.hwkId = hwkId;
        this.sId = sId;
        this.tId = tId;
        this.question = question;
        this.answer = answer;
        this.hwkGrd = hwkGrd;
    }

    public Integer getHwkId() {
        return hwkId;
    }

    public void setHwkId(Integer hwkId) {
        this.hwkId = hwkId;
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

    public Integer getHwkGrd() {
        return hwkGrd;
    }

    public void setHwkGrd(Integer hwkGrd) {
        this.hwkGrd = hwkGrd;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "hwkId=" + hwkId +
                ", sId=" + sId +
                ", tId=" + tId +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", hwkGrd=" + hwkGrd +
                '}';
    }
}
