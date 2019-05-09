package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.SpaceDto;

public class SpaceDao {
	DataSource ds = null;

	public SpaceDao() throws Exception {
		Context context = new InitialContext(); // 이름기반 검색
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); /// jdbc/oracle pool 검색
	}

	//Users 데이터 삽입
	public int insertSpace(SpaceDto dto) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO Space(SpaceID, SpaceType, BranchID, SpaceName)\n" + 
				     "VALUES(?,?,?,?)\n" ;
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getSpaceId());
			pstmt.setString(2, dto.getSpaceType());
			pstmt.setInt(3, dto.getBranchId());
			pstmt.setString(4, dto.getSpaceName());
			
			
			row=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return row;
	}
	
	public SpaceDto getSpaceById (int spaceID) {
		SpaceDto dto = new SpaceDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT SpaceID, SpaceType, BranchID, SpaceName FROM Space WHERE SpaceID=?";
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, spaceID);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setSpaceId(rs.getInt("SpaceID"));
				dto.setSpaceType(rs.getString("SpaceType"));
				dto.setBranchId(rs.getInt("BranchID"));
				dto.setSpaceName(rs.getString("SpaceName"));
							
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

	public List<SpaceDto> getSpaceList () {
		List<SpaceDto> dtoList = new ArrayList<SpaceDto>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT SpaceID, SpaceType, BranchID, SpaceName FROM Space";
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
						
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SpaceDto dto = new SpaceDto();

				dto.setSpaceId(rs.getInt("SpaceID"));
				dto.setSpaceType(rs.getString("SpaceType"));
				dto.setBranchId(rs.getInt("BranchID"));
				dto.setSpaceName(rs.getString("SpaceName"));
				
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

	public int updateSpace(SpaceDto dto) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE Space\n" + 
				       "SET SpaceID = ?,\n" + 
				   "    SpaceType = ?,\n" + 
				   "    BranchID = ?,\n" + 
				   "    SpaceName = ?,\n"+
				   " WHERE SpaceID = ?\n" ; 		
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getSpaceId());
			pstmt.setString(2, dto.getSpaceType());
			pstmt.setInt(3, dto.getBranchId());
			pstmt.setString(4, dto.getSpaceName());
			
			row=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return row;
	}

	public int deleteSpace(int spaceid) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM Space WHERE SpaceID = ? ";	
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, spaceid);
			
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
