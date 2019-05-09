<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<!-- Header Include Start -->
<jsp:include page="common/header.jsp"></jsp:include>
<!-- Header Include End -->

<!-- 컨텐츠 팝업 시작 -->
<body>
	<div class="container">
		<div class="row contents">
			<div class="col-lg-7 col-md-7 col-xs-7 col-sm-7 imgsession">
				<img src="img/main1.jpg" alt="프로필 업로드 사진">
			</div>

			<div class="col-lg-5 col-md-5 col-xs-5 col-sm-5 contentsession">
				<div class="row">
					<div class="contentsession1">
						<img src="img/main1.jpg" class="rounded-circle" alt="프로필사진">
						<span><strong>아이디</strong></span> <a href="#"><span>&nbsp;·&nbsp;예약하기</span></a>
					</div>
					<div class="contentsession2">
						<p>
							게시글 내용을 적습니다.<br> #첫글 #팔로우 #인스타그랙
						</p>
						<!-- 덧글 -->
						<div class="contentsession2_reply">
							<span><strong>아이디1</strong></span>&nbsp;&nbsp;
							<span>게시글 잘 보고 갑니다~</span>&nbsp;&nbsp;
							<a>답글 달기</a>
						</div>
						<div class="contentsession2_reply">
							<span><strong>아이디2</strong></span>&nbsp;&nbsp;
							<span>게시글 잘 보고 갑니다~</span>&nbsp;&nbsp;
							<a>답글 달기</a>
						</div>
						<div class="contentsession2_reply">
							<span><strong>아이디3</strong></span>&nbsp;&nbsp;
							<span>게시글 잘 보고 갑니다~</span>&nbsp;&nbsp;
							<a>답글 달기</a>
						</div>
						<div class="contentsession2_reply">
							<span><strong>아이디4</strong></span>&nbsp;&nbsp;
							<span>게시글 잘 보고 갑니다~</span>&nbsp;&nbsp;
							<a>답글 달기</a>
						</div>
						<div class="contentsession2_reply">
							<span><strong>아이디5</strong></span>&nbsp;&nbsp;
							<span>게시글 잘 보고 갑니다~</span>&nbsp;&nbsp;
							<a>답글 달기</a>
						</div>
						<div class="contentsession2_reply">
							<span><strong>아이디6</strong></span>&nbsp;&nbsp;
							<span>게시글 잘 보고 갑니다~</span>&nbsp;&nbsp;
							<a>답글 달기</a>
						</div>
					</div>
					<div class="contentsession3">
						<!-- 클릭전 -->
						<i class="far fa-heart"></i>
						<!-- 클릭후 -->
						<!-- <i class="fas fa-heart"></i> -->
						<i class="far fa-comment"></i><br> <span>좋아요 20개</span><br>
						<span>2019.05.07</span>
					</div>
					<div class="contentsession4">
						<!-- 로그인시 -->
						<textarea class="form-control" rows="1" placeholder="댓글쓰기"></textarea>
						<button class="btn-lg btn btn-outline-primary">등록</button>
						<!-- 비로그인시 -->
						<!-- <a href="#">덧글을 남기시려면 클릭하세요.</a> -->
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
<!-- 컨텐츠 팝업 끝 -->

<script src="js/index.js"></script>
<jsp:include page="common/footer.jsp"></jsp:include>