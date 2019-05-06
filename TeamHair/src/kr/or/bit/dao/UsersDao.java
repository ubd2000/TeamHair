package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.UsersDto;


public class UsersDao {
	DataSource ds = null;

	public UsersDao() throws Exception {
		Context context = new InitialContext(); // 이름기반 검색
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); /// jdbc/oracle pool 검색
	}

	//Users 데이터 삽입
	public int insertUsers(UsersDto dto) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO USERS(USERID, PASSWORDS, EMAIL, PHONE, GENDER, CREATEDATE, UPDATEDATE, ISHAIRDESIGNER)\n" + 
				     "VALUES(?,?,?,?,?, SYSDATE, SYSDATE, ?)\n" ;
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getPasswords());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getGender());
			pstmt.setString(6, dto.getIsHairDesigner());
			
			row=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return row;
	}
	
	public UsersDto getUserbyId (String userid) {
		UsersDto dto = new UsersDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT USERID, PASSWORDS, EMAIL, PHONE, GENDER, CREATEDATE, UPDATEDATE, ISHAIRDESIGNER, ISACTIVE FROM USERS WHERE USERID=?";
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setUserId(rs.getString("userid"));
				dto.setPasswords(rs.getString("passwords"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setGender(rs.getString("gender"));
				dto.setCreateDate(rs.getDate("createdate"));
				dto.setUpdateDate(rs.getDate("updatedate"));
				dto.setIsHairDesigner(rs.getString("ishairdesigner"));
				dto.setIsActive(rs.getString("isactive"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();} catch (Exception e){};
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return dto;
	}

	public List<UsersDto> getUserList () {
		List<UsersDto> dtoList = new ArrayList<UsersDto>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT USERID, PASSWORDS, EMAIL, PHONE, GENDER, CREATEDATE, UPDATEDATE, ISHAIRDESIGNER, ISACTIVE FROM USERS";
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UsersDto dto = new UsersDto();

				dto.setUserId(rs.getString("userid"));
				dto.setPasswords(rs.getString("passwords"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setGender(rs.getString("gender"));
				dto.setCreateDate(rs.getDate("createdate"));
				dto.setUpdateDate(rs.getDate("updatedate"));
				dto.setIsHairDesigner(rs.getString("ishairdesigner"));
				dto.setIsActive(rs.getString("isactive"));
				
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();} catch (Exception e){};
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return dtoList;
	}

	public int updateUsers(UsersDto dto) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE USERS\n" + 
				       "SET PASSWORDS = ?,\n" + 
				   "    EMAIL = ?,\n" + 
				   "    PHONE = ?,\n" + 
				   "    GENDER = ?,\n" + 
				   "    UPDATEDATE = SYSDATE,\n" + 
				   "    ISHAIRDESIGNER = ?,\n" + 
				   "    ISACTIVE = ? \n" + 
				   " WHERE USERID = ?\n" ; 
		
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPasswords());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getIsHairDesigner());
			pstmt.setString(6, dto.getIsActive());
			pstmt.setString(7, dto.getUserId());
			
			row=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return row;
	}

	public int deleteUsers(String userid) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM USERS WHERE USERID = ? ";	
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			row=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return row;
	}

}
