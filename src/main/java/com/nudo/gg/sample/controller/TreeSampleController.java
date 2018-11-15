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
import org.springframework.web.bind.annotation.RestController;

import com.nudo.gg.sample.model.TreeSample;
import com.nudo.gg.sample.model.TreeSampleCondition;
import com.nudo.gg.sample.service.TreeSampleService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class TreeSampleController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private TreeSampleService treeSampleService; 
	
	@ApiOperation(
			value="단건조회"                
		  , notes="Tree Sample을 단건조회한다.<br/>id는 필수."  
	)
	@GetMapping("/tree-sample/{seq}")
	public TreeSample get(
			@ApiParam(
				  value = "조회하고자 하는 tree sample의 seq"  //parameters.description
				, required = true                        //필수여부
				, name = "seq"
				) @PathVariable("seq") Long seq
			) throws Exception {
		TreeSample treeSample = new TreeSample();
		return treeSampleService.get(treeSample );
		
	}


	@ApiOperation(value="목록조회", notes="Tree Sample을 목록조회한다.")
	@GetMapping("/tree-samples/")
	public List<TreeSample> search(@ModelAttribute TreeSampleCondition condition) {
				
		return treeSampleService.search(condition);
		
	}
	
	
	@ApiOperation(value="하위목록조회", notes="해당 노드와 그 하위를 목록조회한다.")
	@GetMapping("/tree-samples/{seq}")
	public List<TreeSample> searchNodes(@ApiParam(
			  value = "조회하고자 하는 tree sample의 seq"  //parameters.description
			, required = true                        //필수여부
			, name = "seq"
			) @PathVariable("seq") Long seq) {
				
		return treeSampleService.searchNodes(seq);
		
	}
	
	
	@ApiOperation(
			  value="추가"
			, notes="Sample을 추가한다."
			)
	@PostMapping("/tree-sample")
	public TreeSample insert(@RequestBody(required=true ) TreeSample treeSample) {

		return treeSampleService.insert(treeSample);
		
	}

	@ApiOperation(value="수정", notes="Tree Sample을 수정한다.")
	@PutMapping("/tree-sample")
	public void update(@RequestBody(required = true) TreeSample treeSample) {
		
		treeSampleService.update(treeSample);
		
	}

	@ApiOperation(value="삭제", notes="Tree Sample을 삭제한다.")
	@DeleteMapping("/tree-sample/{seq}")
	public void delete(@ApiParam(value = "삭제하고자 하는 sample의 seq", required = true, name = "seq") @PathVariable("seq") Long seq) {
		
		TreeSample treeSample = new TreeSample();
		treeSampleService.delete(treeSample);
		
	}

	@ApiOperation(value="목록저장", notes="Tree Sample을 목록저장한다.")
	@PostMapping("/tree-samples")
	public void setList(@RequestBody(required = true) List<TreeSample> treeSamples) {
				
		treeSampleService.setList(treeSamples);
		
	}



	
}