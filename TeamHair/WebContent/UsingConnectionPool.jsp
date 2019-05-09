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
<title>Tomcat connection pool</title>
</head>
<body>
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Context context = new InitialContext(); //이름기반 검색
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");//jdbc/oracle pool 검색
		
		conn = ds.getConnection(); //POOL 안에 있는 connection 객체 얻어오기
		
		out.print("db 연결 여부 : " + conn.isClosed() + "<br>");
		//POINT
		conn.close(); //객체 다시 POOL에게 반환 ...
		out.print("db 연결 여부 : " + conn.isClosed() + "<br>");
	%>
</body>
</html>