package com.nudo.gg.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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

import com.nudo.gg.cmm.exception.BizException;
import com.nudo.gg.sample.vo.SampleVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleExceptionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ApiOperation(value="에러강제발생", notes="해당 에러 코드로 Exception을 발생시킨다.")
	@GetMapping("/exception/{errCode}")
	public Map<String, Object> getSample(
			
			@ApiParam(value = "발생시키고자하는ErrCode", required = true, name = "errCode")
			@PathVariable("errCode") String errCode
			, Locale locale) throws Exception {
		
		Map<String, Object> ret = new HashMap<String, Object>() ;
		ret.put("message", "클라이언트가 볼 수 없는 메시지");
		
		logger.info("ERROR CODE : {}",errCode );
		
		if("".equals("")) {
			throw new BizException(errCode,new String[] {"값1","값2"}) ;
		}
		
		return ret;
	}

}
