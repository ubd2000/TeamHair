package kr.or.bit.dto;

import java.util.Date;

public class QnADto {
	int boardID;
	String boardName;
    String boardSubject;
	String boardContent;
	String fileName;
	int replyRef=0;
	int replyDepth=0;
	int replySeq=0;
	Date createDate;
	Date updateDate; 
	int readCount=0;
	String notice;
	String userID;
	
	public int getBoardID() {
		return boardID;
	}
	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getReplyRef() {
		return replyRef;
	}
	public void setReplyRef(int replyRef) {
		this.replyRef = replyRef;
	}
	public int getReplyDepth() {
		return replyDepth;
	}
	public void setReplyDepth(int replyDepth) {
		this.replyDepth = replyDepth;
	}
	public int getReplySeq() {
		return replySeq;
	}
	public void setReplySeq(int replySeq) {
		this.replySeq = replySeq;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "QnADto [boardID=" + boardID + ", boardName=" + boardName + ", boardSubject=" + boardSubject
				+ ", boardContent=" + boardContent + ", fileName=" + fileName + ", replyRef=" + replyRef
				+ ", replyDepth=" + replyDepth + ", replySeq=" + replySeq + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", readCount=" + readCount + ", notice=" + notice + ", userID="
				+ userID + "]";
	}
	
	
		
	
}
