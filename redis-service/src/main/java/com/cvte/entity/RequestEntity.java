package com.cvte.entity;

import java.io.Serializable;

/**
 * 封装用户请求的 实体
 */
public class RequestEntity implements Serializable {

    private Integer id;

    private String appid;
    private String sign;
    private String push;
    private Integer templateId;
    private String params;
    private String content;
    private Integer needreply;
    private Integer isTongbu;
    private String time;


    public RequestEntity() {
    }


    public RequestEntity(String appid, String sign, String push, Integer templateId, String params, String content, Integer needreply, Integer isTongbu) {
        this.appid = appid;
        this.sign = sign;
        this.push = push;
        this.templateId = templateId;
        this.params = params;
        this.content = content;
        this.needreply = needreply;
        this.isTongbu = isTongbu;
    }

    public RequestEntity(String appid, String sign, String push, Integer templateId, String params, String content, Integer needreply, Integer isTongbu, String time) {
        this.appid = appid;
        this.sign = sign;
        this.push = push;
        this.templateId = templateId;
        this.params = params;
        this.content = content;
        this.needreply = needreply;
        this.isTongbu = isTongbu;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPush() {
        return push;
    }

    public void setPush(String push) {
        this.push = push;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNeedreply() {
        return needreply;
    }

    public void setNeedreply(Integer needreply) {
        this.needreply = needreply;
    }

    public Integer getIsTongbu() {
        return isTongbu;
    }

    public void setIsTongbu(Integer isTongbu) {
        this.isTongbu = isTongbu;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "RequestEntity{" +
                "id=" + id +
                ", appid='" + appid + '\'' +
                ", sign='" + sign + '\'' +
                ", push='" + push + '\'' +
                ", templateId=" + templateId +
                ", params='" + params + '\'' +
                ", content='" + content + '\'' +
                ", needreply=" + needreply +
                ", isTongbu=" + isTongbu +
                ", time='" + time + '\'' +
                '}';
    }
}
