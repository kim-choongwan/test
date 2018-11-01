package com.nudo.gg.config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataSourceConfigTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Value("${spring.datasource.url}")
	String url ;

	@Value("${spring.datasource.username}")
	String username ;
	
	@Value("${spring.datasource.password}")
	String password ;
	
	@Value("${spring.datasource.driver-class-name}")
	String driver ;
	
	@Test
	public void _01_jdbcConnection확인() throws Exception {
		
		Class.forName(driver);
		
		// mysql 5.1 이상버전에서 타임존을 인식하지 못하는 이슈가 있다고 한다.
		// 요청시 파라미터를 설정( serverTimezone=UTC )하여 접속
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt = conn.createStatement();
        ResultSet rs;
        
        rs = stmt.executeQuery("SELECT NOW() CURR");
        while ( rs.next() ) {
        	String now = rs.getString("CURR");
        	logger.info("## 01 NOW() : {}",now);
        	assertFalse(StringUtils.isEmpty(now));
        }

        conn.close();
	}

	@Test
	public void _02_데이터소스존재를확인() {
		
		// mysql 드라이브만으로 데이터 소스를 생성할 수 없음.
		// dbcp류의 라이브러리가 필요하다. (spring-boot-jdbc에 포함되어 있다.)
		assertTrue(dataSource != null);
		
	}

	@Test
	public void _03_DB접속확인() throws SQLException {
		
		logger.debug("## 03 dataSource {}",dataSource);
		Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs;
        
        rs = stmt.executeQuery("SELECT NOW() CURR");
        while ( rs.next() ) {
        	String now = rs.getString("CURR");
        	logger.info("## 03 NOW() : {}",now);
        	assertFalse(StringUtils.isEmpty(now));
        }

        conn.close();
		
	}

	@Test
	public void _04_jdbcTemplate확인() throws Exception {
		
		assertTrue(jdbcTemplate != null);
		
		String query = "SELECT date_format(NOW(),'%y-%m-%d %h:%i:%s') N";
		String now = jdbcTemplate.queryForObject(query, String.class);
    	logger.info("## 04 NOW() : {}",now);
    	
	}
	
}
