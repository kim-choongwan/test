package com.nudo.gg.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.nudo.gg.config.vo.ErrorMessage;
import com.nudo.gg.exception.BizException;

@ControllerAdvice 
@Configuration
public class ExceptionAdvice {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MessageSource messageSource;
	
    @ExceptionHandler(value = { BizException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //500 ERROR
    @ResponseBody
    protected ErrorMessage handleConflict(BizException ex, WebRequest request) {
    	
    	if(logger.isDebugEnabled()) {
    		ex.printStackTrace(); //아직 로그 설정이 제대로 안되어 있으므로.
    	}
    	
    	ErrorMessage em = new ErrorMessage();
    	
    	String errCode = ex.getErrCode(); 
    	String message = messageSource.getMessage(errCode, ex.getTexts(), request.getLocale());
    	
    	em.setErrCode(errCode);
    	em.setMessage(message);
    	
    	return em;
    }

	
}
