<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 페이지</title>
</head>
<body>
<h3>글 수정 페이지</h3>
<hr>
<c:set var="qna" value="${requestScope.qna}"></c:set>
<form action="QnAupdate.do">
	<table>
		<tr>
			<td>작성자</td>
			<td>session.userid</td>
		</tr>
		
		<tr>
			<td>카테고리</td>
			<td><input type="text" name="boardname" value="${qna.boardName }"></td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td><input type="text" name="boardsubject" value="${qna.boardSubject }"></td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td><input type="text" name="boardcontent" value="${qna.boardContent }"></td>
		</tr>
		
		<tr>
			<td>파일 업로드</td>
			<td><input type="text" name="filename" value="${qna.fileName }"></td>
		</tr>
		<tr>
			<td><input type="submit" value="수정완료"></td>
		</tr>
		<input type="hidden" name="boardid" value="${qna.boardID }">
	</table>
</form>
</body>
</html>