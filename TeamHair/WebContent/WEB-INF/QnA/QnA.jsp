<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>QnA 게시판</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,400i,600,700,800" rel="stylesheet">

<h3>QnA메인페이지</h3>
<hr>
		<div id="list">
			<table>
				<tr>
	    			<th><p>num</p></th>
					<th class="name">제목</th>
					<th><p>작성자</p></th>
					<th><p>작성일</p></th>
					<th><p>조회수</p></th>
				</tr>
				<c:set var="qnalist" value="${requestScope.qnalist}"></c:set>
				<c:forEach var="i" items="${qnalist }">
				<tr>
					<td>${i.boardID }</td>
					<td><a href="QnAdetail.do?boardID=${i.boardID}">${i.boardSubject}</a></td>
					<td>${i.userID }</td>
					<td>${i.createDate }</td>
					<td>${i.readCount}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
<%-- <table>
	<tr><td>작성자 : <%=request.getParameter("board_name") %></td>
	</tr>
	
	<tr><td>제목 : <%=request.getParameter("board_title") %></td>
	</tr>
	
	<tr><td>내용 : <%=request.getParameter("board_content") %></td>
	</tr>
</table>
 --%>
<hr>
<input type="button" class="dropdown" value="글쓰기" onclick="location='QnAwrite.do'">
</body>

</html>

