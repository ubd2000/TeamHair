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
			<td>${detail.boardID }</td>
		</tr>
		
		<tr>
			<td>카테고리</td>
			<td>${detail.boardName }</td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td>${detail.boardSubject }</td>
		</tr>
		
		<tr>
			<td>작성자</td>
			<td>${detail.userID }</td>
		</tr>
		
		<tr>
			<td>작성일</td>
			<td>${detail.createDate }</td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td>${detail.boardContent }</td>
		</tr>
		
		<tr>
			<td>업로드 파일</td>
			<td>${detail.fileName }</td>
		</tr>
		
		<tr>
			<td>댓글</td>
			<td>$댓글 출력</td>
		</tr>
	</table>
	
	<input type="button" value="글 수정" onClick="location.href='QnAupdateform.do?boardid=${detail.boardID}'">
	<input type="button" value="글 삭제" onClick="location.href='QnAdelete.do?boardid=${detail.boardID}'">
	<input type="button" value="댓글달기">
</body>
</html>