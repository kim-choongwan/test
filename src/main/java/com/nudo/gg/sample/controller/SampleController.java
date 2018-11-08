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
	
	@ApiOperation(value="단건조회", notes="Sample을 단건조회한다.")
	@GetMapping("/sample/{id}")
	public Sample get(
			@ApiParam(value = "조회하고자 하는 sample의 id", required = true, name = "id") @PathVariable("id") int id
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
	@GetMapping("/samples")
	public List<Sample> getList(@ModelAttribute SampleCondition condition) {
				
		return sampleService.search(condition);
		
	}
			
	@ApiOperation(value="추가", notes="Sample을 추가한다.")
	@PostMapping("/sample")
	public Sample insert(@RequestBody(required = true) Sample sample) {

		return sampleService.insert(sample);
		
	}

	@ApiOperation(value="수정", notes="Sample을 수정한다.")
	@PutMapping("/sample")
	public void update(@RequestBody(required = true) Sample sample) {
		
		sampleService.update(sample);
		
	}

	@ApiOperation(value="삭제", notes="Sample을 삭제한다.")
	@DeleteMapping("/sample/{id}")
	public void delete(@ApiParam(value = "삭제하고자 하는 sample의 id", required = true, name = "id") @PathVariable("id") int id) {

		sampleService.delete(id);
		
	}
	
}