package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.CodeDto;
import kr.or.bit.dto.ProfileDto;

public class CodeDao {

	DataSource ds = null;

	public CodeDao() throws Exception {
		Context context = new InitialContext(); // 이름기반 검색
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); /// jdbc/oracle pool 검색
	}

	public List<CodeDto> getCodeListById (String userid) {
		
		
		List<CodeDto> dtoList = new ArrayList<CodeDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT CLASSCODE, CLASSNAME, CODE, CODENAME FROM CODE WHERE CLASSCODE = ? \r\n"; 
				
		try {
			conn = ds.getConnection();
			//
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CodeDto dto = new CodeDto();
				
				dto.setClassCode(rs.getString("classcode"));
				dto.setClassName(rs.getString("classname"));
				dto.setCode(rs.getString("code"));
				dto.setCodeName(rs.getString("codename"));
				
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

	
}
