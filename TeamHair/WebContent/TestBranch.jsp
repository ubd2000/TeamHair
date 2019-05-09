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

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
	
	
	int delrow = dao.deleteBranch(123);
%>
DELETE : <%=delrow %><br>

<% 
	dto.setBranchID(123);
	dto.setBranchName("강남지점");
	dto.setAddress1("서울시 강남구 서초동");
	dto.setAddress2("344-3");
	dto.setPostalCode("12345");
	dto.setPhone("025337789");
	dto.setMap_X(123);
	dto.setMap_Y(127);
%>

BEFORE INSERT : <%=dto.toString() %><br>

<% 	
	int row=dao.insertBranch(dto);

%>
INSERT : <%=row %><br>

<%
	dto = dao.getBranchById(123);
%>
SELECT : <%=dto.toString() %><br>


<%
	List<BranchDto> dtoList = new ArrayList<BranchDto>();
	dtoList = dao.getBranchList();
	
%>

<c:set var="list" value="<%=dtoList %>"/>
<table border="1">
	<tr><td>소개</td><td>웹사이트</td></tr>
	<c:forEach var="branch" items="${list }">
		
		<tr><td>${branch}</td><td>${branch.branchName }</td></tr>
	</c:forEach>
</table>


<%
	dto.setBranchName("서초지점");
%> 
BEFORE UPDATE : <%= dto.toString() %><br>
<% 
	dao.updateBranch(dto);
	dto = dao.getBranchById(123);
%>
UPDATE : <%=dto.toString() %>

</body>

</html>