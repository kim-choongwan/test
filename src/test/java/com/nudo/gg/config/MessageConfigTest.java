package com.nudo.gg.config;

import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MessageConfigTest {

	@Autowired
	MessageSource messageSource;
	
	@Test
	public void _01_메시지소스존재를확인() {
		assertTrue(messageSource != null);
	}

	@Test
	public void _02_테스트메시지확인() {
		
		String n = messageSource.getMessage("test.message", null,null);
		String kr = messageSource.getMessage("test.message", null,Locale.KOREA);
		String us = messageSource.getMessage("test.message", null,Locale.US);
		
		System.out.println(n);
		System.out.println(kr);
		System.out.println(us);

		assertTrue(kr.equals("한글"));
		assertTrue(us.equals("English"));
		
	}

	
}
