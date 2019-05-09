<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<!-- Header Include Start -->
<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
<!-- Header Include End -->

<!-- 컨텐츠 팝업 시작 -->
<body>
	<div class="container">
		<div class="row contents_modify_pwd">
			<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3 modifymenu_pwd">
				<ul>
					<a href="Modify.usr"><li>프로필 수정</li></a>
					<a href="ChangePwd.usr"><li>비밀번호 변경</li></a>
				</ul>
			</div>

			<div class="col-lg-9 col-md-9 col-xs-9 col-sm-9 modifycontent">
				<form action="ChangePwdOk.usr" method="POST">
					<div class="modifycontentsession1_pwd">
						<img src="img/main1.jpg" class="rounded-circle" alt="프로필사진">
						<p>
							<strong>아이디</strong>
						</p>
					</div>

					<div class="modifycontentsession2">
						<label class="col-md-3 labelcss" for="nowpwd">이전 비밀번호</label> <input
							type="password" id="nowpwd" name="nowpwd"
							class="col-md-6 inputcss form-control">
					</div>
					<div class="modifycontentsession2">
						<label class="col-md-3 labelcss" for="newpwd">새 비밀번호</label> <input
							type="password" id="newpwd" name="newpwd"
							class="col-md-6 inputcss form-control">
					</div>
					<div class="modifycontentsession2">
						<label class="col-md-3 labelcss" for="newpwd2">새 비밀번호 확인</label> <input
							type="password" id="newpwd2" name="newpwd2"
							class="col-md-6 inputcss form-control">
					</div>
					
					
					<div class="modifycontentsession3">
						<button class="btn-lg btn btn-outline-primary modifybtn">수정</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<!-- 컨텐츠 팝업 끝 -->

<script src="js/index.js"></script>
<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>