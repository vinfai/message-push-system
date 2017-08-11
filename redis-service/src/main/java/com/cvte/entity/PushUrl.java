package com.cvte.entity;

public class PushUrl {


    private String type;
    private String url;


    public PushUrl() {
    }

    public PushUrl(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PushUrl{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
