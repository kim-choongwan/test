package com.nudo.gg.board.vo;

public class BoardVO {

	private long BOARD_ID;
	private String CONTENT;

	public long getBOARD_ID() {
		return BOARD_ID;
	}
	public void setBOARD_ID(long bOARD_ID) {
		BOARD_ID = bOARD_ID;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	
	@Override
	public String toString() {
		return "BoardVO [BOARD_ID=" + BOARD_ID + ", CONTENT=" + CONTENT + "]";
	}
	
}
