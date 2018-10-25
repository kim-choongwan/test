package com.nudo.gg.sample.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nudo.gg.sample.vo.SampleVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

//	@RequestMapping("/sample")
//	String sample() {
//		return "Hello~~~~";
//	}

	
	@ApiOperation(value="단건조회", notes="Sample을 단건조회한다.")
	@GetMapping("/sample/{id}")
	public SampleVo getSample(
			
			@ApiParam(value = "조회하고자 하는 sample의 id", required = true, name = "id")
			@PathVariable("id") String id
			, Model model
			, HttpServletRequest request
			, Locale locale) throws Exception {
		
		SampleVo ret = new SampleVo();
		ret.setId(id);
		ret.setValue(2018);
		
		return ret;
	}
	@ApiImplicitParam
	@ApiModelProperty
	@ApiOperation(value="목록조회", notes="Sample을 목록조회한다.")
	@GetMapping("/sample/list/{page}")
	public List<SampleVo> getSampleList(
			
			@ApiParam(value = "페이지 번호", required = true, name = "page")
			@PathVariable("page") String page
			, Model model
			, HttpServletRequest request
			, Locale locale) throws Exception {
		
		List<SampleVo> list = new ArrayList<SampleVo>();
		
		SampleVo vo1 = new SampleVo();
		SampleVo vo2 = new SampleVo();
		SampleVo vo3 = new SampleVo();
		SampleVo vo4 = new SampleVo();
		
		vo1.setId("a"); vo1.setValue(2018);
		vo2.setId("b"); vo2.setValue(2019);
		vo3.setId("c"); vo3.setValue(2020);
		vo4.setId("d"); vo4.setValue(2021);
		
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		
		return list;
	}
	
	@ApiOperation(value="신규생성", notes="Sample을 신규 생성한다.")
	@PostMapping("/sample")
	public SampleVo createSample(
			
			@RequestBody(required = true) SampleVo vo
			, Model model
			, HttpServletRequest request
			, Locale locale) throws Exception {
		

		System.out.println("#### locale : "+locale);
		int id = new Random().nextInt(100);
		vo.setId( String.valueOf(id) );
		
		return vo;
	}
	
	@ApiOperation(value="수정", notes="Sample을 수정한다.")
	@PutMapping("/sample")
	public SampleVo modifySample(
			
			@RequestBody(required = true) SampleVo vo
			, Model model
			, HttpServletRequest request
			, Locale locale) throws Exception {
		
		return vo;
	}
	
	@ApiOperation(value="삭제", notes="Sample을 삭제한다.")
	@DeleteMapping("/sample")
	public int deleteSample(
			
			@PathVariable("id") String id
			, Model model
			, HttpServletRequest request
			, Locale locale) throws Exception {
		
		return 1;
	}

}
