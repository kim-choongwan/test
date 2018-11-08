package com.nudo.gg.sample.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="샘플 VO", description="코멘트는 여기에 단다.")
public class Sample {
	
	private int ID;
	private int VAL;
	private String TYPE;


	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getVAL() {
		return VAL;
	}
	public void setVAL(int vAL) {
		VAL = vAL;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	
	@Override
	public String toString() {
		return "Sample [ID=" + ID + ", VAL=" + VAL + ", TYPE=" + TYPE + "]";
	}
	
}
