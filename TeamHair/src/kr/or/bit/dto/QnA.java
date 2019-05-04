package kr.or.bit.dto;

import java.util.Date;

public class QnA {
	int board_num;              //글번호
	String board_name;   		//작성자
	String board_title;  		//글제목
	String board_content; 		//글내용
	String board_file; 			//글의 첨부될 파일 이름
	int board_re_ref;	     	//참조글(글의 묶음)
	int board_re_lev;	    	//글의 깊이 (들여쓰기)(depth)
	int board_re_seq;		  	//글의 순서 (step)
	int board_readcount;		//글의 조회수
	Date board_date;          	//글쓴 날짜
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_file() {
		return board_file;
	}
	public void setBoard_file(String board_file) {
		this.board_file = board_file;
	}
	public int getBoard_re_ref() {
		return board_re_ref;
	}
	public void setBoard_re_ref(int board_re_ref) {
		this.board_re_ref = board_re_ref;
	}
	public int getBoard_re_lev() {
		return board_re_lev;
	}
	public void setBoard_re_lev(int board_re_lev) {
		this.board_re_lev = board_re_lev;
	}
	public int getBoard_re_seq() {
		return board_re_seq;
	}
	public void setBoard_re_seq(int board_re_seq) {
		this.board_re_seq = board_re_seq;
	}
	public int getBoard_readcount() {
		return board_readcount;
	}
	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	@Override
	public String toString() {
		return "QnA [board_num=" + board_num + ", board_name=" + board_name + ", board_title=" + board_title
				+ ", board_content=" + board_content + ", board_file=" + board_file + ", board_re_ref=" + board_re_ref
				+ ", board_re_lev=" + board_re_lev + ", board_re_seq=" + board_re_seq + ", board_readcount="
				+ board_readcount + ", board_date=" + board_date + "]";
	}
	
	
}
