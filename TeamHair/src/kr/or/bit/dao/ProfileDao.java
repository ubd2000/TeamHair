package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.ProfileDto;
import kr.or.bit.dto.UsersDto;

public class ProfileDao {

	DataSource ds = null;

	public ProfileDao() throws Exception {
		Context context = new InitialContext(); // 이름기반 검색
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); /// jdbc/oracle pool 검색
	}

	//Users 데이터 삽입
	public int insertProfile(ProfileDto dto) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " INSERT INTO PROFILE(USERID, INTRODUCTION, WEBSITE, PHOTONAME)\r\n" + 
				     " VALUES(?, ?, ?, ?)\r\n" ; 
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getIntroduction());
			pstmt.setString(3, dto.getWebsite());
			pstmt.setString(4, dto.getPhotoName());

			row=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return row;
	}

	
	public ProfileDto getProfilebyId (String userid) {
		ProfileDto dto = new ProfileDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT USERID, INTRODUCTION, WEBSITE, PHOTONAME FROM PROFILE WHERE USERID = ? \r\n"; 
				
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setUserId(rs.getString("userid"));
				dto.setIntroduction(rs.getString("introduction"));
				dto.setWebsite(rs.getString("website"));
				dto.setPhotoName(rs.getString("photoname"));
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

	public List<ProfileDto> getProfileList () {
		List<ProfileDto> dtoList = new ArrayList<ProfileDto>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT USERID, INTRODUCTION, WEBSITE, PHOTONAME FROM PROFILE \r\n"; 


		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProfileDto dto = new ProfileDto();

				dto.setUserId(rs.getString("userid"));
				dto.setIntroduction(rs.getString("introduction"));
				dto.setWebsite(rs.getString("website"));
				dto.setPhotoName(rs.getString("photoname"));

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

	public int updateProfile(ProfileDto dto) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql ="  UPDATE PROFILE \r\n" + 
					"   SET INTRODUCTION = ? ,\r\n" + 
					"      WEBSITE = ? ,\r\n" + 
					"      PHOTONAME = ? \r\n" + 
					"  WHERE USERID = ? \r\n" ; 
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getIntroduction());
			pstmt.setString(2, dto.getWebsite());
			pstmt.setString(3, dto.getPhotoName());
			pstmt.setString(4, dto.getUserId());
			
			row=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return row;
	}

	
	
	public int deleteProfile(String userid) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM PROFILE WHERE USERID = ? ";	
		
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
