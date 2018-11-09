package com.nudo.gg.sample.controller;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nudo.gg.sample.model.Sample;
import com.nudo.gg.sample.model.SampleCondition;
import com.nudo.gg.sample.service.SampleService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private SampleService sampleService; 
	
	@ApiOperation(
			value="단건조회"                //요약설명
		  , notes="Sample을 단건조회한다.<br/>id는 필수."  //설명
	)
	@GetMapping("/sample/{id}")
	public Sample get(
			@ApiParam(
				  value = "조회하고자 하는 sample의 id"  //parameters.description
				, required = true                        //필수여부
				, name = "id"
				) @PathVariable("id") Long id
			) throws Exception {
		
		return sampleService.get(id);
		
	}
	
//	@ApiOperation(value="목록조회", notes="Sample을 목록조회한다.")
//	@GetMapping("/samples")
//	public List<Sample> getList(@RequestParam(value = "TYPE", required=false) String tYPE) {
//		SampleCondition condition =  new SampleCondition();
//		condition.setTYPE(tYPE);
//		return sampleService.search(condition);
//	}
	
	@ApiOperation(value="목록조회", notes="Sample을 목록조회한다.")
	@ApiImplicitParams({    
			 @ApiImplicitParam(name = "type"   , required = true,  value="타입", defaultValue="ZZ",paramType="query") 
			,@ApiImplicitParam(name = "garvege", required = false,  value="(미사용)",readOnly=true,paramType="query")
	})
	@GetMapping("/samples")
	public List<Sample> getList(@ModelAttribute SampleCondition condition) {
				
		return sampleService.search(condition);
		
	}
			
	@ApiOperation(
			  value="추가"
			, notes="Sample을 추가한다."
			)
	@PostMapping("/sample")
	public Sample insert(@RequestBody(required=true ) Sample sample) {

		return sampleService.insert(sample);
		
	}

	@ApiOperation(value="수정", notes="Sample을 수정한다.")
	@PutMapping("/sample")
	public void update(@RequestBody(required = true) Sample sample) {
		
		sampleService.update(sample);
		
	}

	@ApiOperation(value="삭제", notes="Sample을 삭제한다.")
	@DeleteMapping("/sample/{id}")
	public void delete(@ApiParam(value = "삭제하고자 하는 sample의 id", required = true, name = "id") @PathVariable("id") Long id) {

		sampleService.delete(id);
		
	}

	@ApiOperation(value="목록저장", notes="Sample을 목록저장한다.")
	@PostMapping("/samples")
	public void setList(@ModelAttribute SampleCondition condition, @RequestBody(required = true) List<Sample> samples) {
				
		sampleService.setList(samples);
		
	}

	
	//@ApiImplicitParams.@ApiImplicitParam.name : 변수명, 파라미터키
	//@ApiImplicitParams.@ApiImplicitParam.value : 변수에 대한 설명
	
	//@ApiImplicitParams.@ApiImplicitParam.defaultValue : 기본값 , 값을 설정하지 않으면 기본값이 세팅된다.
	//@ApiImplicitParams.@ApiImplicitParam.allowableValues : 허용값. 예) "A,B,C"  range[1, 5], range(1, 5), range[1, 5)
	//@ApiImplicitParams.@ApiImplicitParam.required : 필수여부
	//@ApiImplicitParams.@ApiImplicitParam.access : 필터링
	//@ApiImplicitParams.@ApiImplicitParam.allowMultiple : 파라미터의 반복설정을 허용여부
	//@ApiImplicitParams.@ApiImplicitParam.paramType=[query,body,header,form] : 파라미터타입
	//@ApiImplicitParams.@ApiImplicitParam.dataType : 데이터 타입. (메서드에 있으므로 생략)
	//@ApiImplicitParams.@ApiImplicitParam.example
	//@ApiImplicitParams.@ApiImplicitParam.examples
	//@ApiImplicitParams.@ApiImplicitParam.type
	//@ApiImplicitParams.@ApiImplicitParam.format
	//@ApiImplicitParams.@ApiImplicitParam.allowEmptyValue
	//@ApiImplicitParams.@ApiImplicitParam.readOnly
	//@ApiImplicitParams.@ApiImplicitParam.collectionFormat

	
}