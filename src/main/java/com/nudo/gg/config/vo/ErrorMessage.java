package com.nudo.gg.config.vo;

public class ErrorMessage {

	private String errCode;
	private String message;
	
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ErrorMessage [errCode=" + errCode + ", message=" + message + "]";
	}
	
}
