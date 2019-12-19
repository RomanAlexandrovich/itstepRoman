package org.rest.util;

public enum StatusError {
	CURRENCY_NOT_FOUND(99, "No such Currency is scope"),
	CURRENCY_NOT_UPDATE(101, "Refresh currency");
	private int code;
	private String msg;
	
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
	private StatusError(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
}
