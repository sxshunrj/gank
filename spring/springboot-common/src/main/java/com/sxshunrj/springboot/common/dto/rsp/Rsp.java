package com.sxshunrj.springboot.common.dto.rsp;

import java.io.Serializable;

public class Rsp implements Serializable{

	private boolean status;
	private int code;
	private String msg;
	private Object data;
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}