package com.nudo.gg.sample.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString 
@ApiModel(value="샘플 VO", description="코멘트는 여기에 단다.")
public class Sample {
	
	private int ID;
	private int VAL;
	private String TYPE;
	
}
