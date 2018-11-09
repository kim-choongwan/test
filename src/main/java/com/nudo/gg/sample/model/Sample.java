package com.nudo.gg.sample.model;

import com.nudo.gg.cmm.model.Crudable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString 
@ApiModel(value="샘플 모델", description="기본적인 프로세스루틴을 설명하기 위하여 생성한 가상의 model")
public class Sample extends Crudable {
	
	@ApiModelProperty(name="식별자")
	private Long id;

	@ApiModelProperty(name="값" ,required=true,value="값")
	private Long val;

	@ApiModelProperty(name="구분" ,required=true,value="구분")
	private String type;
	
}
