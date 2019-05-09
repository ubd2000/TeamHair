<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상세정보</title>
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.0.min.js" ></script>
	<script>
		$(function(){
			$('#enroll').click(function(){
				var param = {
				       "comment":$('#comment').val(),
					   "boardid":$('#boardid').val()
				};
				console.log(param);
				//alert("**param : " + $('#reply_writer').val());
				$.ajax({
					url:"QnAcommentsinsert.do",
					datatype:"json",
					data:param,
				});
			});
		});
	</script>
	
	<script type="text/javascript">
		function check(){
			var form = document.file;
			var ext = form.filename.value;
			console.log(form);
			
			var result = ext.substring(ext.lastIndexOf(".")+1);
			console.log(result);
			
 			if(result == "jpg" || result=="png" || result=="jpeg" ||result=="bmp" || result=="gif"){
				console.log("이미지파일 맞음");
				form.action="FileUpload.do";
				document.getElementById('file').submit();
			}else{
				console.log("이미지파일 아님");
				alert('이미지 파일이 아닙니다.');
			}
		}
	</script>

</head>
<body>
	<c:set var="detail" value="${requestScope.detail}"></c:set>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>${detail.boardID }</td>
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
		
	</table>
	
	
	<input type="button" value="글 수정" onClick="location.href='QnAupdateform.do?boardid=${detail.boardID}'">
	<input type="button" value="글 삭제" onClick="location.href='QnAdelete.do?boardid=${detail.boardID}'">
	<input type="button" value="답글" onClick="location.href='QnAdelete.do?boardid=${detail.boardID}'">
	<input type="button" value="목록보기" onClick="location.href='QnA.do'">
	<hr>

	댓글<br>
	<div id="reply">
		<c:set var="comments" value="${requestScope.comment}"></c:set>
		<table>
		<c:forEach var="i" items="${comments }">
		
			<tr>
				<td>작성자 : ${i.userID }</td>
				<td>${i.createDate }</td>
			</tr>
			<tr>
				<td>내용 : ${i.comments }</td>
				<td><input type="button" value="답글"></td>
			</tr>
		</c:forEach>
		</table>
		<hr>
	</div>
	
	<!-- <form action="QnAcommentsinsert.do" method="post"> -->
	<input type="hidden" name="boardid" id="boardid" value="${detail.boardID }">
	
	<input type="text" name="comment" id="comment">
	<input type="button" id="enroll" value="등록">
	
	
</body>
</html>