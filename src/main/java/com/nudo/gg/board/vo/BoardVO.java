package com.nudo.gg.board.vo;

public class BoardVO {

	private long boardId;
	private String content;
	
	public long getBoardId() {
		return boardId;
	}
	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", content=" + content + "]";
	}
	
}
