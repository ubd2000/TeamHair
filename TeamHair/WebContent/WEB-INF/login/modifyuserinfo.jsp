<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="userlist" value="${requestScope.codedtolist}"/>
	
<!DOCTYPE html>
<html lang="en">

<!-- Header Include Start -->
<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
<!-- Header Include End -->

<!-- 컨텐츠 팝업 시작 -->
<body>
	<div class="container">
		<div class="row contents_modify">
			<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3 modifymenu">
				<ul>
					<a href="Modify.usr"><li>프로필 수정</li></a>
					<a href="ChangePwd.usr"><li>비밀번호 변경</li></a>
				</ul>
			</div>

			<div class="col-lg-9 col-md-9 col-xs-9 col-sm-9 modifycontent">
				<form action="ModifyUserOk.usr" method="POST">
					<div class="modifycontentsession1">
						<img src="img/main1.jpg" class="rounded-circle" alt="프로필사진">
						<p>
							<strong>${requestScope.usersdto.userId}</strong><br> <a href="#">프로필 사진 바꾸기</a>
						</p>
					</div>

					<div class="modifycontentsession2">
						<input type="hidden" id="pass" name="pass" class="col-md-6 inputcss form-control" value=${requestScope.usersdto.passwords}>
					</div>

					<div class="modifycontentsession2">
						<label class="col-md-3 labelcss" for="name">사용자 이름</label> 
						<input type="text" id="name" name="name" class="col-md-6 inputcss form-control" value=${requestScope.usersdto.userName}>
					</div>
					
					<div class="modifycontentsession2">
						<label class="col-md-3 labelcss" for="website">웹사이트</label> 
						<input type="text" id="website" name="website" class="col-md-6 inputcss form-control"  value=${requestScope.profiledto.website}>
					</div>
					<div class="modifycontentsession2">
						<label class="col-md-3 labelcss" for="introduction">소개</label> 
						<input type="text" id="introduction" name="introduction" class="col-md-6 inputcss form-control"  value=${fn:replace(requestScope.profiledto.introduction, " ", "&nbsp;")}>
					</div>
					<div class="modifycontentsession2">
						<label class="col-md-3 labelcss" for="email">이메일</label> 
						<input type="text" id="email" name="email" class="col-md-6 inputcss form-control"  value=${requestScope.usersdto.email}>
					</div>
					<div class="modifycontentsession2">
						<label class="col-md-3 labelcss" for="phone">전화번호</label> 
						<input type="text" id="phone" name="phone" class="col-md-6 inputcss form-control"  value=${requestScope.usersdto.phone}>
					</div>
					<div class="modifycontentsession2">
						<input type="hidden" id="gender" name="gender" class="col-md-6 inputcss form-control" value=${requestScope.usersdto.gender}>
					</div>
					
					<div class="modifycontentsession2">
						<label class="col-md-3 labelcss" for="usertype">이용타입</label> 
						<select
							class="col-md-6 inputcss form-control form-control-lg"
							id="usertype" name="usertype">
							
							<c:forEach var="i" begin="0" end="${userlist.size()-1}">
								<c:choose>
									<c:when test="${userlist[i].code == requestScope.usersdto.userType}">
										<option value="${ userlist[i].code}" selected>${ userlist[i].codeName}</option>
									</c:when>
									<c:otherwise>
										<option value="${ userlist[i].code}" >${ userlist[i].codeName}</option>
									</c:otherwise> 
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<div class="modifycontentsession2">
						<label class="col-md-3 labelcss2" for="useSnsYn">로그인상태 유지</label>
						<c:choose>
							<c:when test="${requestScope.usersdto.loginYn=='Y'}">
								<input type="checkbox" id="loginYn" name="loginYn" class="col-md-1 form-control" checked>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="loginYn" name="loginYn" class="col-md-1 form-control">
							</c:otherwise> 
						</c:choose>
					</div>
					
					<div class="modifycontentsession2">
						<label class="col-md-3 labelcss2" for="useSnsYn">SNS 활성화 여부</label>
						<c:choose>
							<c:when test="${requestScope.usersdto.useSnsYn=='Y'}">
								<input type="checkbox" id="useSnsYn" name="useSnsYn" class="col-md-1 form-control" checked>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="useSnsYn" name="useSnsYn" class="col-md-1 form-control">
							</c:otherwise> 
						</c:choose>
					</div>
					<div class="modifycontentsession2">
						<label class="col-md-3 labelcss2" for="reserveYn">예약 활성화 여부</label>
						<c:choose>
							<c:when test="${requestScope.usersdto.reserveYn=='Y'}">
								<input type="checkbox" id="reserveYn" name="reserveYn" class="col-md-1 form-control" checked>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="reserveYn" name="reserveYn" class="col-md-1 form-control">
							</c:otherwise> 
						</c:choose>
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