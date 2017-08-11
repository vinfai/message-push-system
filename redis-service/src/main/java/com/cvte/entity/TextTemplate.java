package com.cvte.entity;

/**
 * 发送模板
 */
public class TextTemplate {

    private Integer id;
    private Integer paramNum;
    private String text;

    public TextTemplate() {
    }

    public TextTemplate(Integer paramNum, String text) {
        this.paramNum = paramNum;
        this.text = text;
    }

    public TextTemplate(Integer id, Integer paramNum, String text) {
        this.id = id;
        this.paramNum = paramNum;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParamNum() {
        return paramNum;
    }

    public void setParamNum(Integer paramNum) {
        this.paramNum = paramNum;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextTemplate{" +
                "id=" + id +
                ", paramNum=" + paramNum +
                ", text='" + text + '\'' +
                '}';
    }
}
