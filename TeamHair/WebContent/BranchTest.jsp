<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.bit.dao.BranchDao"%>
<%@page import="kr.or.bit.dto.BranchDto"%>
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

	BranchDto dto = new BranchDto();
	
	BranchDao dao = new BranchDao();
	
	
	int delrow = dao.deleteBranch("aaa");
%>
DELETE : <%=delrow %><br>

<% 
	dto.setBranchID(123);
	dto.setBranchName("1234");
	dto.setAddress1("aaa@naver.com");
	dto.setAddress2("010-111-3333");
	dto.setPostalCode("postalcode");
	dto.setPhone("phone");
	dto.setMap_X(123);
	dto.setMap_Y(127);
%>


BEFORE INSERT : <%=dto.toString() %><br>

<% 	
	int row=dao.insertBranch(dto);

%>
INSERT : <%=row %><br>

<%
	dto = dao.getBranchById("aaa");
%>
SELECT : <%=dto.toString() %><br>


<%
	List<BranchDto> dtoList = new ArrayList<BranchDto>();
	dtoList = dao.getBranchList();
	
%>

<%
	dto.setBranchID(1004);
%> 
BEFORE UPDATE : <%= dto.toString() %><br>
<% 
	dao.updateBranch(dto);
	dto = dao.getBranchById("aaa");
%>
UPDATE : <%=dto.toString() %>

</body>

</html>