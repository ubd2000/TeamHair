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
			String sql = "insert into qna(boardid, boardname, boardsubject, boardcontent, filename, replyref, replydepth, replyseq, createdate, updatedate, readcount, notice, userid) values(BOARD_ID_SEQ.NEXTVAL,'category',?,?,null,0,0,0,SYSDATE,SYSDATE,0,null,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna.getBoardSubject());
			pstmt.setString(2, qna.getBoardContent());
			pstmt.setString(3, qna.getUserID());
			row = pstmt.executeUpdate();

			System.out.println("DAO 안에서의 값 확인");
			System.out.println("subject : "+qna.getBoardSubject());
			System.out.println("content : "+qna.getBoardContent());
			System.out.println("userid : "+qna.getUserID());
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
			String sql = "select boardID, boardName, boardSubject, createDate, readCount, userID from qna order by boardID DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			System.out.println("sql rs 끝");
			
			while (rs.next()) {
				System.out.println("while문 들어옴");
				QnADto q = new QnADto();
				q.setBoardID(rs.getInt("BoardID"));
				q.setBoardName(rs.getString("BoardName"));
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
			String sql = "select BoardID, BoardName, BoardSubject, BoardContent, CreateDate, UpdateDate, UserID from qna where BoardID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,BoardID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
	            do {
	            	qna.setBoardID(rs.getInt("BoardID"));
	            	qna.setBoardName(rs.getString("boardName"));
	            	qna.setBoardSubject(rs.getString("boardSubject"));
	            	qna.setBoardContent(rs.getString("boardContent"));
	            	qna.setUserID(rs.getString("userID"));
	            	qna.setCreateDate(rs.getDate("createDate"));
	            	qna.setUpdateDate(rs.getDate("updateDate"));
	            } while (rs.next());
	            
	            System.out.println(qna);
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
			String sql = "update qna set boardName=?, boardsubject=?, boardcontent=?, filename=? where boardID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna.getBoardName());
			pstmt.setString(2, qna.getBoardSubject());
			pstmt.setString(3, qna.getBoardContent());
			pstmt.setString(4, qna.getFileName());
			pstmt.setInt(5, qna.getBoardID());
			row = pstmt.executeUpdate();

			System.out.println("DAO 안에서의 값 확인");
			System.out.println("boardname : " + qna.getBoardName());
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
	
}
