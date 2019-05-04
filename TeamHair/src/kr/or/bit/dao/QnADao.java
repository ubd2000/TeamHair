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

import kr.or.bit.dto.QnA;

public class QnADao {
	DataSource ds = null;
	
	public QnADao() throws NamingException{
		Context context = new InitialContext(); //이름기반 검색
		 ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); ///jdbc/oracle pool 검색
	}
	
	public int insertQnA(QnA qna) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "insert into qna(board_name, board_title, board_content) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna.getBoard_name());
			pstmt.setString(2, qna.getBoard_title());
			pstmt.setString(3, qna.getBoard_content());
			row = pstmt.executeUpdate();

			System.out.println("DAO 안에서의 값 확인");
			System.out.println("name : "+qna.getBoard_name());
			System.out.println("title : "+qna.getBoard_title());
			System.out.println("content : "+qna.getBoard_content());
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
	
	public List<QnA> QnAlist() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<QnA> qnalist = new ArrayList<QnA>();
		
		try {
			conn = ds.getConnection();
			String sql = "select board_name, board_title, board_content from qna";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				QnA q = new QnA();
				q.setBoard_name(rs.getString("board_name"));
				q.setBoard_title(rs.getString("board_title"));
				q.setBoard_content(rs.getString("board_content"));
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
}
