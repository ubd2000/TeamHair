<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<c:set var="QnAlist" value="${requestScope.qnalist}"></c:set>

<div class="container">
		<div id="list">
			<table>
				<tr>
					<th>제목</th>
					<th>내용</th>
				</tr>
				<c:forEach var="i" begin="0" end="${QnAlist.size() }">
					<tr>
						<td>${QnAlist[i].board_title }</td>
						<td>${QnAlist[i].board_content }</td>
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

