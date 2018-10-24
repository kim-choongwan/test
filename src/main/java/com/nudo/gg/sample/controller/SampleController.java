package com.nudo.gg.sample.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nudo.gg.sample.vo.SampleVo;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/sample")
	String sample() {
		return "Hello~~~~";
	}

	@GetMapping("/sample/{id}")
	public SampleVo getApproval(@PathVariable("id") String id, Model model, HttpServletRequest request,
			Locale locale) throws Exception {
		
		SampleVo ret = new SampleVo();
		ret.setId(id);
		ret.setValue(2018);
		
		return ret;
	}
}
