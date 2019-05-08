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
		
		String sql = "INSERT INTO Branch(BranchID, BranchName, Address1, Address2, PostalCode, Phone, Map_X, Map_Y)\n" + 
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
	
	public BranchDto getBranchById (int branchId) {
		BranchDto dto = new BranchDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT BranchID, BranchName, Address1, Address2, PostalCode, Phone, Map_X, Map_Y FROM Branch WHERE BranchID=?";
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, branchId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setBranchID(rs.getInt("BranchID"));
				dto.setBranchName(rs.getString("BranchName"));
				dto.setAddress1(rs.getString("Address1"));
				dto.setAddress2(rs.getString("Address2"));
				dto.setPostalCode(rs.getString("PostalCode"));
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
		
		String sql = "SELECT BranchID, BranchName, Address1, Address2, PostalCode, Phone, Map_X, Map_Y FROM Branch";
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
						
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BranchDto dto = new BranchDto();
				System.out.println(rs.getInt("BranchID"));
				dto.setBranchID(rs.getInt("BranchID"));
				dto.setBranchName(rs.getString("BranchName"));
				dto.setAddress1(rs.getString("Address1"));
				dto.setAddress2(rs.getString("Address2"));
				dto.setPostalCode(rs.getString("PostalCode"));
				dto.setPhone(rs.getString("Phone"));
				dto.setMap_X(rs.getInt("Map_X"));
				dto.setMap_Y(rs.getInt("Map_Y"));
				System.out.println(dto.toString());
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
		
		String sql = "UPDATE Branch 			    \r\n" + 
				"	SET BranchName = ? ,\r\n" + 
				"			Address1 = ? , \r\n" + 
				"			Address2 = ? , \r\n" + 
				"			PostalCode = ?, \r\n" + 
				"			Phone = ?, \r\n" + 
				"			Map_X = ?, \r\n" + 
				"			Map_Y = ? \r\n" + 
				" WHERE BranchID = ? " ; 		
		
		
		
		try {
			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
					
			pstmt.setString(1, dto.getBranchName());
			pstmt.setString(2, dto.getAddress1());
			pstmt.setString(3, dto.getAddress2());
			pstmt.setString(4, dto.getPostalCode());
			pstmt.setString(5, dto.getPhone());
			pstmt.setInt(6, dto.getMap_X());
			pstmt.setInt(7, dto.getMap_Y());
			pstmt.setInt(8, dto.getBranchID());
			
			row=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception e){};
			try {conn.close();} catch (Exception e){};
		}
		
		return row;
	}

	public int deleteBranch(int branchId) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM Branch WHERE BranchId = ? ";	
		
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, branchId);
			
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
