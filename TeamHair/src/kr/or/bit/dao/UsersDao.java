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
		
		String sql = " INSERT INTO USERS(USERID, PASSWORDS, USERNAME, EMAIL, PHONE, GENDER, USERTYPE, TERMSOFUSEYN, LOGINYN, RESERVEYN, USESNSYN) \r\n" + 
				     " VALUES(?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?)\r\n"; 
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getPasswords());
			pstmt.setString(3, dto.getUserName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getUserType());
			pstmt.setString(8, dto.getTermsOfUseYn());
			pstmt.setString(9, dto.getLoginYn());
			pstmt.setString(10, dto.getReserveYn());
			pstmt.setString(11, dto.getUseSnsYn());

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
		
		String sql = " SELECT USERID, PASSWORDS, USERNAME, EMAIL, PHONE, GENDER, USERTYPE, TERMSOFUSEYN, LOGINYN, RESERVEYN, USESNSYN, CREATEDATE, UPDATEDATE, ISACTIVE\r\n" + 
				     " FROM USERS WHERE USERID= ? ";
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setUserId(rs.getString("userid"));
				dto.setPasswords(rs.getString("passwords"));
				dto.setUserName(rs.getString("username"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setGender(rs.getString("gender"));
				dto.setUserType(rs.getString("usertype"));
				dto.setTermsOfUseYn(rs.getString("termsofuseyn"));
				dto.setLoginYn(rs.getString("loginyn"));
				dto.setReserveYn(rs.getString("reserveyn"));
				dto.setUseSnsYn(rs.getString("usesnsyn"));
				dto.setCreateDate(rs.getDate("createdate"));
				dto.setUpdateDate(rs.getDate("updatedate"));
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
		
		String sql = " SELECT USERID, PASSWORDS, USERNAME, EMAIL, PHONE, GENDER, USERTYPE, TERMSOFUSEYN, LOGINYN, RESERVEYN, USESNSYN, CREATEDATE, UPDATEDATE, ISACTIVE\r\n" + 
			         " FROM USERS";

		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UsersDto dto = new UsersDto();

				dto.setUserId(rs.getString("userid"));
				dto.setPasswords(rs.getString("passwords"));
				dto.setUserName(rs.getString("username"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setGender(rs.getString("gender"));
				dto.setUserType(rs.getString("usertype"));
				dto.setTermsOfUseYn(rs.getString("termsofuseyn"));
				dto.setLoginYn(rs.getString("loginyn"));
				dto.setReserveYn(rs.getString("reserveyn"));
				dto.setUseSnsYn(rs.getString("usesnsyn"));
				dto.setCreateDate(rs.getDate("createdate"));
				dto.setUpdateDate(rs.getDate("updatedate"));
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
		
		String sql ="  UPDATE USERS \r\n" + 
					"  SET USERNAME = ? ,\r\n" + 
					"      EMAIL = ? ,\r\n" + 
					"      PHONE = ? ,\r\n" + 
					"      GENDER = ? ,\r\n" + 
					"      USERTYPE = ? ,\r\n" + 
					"      LOGINYN = ? ,\r\n" + 
					"      RESERVEYN = ? ,\r\n" + 
					"      USESNSYN = ? ,\r\n" + 
					"      UPDATEDATE = SYSDATE,\r\n" + 
					"      ISACTIVE =? \r\n" + 
					" WHERE USERID = ? \r\n"; 
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUserName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getUserType());
			pstmt.setString(6, dto.getLoginYn());
			pstmt.setString(7, dto.getReserveYn());
			pstmt.setString(8, dto.getUseSnsYn());
			pstmt.setString(9, dto.getIsActive());
			pstmt.setString(10, dto.getUserId());
			
			row=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return row;
	}

	public int changePassword(String userid, String password) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql =" UPDATE USERS \r\n" + 
					"  SET PASSWORDS = ? \r\n" + 
					" WHERE USERID = ? \r\n"; 
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, password);
			pstmt.setString(2, userid);
			
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
