package com.nudo.gg.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.nudo.gg.board.vo.BoardVO;

@Mapper
public interface BoardMapper {

	@Select("SELECT * FROM TB_BOARD WHERE BOARD_ID = #{boardId}")
    BoardVO findById(@Param("boardId") long boardId);
	
}
