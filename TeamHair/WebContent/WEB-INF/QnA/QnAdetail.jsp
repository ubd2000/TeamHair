<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상세정보</title>
</head>
<body>
	<c:set var="detail" value="${requestScope.detail}"></c:set>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>request 글번호받을곳</td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td>${detail.board_title }</td>
		</tr>
		
		<tr>
			<td>작성자</td>
			<td>${detail.board_name }</td>
		</tr>
		
		<tr>
			<td>작성일</td>
			<td>request 작성일</td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td>${detail.board_content }</td>
		</tr>
	</table>
	
	<input type="button" value="글 수정" onClick="location.href='QnAupdate.do?board_num=${QnA.board_num}'">
	<input type="button" value="글 삭제" onClick="location.href='QnAdelete.do?board_num=${QnA.board_num}'">
	<input type="button" value="댓글달기">
</body>
</html>