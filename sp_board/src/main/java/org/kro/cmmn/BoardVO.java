package org.kro.cmmn;

import java.sql.Date;

public class BoardVO {
	private int bno;
	private int viewcnt;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	
	public BoardVO(){}
	
	public BoardVO( int viewcnt, String title, String writer, String content) {
		
		this.viewcnt = viewcnt;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", viewcnt=" + viewcnt + ", title=" + title + ", writer=" + writer + ", content="
				+ content + ", regdate=" + regdate + "]";
	}
	

	
}
