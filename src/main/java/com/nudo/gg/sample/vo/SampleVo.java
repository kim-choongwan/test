package com.nudo.gg.sample.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="샘플 VO", description="코멘트는 여기에 단다.")
public class SampleVo {

	
	private String id;
	
	@ApiModelProperty(value = "값 , 해당 컬럼의 comment는 여기에서 설정할 수 있다.")
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
