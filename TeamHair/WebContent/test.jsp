<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
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

	Context initContext = new InitialContext();
  	Context envContext  = (Context) initContext.lookup("java:/comp/env");
  	DataSource dataSource = (DataSource) envContext.lookup("jdbc/oracle");
  	Connection conn = dataSource.getConnection();
	System.out.println(conn.isClosed());
  // 아래와 같이 단축 사용 가능
//  Context context = new InitialContext();
//  DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
//  Connection con = dataSource.getConnection();   



%>
</body>
</html>