package com.nudo.gg.cmm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

public abstract class Crudable {

	private final static char INSERT = 'C';
	private final static char SELECT = 'R'; 
	private final static char UPDATE = 'U';
	private final static char DELETE = 'D';
	
	//final static String NORMAL = "N";

	@ApiModelProperty(position=0, allowableValues="C,R,U,D", value="CRUD를 구분할 수 있는 구분자")
	private char crud = SELECT;

	public void setCrud(char crud) {
		this.crud = crud;
	}

	@ApiModelProperty(position=0) 
	public char getCrud() {
		return this.crud; 
	}

	@JsonIgnore
	public boolean isToInsert() {
		if( INSERT == this.crud)
			return true;
		return false;
	}

	@JsonIgnore
	public boolean isToSelect() {
		if( SELECT == this.crud)
			return true;
		return false;
	}

	@JsonIgnore
	public boolean isToUpdate() {
		if( UPDATE == this.crud)
			return true;
		return false;
	}
	
	@JsonIgnore
	public boolean isToDelete() {
		if( DELETE == this.crud)
			return true;
		return false;
	}
	
}
