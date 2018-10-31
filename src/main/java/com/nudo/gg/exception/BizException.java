package com.nudo.gg.exception;

public class BizException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	protected String errCode;
	protected String[] texts;
	
	public BizException(String errCode) {
		this.errCode = errCode;
	}

	public BizException(String errCode, String text) {
		this.errCode = errCode;
		this.texts   = new String[]{text};
	}

	public BizException(String errCode, String[] texts) {
		this.errCode = errCode;
		this.texts   = texts;
	}

	public BizException(String errCode, Throwable cause) {
		super(cause);
		this.errCode = errCode;
	}
	
	public BizException(String errCode, String[] texts, Throwable cause) {
		super(cause);
		this.errCode = errCode;
		this.texts   = texts;
	}

	public String getErrCode() {
		return errCode;
	}
	
	public String[] getTexts() {
		return texts;
	}
	
}
