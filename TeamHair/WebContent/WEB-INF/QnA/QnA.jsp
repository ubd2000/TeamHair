<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>QnA 게시판</title>
</head>
<body>
<h3>QnA메인페이지</h3>
<hr>
<h3 >리스트 보여줄곳</h3>
<div class="container">
		<div id="list">
			<table board="1">
				<c:set var="qnalist" value="${requestScope.qnalist}"></c:set>
				
				<c:forEach var="i" items="${qnalist }">
				<tr>
					<td>글번호 : ${i.boardID }</td>
					<td>제목 : <a href="QnAdetail.do?boardID=${i.boardID}">${i.boardSubject}</a></td>&nbsp; &nbsp; &nbsp;
					<td>작성자 : ${i.userID }</td>
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
<input type="button" value="글쓰기" onclick="location='QnAwrite.do'">
</body>

</html>

