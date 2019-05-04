<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>
<h3>글작성 페이지</h3>
<hr>

<form action="QnAinsert.do">
	<table>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="board_name" value="session.getParam" readonly></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="board_title"></td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td><input type="text" name="board_content"></td>
		</tr>
		
		<tr>
			<td>등록</td>
			<td><input type="submit"></td>
		</tr>
	
	</table>
</form>
</body>
</html>