<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.bit.dao.UsersDao"%>
<%@page import="kr.or.bit.dto.UsersDto"%>
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

	UsersDto dto = new UsersDto();
	
	UsersDao dao = new UsersDao();
	
	
	int delrow = dao.deleteUsers("aaa");
%>
DELETE : <%=delrow %><br>

<% 
	dto.setUserId("aaa");
	dto.setPasswords("1234");
	dto.setUserName("하우연");
	dto.setEmail("aaa@naver.com");
	dto.setPhone("010-111-3333".replace("-", ""));
	dto.setGender("M".toUpperCase());
	dto.setUserType("U");
	dto.setTermsOfUseYn("Y");
	dto.setLoginYn("Y");
	dto.setReserveYn("Y");
	dto.setUseSnsYn("Y");
	
	
%>
BEFORE INSERT : <%=dto.toString() %><br>

<% 	
	int row=dao.insertUsers(dto);

%>
INSERT : <%=row %><br>

<%
	dto = dao.getUserbyId("aaa");
%>
SELECT : <%=dto.toString() %><br>

<%
	List<UsersDto> dtoList = new ArrayList<UsersDto>();
	dtoList = dao.getUserList();
	
%>
<%
	dto.setPasswords("1004");
%> 
BEFORE UPDATE : <%= dto.toString() %><br>
<% 
	dao.updateUsers(dto);
	dto = dao.getUserbyId("aaa");
%>
UPDATE : <%=dto.toString() %>

</body>

</html>