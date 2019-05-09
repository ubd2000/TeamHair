package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.QnACommentsDto;
import kr.or.bit.dto.QnADto;

public class QnADao {
	DataSource ds = null;
	
	public QnADao() throws NamingException{
		Context context = new InitialContext(); //이름기반 검색
		 ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); ///jdbc/oracle pool 검색
	}
	
	//글추가
	public int insertQnA(QnADto qna) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "insert into qna(boardid, boardsubject, boardcontent, filename, replyref, replydepth, replyseq, createdate, updatedate, readcount, notice, userid)"
								+ "values(BOARD_ID_SEQ.NEXTVAL,?,?,?,0,0,0,SYSDATE,SYSDATE,0,null,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna.getBoardSubject());
			pstmt.setString(2, qna.getBoardContent());
			pstmt.setString(3, qna.getFileName());
			pstmt.setString(4, qna.getUserID());
			row = pstmt.executeUpdate();

			System.out.println("DAO 안에서의 값 확인");
			System.out.println("subject : "+qna.getBoardSubject());
			System.out.println("content : "+qna.getBoardContent());
			System.out.println("userid : "+qna.getUserID());
			System.out.println("filename : " + qna.getFileName());
			System.out.println("DAO try문 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			 if(pstmt != null)try{pstmt.close();}catch (Exception e){e.printStackTrace();}
			 if(conn != null) try{conn.close();}catch (Exception e){e.printStackTrace();}  //반환
		}

		return row;
	}
	
	//전체리스트보기
	public List<QnADto> QnAlist() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<QnADto> qnalist = new ArrayList<QnADto>();
		
		try {
			conn = ds.getConnection();
			String sql = "select boardID, readcount, boardSubject, createDate, readCount, userID from qna order by boardID DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			System.out.println("sql rs 끝");
			
			while (rs.next()) {
				System.out.println("while문 들어옴");
				QnADto q = new QnADto();
				q.setReadCount(rs.getInt("readcount"));
				q.setBoardID(rs.getInt("BoardID"));
				q.setBoardSubject(rs.getString("BoardSubject"));
				q.setCreateDate(rs.getDate("CreateDate"));
				q.setUserID(rs.getString("UserID"));
				qnalist.add(q);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			 if(pstmt != null)try{pstmt.close();}catch (Exception e){e.printStackTrace();}
			 if(conn != null) try{conn.close();}catch (Exception e){e.printStackTrace();}  //반환
		}

		return qnalist;
	}

	//글 상세보기
	public QnADto searchQnA(int BoardID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		QnADto qna = new QnADto();
		
		try {
			conn = ds.getConnection();
			String sql = "select BoardID, ReadCount, BoardSubject, BoardContent, CreateDate, UpdateDate, UserID, FileName from qna where BoardID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,BoardID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
	            do {
	            	qna.setBoardID(rs.getInt("BoardID"));
	            	qna.setReadCount(rs.getInt("ReadCount"));
	            	System.out.println("DAO READCOUNT값 확인 : " + qna.getReadCount());
	            	qna.setBoardSubject(rs.getString("boardSubject"));
	            	qna.setBoardContent(rs.getString("boardContent"));
	            	qna.setUserID(rs.getString("userID"));
	            	qna.setCreateDate(rs.getDate("createDate"));
	            	qna.setUpdateDate(rs.getDate("updateDate"));
	            	qna.setFileName(rs.getString("fileName"));
	            } while (rs.next());
	        } else {
	            System.out.println("데이터가 없습니다.");
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			 if(pstmt != null)try{pstmt.close();}catch (Exception e){e.printStackTrace();}
			 if(conn != null) try{conn.close();}catch (Exception e){e.printStackTrace();}  //반환
		}

		return qna;
	}
	
	//글 삭제하기
	public int deleteQnA(int boardid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "DELETE FROM qna WHERE boardid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardid);
			row = pstmt.executeUpdate();

			System.out.println("delete 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			 if(pstmt != null)try{pstmt.close();}catch (Exception e){e.printStackTrace();}
			 if(conn != null) try{conn.close();}catch (Exception e){e.printStackTrace();}  //반환
		}

		return row;
	}
	
	//글 수정하기
	public int updateQnA(QnADto qna) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "update qna set boardsubject=?, boardcontent=?, filename=?, readcount=? where boardID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna.getBoardSubject());
			pstmt.setString(2, qna.getBoardContent());
			pstmt.setString(3, qna.getFileName());
			pstmt.setInt(4, qna.getReadCount());
			pstmt.setInt(5, qna.getBoardID());
			
			row = pstmt.executeUpdate();

			System.out.println("DAO 안에서의 값 확인");
			System.out.println("subject : "+qna.getBoardSubject());
			System.out.println("content : "+qna.getBoardContent());
			System.out.println("filename : " + qna.getFileName());
			System.out.println("boardid : "+qna.getBoardID());
			System.out.println("DAO try문 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			 if(pstmt != null)try{pstmt.close();}catch (Exception e){e.printStackTrace();}
			 if(conn != null) try{conn.close();}catch (Exception e){e.printStackTrace();}  //반환
		}

		return row;
	}
	
	
	//댓글리스트보기
	public List<QnACommentsDto> QnACommentslist(int boardid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<QnACommentsDto> qnacommentslist = new ArrayList<QnACommentsDto>();
		
		try {
				conn = ds.getConnection();
				String sql = "select CommentID, Comments, CreateDate, updateDate, BoardID, userID from QnAComments where BoardID=? order by BoardID";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardid);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					QnACommentsDto q = new QnACommentsDto();
					q.setCommentID(rs.getInt("CommentID"));
					q.setComments(rs.getString("Comments"));
					q.setCreateDate(rs.getDate("CreateDate"));
					q.setUpdateDate(rs.getDate("UpdateDate"));
					q.setUserID(rs.getString("userID"));
					qnacommentslist.add(q);
				}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			 if(pstmt != null)try{pstmt.close();}catch (Exception e){e.printStackTrace();}
			 if(conn != null) try{conn.close();}catch (Exception e){e.printStackTrace();}
		}

		return qnacommentslist;
	}
	
	//댓글 삭제하기
	public int deleteQnAComments(int boardid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "DELETE FROM QnAComments WHERE boardid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardid);
			row = pstmt.executeUpdate();

			System.out.println("delete comments 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			 if(pstmt != null)try{pstmt.close();}catch (Exception e){e.printStackTrace();}
			 if(conn != null) try{conn.close();}catch (Exception e){e.printStackTrace();}  //반환
		}

		return row;
	}

	//댓글 추가
	public int insertQnAComments(QnACommentsDto com) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "insert into qnacomments(CommentID, Comments, CreateDate, UpdateDate, BoardID, UserID) values(COMMENT_SEQ.NEXTVAL,?,SYSDATE,SYSDATE,?,'session.userid값받아오기')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, com.getComments());
			pstmt.setInt(2, com.getBoardID());
			//pstmt.setString(3, com.getUserID());
			row = pstmt.executeUpdate();

			System.out.println("DAO 안에서의 값 확인");
			System.out.println("comments : " + com.getComments());
			System.out.println("boardid : " + com.getBoardID());
			System.out.println("userid : " + com.getUserID());
			System.out.println("DAO try문 종료");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			 if(pstmt != null)try{pstmt.close();}catch (Exception e){e.printStackTrace();}
			 if(conn != null) try{conn.close();}catch (Exception e){e.printStackTrace();}  //반환
		}

		return row;
	}
}
