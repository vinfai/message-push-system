package com.cvte.entity;

/**
 * 用户回复的是实体
 */
public class Reply {

    private Integer id;
    private String appid;
    private String requestCode;
    private String pushAddress;
    private String text;
    private Integer type;//0=
    private String time;

    public Reply() {
    }

    public Reply(Integer id, String appid, String requestCode, String pushAddress, String text, Integer type, String time) {
        this.id = id;
        this.appid = appid;
        this.requestCode = requestCode;
        this.pushAddress = pushAddress;
        this.text = text;
        this.type = type;
        this.time = time;
    }

    public Reply(String appid, String requestCode, String pushAddress, String text, Integer type, String time) {
        this.appid = appid;
        this.requestCode = requestCode;
        this.pushAddress = pushAddress;
        this.text = text;
        this.type = type;
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

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getPushAddress() {
        return pushAddress;
    }

    public void setPushAddress(String pushAddress) {
        this.pushAddress = pushAddress;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", appid='" + appid + '\'' +
                ", requestCode='" + requestCode + '\'' +
                ", pushAddress='" + pushAddress + '\'' +
                ", text='" + text + '\'' +
                ", type=" + type +
                ", time='" + time + '\'' +
                '}';
    }
}
