package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.BranchDto;


public class BranchDao {
	DataSource ds = null;

	public BranchDao() throws Exception {
		Context context = new InitialContext(); // 이름기반 검색
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); /// jdbc/oracle pool 검색
	}

	//Users 데이터 삽입
	public int insertBranch(BranchDto dto) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BRANCH(BranchID, BranchName, Address1, Address2, PostalCode, Phone, Map_X, Map_Y)\n" + 
				     "VALUES(?,?,?,?,?,?,?,?)\n" ;
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getBranchID());
			pstmt.setString(2, dto.getBranchName());
			pstmt.setString(3, dto.getAddress1());
			pstmt.setString(4, dto.getAddress2());
			pstmt.setString(5, dto.getPostalCode());
			pstmt.setString(6, dto.getPhone());
			pstmt.setInt(7, dto.getMap_X());
			pstmt.setInt(8, dto.getMap_Y());
			
			row=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return row;
	}
	
	public BranchDto getBranchById (String branchid) {
		BranchDto dto = new BranchDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT BranchID, BranchName, Address1, Address2, GEPostalCode, Phone, Map_X, Map_Y FROM Branch WHERE BranchID=?";
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, branchid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setBranchID(rs.getInt("BranchID"));
				dto.setBranchName(rs.getString("BranchName"));
				dto.setAddress1(rs.getString("Address1"));
				dto.setAddress2(rs.getString("Address2"));
				dto.setPostalCode(rs.getString("GEPostalCode"));
				dto.setPhone(rs.getString("Phone"));
				dto.setMap_X(rs.getInt("Map_X"));
				dto.setMap_Y(rs.getInt("Map_Y"));				
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

	public List<BranchDto> getBranchList () {
		List<BranchDto> dtoList = new ArrayList<BranchDto>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT BranchID, BranchName, Address1, Address2, GEPostalCode, Phone, Map_X, Map_Y FROM Branch";
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
						
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BranchDto dto = new BranchDto();

				dto.setBranchID(rs.getInt("BranchID"));
				dto.setBranchName(rs.getString("BranchName"));
				dto.setAddress1(rs.getString("Address1"));
				dto.setAddress2(rs.getString("Address2"));
				dto.setPostalCode(rs.getString("GEPostalCode"));
				dto.setPhone(rs.getString("Phone"));
				dto.setMap_X(rs.getInt("Map_X"));
				dto.setMap_Y(rs.getInt("Map_Y"));
				
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

	public int updateBranch(BranchDto dto) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE Branch\n" + 
				       "SET BranchID = ?,\n" + 
				   "    BranchName = ?,\n" + 
				   "    Address1 = ?,\n" + 
				   "    Address2 = ?,\n" + 
				   "    GEPostalCode = SYSDATE,\n" + 
				   "    Phone = ?,\n" + 
				   "    Map_X = ? \n" + 
				   "    Map_Y = ? \n" + 
				   " WHERE BranchID = ?\n" ; 		
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getBranchID());
			pstmt.setString(2, dto.getBranchName());
			pstmt.setString(3, dto.getAddress1());
			pstmt.setString(4, dto.getAddress2());
			pstmt.setString(5, dto.getPostalCode());
			pstmt.setString(6, dto.getPhone());
			pstmt.setInt(7, dto.getMap_X());
			pstmt.setInt(8, dto.getMap_Y());
			
			row=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return row;
	}

	public int deleteBranch(String branchid) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM Branch WHERE BranchId = ? ";	
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, branchid);
			
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
