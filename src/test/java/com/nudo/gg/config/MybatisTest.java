package com.nudo.gg.config;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nudo.gg.board.dao.BoardMapper;
import com.nudo.gg.board.vo.BoardVO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MybatisTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void _01_Mapper() throws Exception {
		BoardVO board = boardMapper.findById(1);
		System.out.println(board);
	}
	
}
