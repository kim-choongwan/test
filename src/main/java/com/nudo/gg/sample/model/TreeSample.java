package com.nudo.gg.sample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nudo.gg.cmm.model.Crudable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "트리 샘플 모델", description = "기본적인 트리 프로세스루틴을 설명하기 위하여 생성한 가상의 model")
public class TreeSample extends Crudable {

	@ApiModelProperty(name = "순번", value = "순번" , position=1)
	private Long seq;

	@ApiModelProperty(name = "상위순번", value = "상위순번" , position=2)
	private Long upperSeq;

	@ApiModelProperty(name = "명", value = "명" , position=3)
	private String name;

	@ApiModelProperty(name = "타입", value = "타입" , position=4)
	private String treeTyp;

	@ApiModelProperty(name = "말단여부", value = "말단여부" , position=5)
	private String leafYn;

	@ApiModelProperty(name = "순번", value = "순번" , position=6)
	private Long ord;

	@ApiModelProperty(name = "레벨", value = "레벨" , position=7)
	private Integer lvl;
	
	@JsonIgnore
	@ApiModelProperty(hidden=true)
	private String regId;

	@JsonIgnore
	@ApiModelProperty(hidden=true)
	private String regDtm;
	
	@JsonIgnore
	@ApiModelProperty(hidden=true)
	private String updId;
	
	@JsonIgnore
	@ApiModelProperty(hidden=true)
	private String updDtm;
	
}
