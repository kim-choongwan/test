package com.nudo.gg.config;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoggingTest {

	  private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	  @Test
	  public void test() {
		  
		  logger.debug("테스트로깅");
		  logger.error("테스트로깅");
		  logger.info ("테스트로깅");
		  logger.trace("테스트로깅");
		  logger.warn ("테스트로깅");
		  
		  assertTrue(logger.isDebugEnabled());
		  
	  }
	  
}
