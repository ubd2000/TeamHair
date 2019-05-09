<%@page import="kr.or.bit.dao.ProfileDao"%>
<%@page import="kr.or.bit.dto.ProfileDto"%>
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
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	ProfileDto dto = new ProfileDto();

	ProfileDao dao = new ProfileDao();
	
	
	
	int delrow = dao.deleteProfile("aaa");
%>
DELETE : <%=delrow %><br>

<% 
	dto.setUserId("aaa");
	dto.setIntroduction("하우리의 헤어디자인");
	dto.setWebsite("www.naver.com");
	dto.setPhotoName(null);
	
	
%>
BEFORE INSERT : <%=dto.toString() %><br>

<% 	
	int row=dao.insertProfile(dto);

%>
INSERT : <%=row %><br>


<%
	dto = dao.getProfilebyId("aaa");
%>
SELECT : <%=dto.toString() %><br>

<%
	List<ProfileDto> dtoList = new ArrayList<ProfileDto>();
	dtoList = dao.getProfileList();
	
%>


<c:set var="list" value="<%=dtoList %>"/>
<table border="1">
	<tr><td>소개</td><td>웹사이트</td></tr>
	<c:forEach var="profile" items="${list }">
		<tr><td>${profile.introduction}</td><td>${profile.website }</td></tr>
	</c:forEach>
</table>

<% 
	dto.setIntroduction("하우리 헤어드자인");

%>

BEFORE UPDATE : <%= dto.toString() %><br>
<% 
	dao.updateProfile(dto);
	dto = dao.getProfilebyId("aaa");
%>
UPDATE : <%=dto.toString() %>

</body>

</html>