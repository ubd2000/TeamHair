package kr.or.bit.dto;

import java.util.Date;

public class QnACommentsDto {
	int commentID;
	String comments;
	Date createDate;
	Date updateDate;
	int boardID;
	String userID;
	
	public int getCommentID() {
		return commentID; 
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
	public int getBoardID() {
		return boardID;
	}
	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "QnACommentsDto [commentID=" + commentID + ", comments=" + comments + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", boardID=" + boardID + ", userID=" + userID + "]";
	}
	
	
}
