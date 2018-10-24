package com.nudo.gg.sample.vo;

public class SampleVo {

	
	private String id;
	private int value;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "SampleVo [id=" + id + ", value=" + value + "]";
	}
	
}
