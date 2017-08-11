package com.cvte.entity;


import java.io.Serializable;

public class PushEntity implements Serializable {

	private Integer id;
	private String appid;
	private String requestCode;
	private String pushAddress;

	private String sign;
	private Integer templateId;
	private String params;
	private String content;
	private Integer status;
	private Integer result;
	private String time;

	private Integer needreply;

	public PushEntity() {
	}

	public PushEntity(String appid, String requestCode, String pushAddress, String sign, Integer templateId, String params, String content, Integer status, Integer result, String time) {
		this.appid = appid;
		this.requestCode = requestCode;
		this.pushAddress = pushAddress;
		this.sign = sign;
		this.templateId = templateId;
		this.params = params;
		this.content = content;
		this.status = status;
		this.result = result;
		this.time = time;
	}

	public PushEntity(Integer id, String appid, String requestCode, String pushAddress, String sign, Integer templateId, String params, String content, Integer status, Integer result) {
		this.id = id;
		this.appid = appid;
		this.requestCode = requestCode;
		this.pushAddress = pushAddress;
		this.sign = sign;
		this.templateId = templateId;
		this.params = params;
		this.content = content;
		this.status = status;
		this.result = result;
	}


	public PushEntity(Integer id, String appid, String requestCode, String pushAddress, String sign, Integer templateId, String params, String content, Integer status, Integer result, String time) {
		this.id = id;
		this.appid = appid;
		this.requestCode = requestCode;
		this.pushAddress = pushAddress;
		this.sign = sign;
		this.templateId = templateId;
		this.params = params;
		this.content = content;
		this.status = status;
		this.result = result;
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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getNeedreply() {
		return needreply;
	}

	public void setNeedreply(Integer needreply) {
		this.needreply = needreply;
	}

	@Override
	public String toString() {
		return "PushEntity{" +
				"id=" + id +
				", appid='" + appid + '\'' +
				", requestCode='" + requestCode + '\'' +
				", pushAddress='" + pushAddress + '\'' +
				", sign='" + sign + '\'' +
				", templateId=" + templateId +
				", params='" + params + '\'' +
				", content='" + content + '\'' +
				", status=" + status +
				", result=" + result +
				", time='" + time + '\'' +
				", needreply=" + needreply +
				'}';
	}
}
