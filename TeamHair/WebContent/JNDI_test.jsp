<%@page import="java.sql.SQLException"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	Connection conn = null; 
	Statement stmt = null;
	ResultSet rs = null; 
	  
	StringBuffer sql = new StringBuffer(); 
	sql.append("select count(*) from emp"); 
	  
	int result = 0; 
	try{ 
		 
	     Context initContext = new InitialContext(); 
	     Context envContext = (Context)initContext.lookup("java:/comp/env");
	     
	     DataSource ds = (DataSource)envContext.lookup("jdbc/oracle"); 
	     conn = ds.getConnection(); 
	     stmt = conn.createStatement(); 
	     rs = stmt.executeQuery(sql.toString()); 
	     rs.next(); 
	     result = rs.getInt(1); 
	     System.out.println(result);
	}catch(SQLException se){ 
	     se.printStackTrace(); 
	} finally {
		conn.close();
	}


%>
</body>
</html>