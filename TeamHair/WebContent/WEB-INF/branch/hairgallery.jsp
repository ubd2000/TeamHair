<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

	<!-- Header Include Start -->
	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
      <link rel="stylesheet" href="css/style.css">
	<!-- Header Include End -->

<section class="home-banner-area relative banner-area">
	<div class="container-fluid">
		<div class="row  d-flex align-items-center justify-content-center">
		<div class="col-lg-11 col-md-6 ">
  <h1>최고 디자이너들의 갤러리 목록</h1>
  <p>고객이 가장 많이 좋아요를 누른 디자이너의 Photo list입니다.</p>
		</div>
		</div>
	</div>
</section>

<div class="container-fluid">
	<div class="row gallery-sub">
		<div class="block" id="blue">
	<select>
		<option value="value1" selected>해시태그</option> 
		<option value="value2">ID</option>
	</select>
	</div>
			<div class="search-insta">
	<input type="text" name="name" placeholder="Search"
		onfocus="this.placeholder = ''" onblur="this.placeholder = 'Search'"
		required class="single-input-secondary-sub">
	</div>
			<div class="search-btn">
				<a href="#" class="genric-btn info circle arrow">검색<span
					class="lnr lnr-arrow-right"></span></a>
			</div>
</div>
</div>
    <script  src="js/selectscroll.js"></script>

<!-- Start Condition Area -->

<section class="home-banner-area relative banner-area">
	<div class="container-fluid">
		<div class="row  d-flex align-items-center justify-content-center">
			<div class="col-lg-11 col-md-6 ">
			<div id='content'>
			
			</div>
				
			</div>
		</div>
	</div>
</section>
	<script src="js/vendor/jquery-2.2.4.min.js"></script>
<!-- End Condition Area -->
	
	<script  src="js/index.js"></script>

	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>