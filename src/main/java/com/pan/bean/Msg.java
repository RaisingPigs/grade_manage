package com.pan.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-16 15:51
 **/
public class Msg {
    /*状态码: 返回100 - 成功, 返回200 - 失败*/
    private int code;
    /*提示信息*/
    private String msg;
    /*用户要返回给浏览器的数据*/
    private Map<String, Object> extend = new HashMap<>();

    /*返回成功信息*/
    public static Msg success() {
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理成功!");
        return result;
    }

    /*返回失败信息*/
    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("处理失败!");
        return result;
    }

    /*用来增加一些附带信息 (返回Msg对象, 就可以链式操作, 连续添加)*/
    public Msg add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
