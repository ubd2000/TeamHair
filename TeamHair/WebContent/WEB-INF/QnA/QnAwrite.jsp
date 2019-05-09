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
			<td><input type="text" name="userid" value="$받아오기getParam" readonly></td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td><input type="text" name="boardsubject"></td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td><input type="text" name="boardcontent"></td>
		</tr>
		
		<tr>
			<td>파일 업로드</td>
			<td><input type="file" name="filename"></td>
		</tr>
		
		<tr>
			<td>등록</td>
			<td><input type="submit" value="글 등록"></td>
		</tr>
	
	</table>
</form>
</body>
</html>