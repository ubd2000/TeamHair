<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="img/hairlogo.png">
	<!-- Author Meta -->
	<meta name="author" content="codepixer">
	<!-- Meta Description -->
	<meta name="description" conte8nt="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>Dream Hair Shop</title>

	<link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900|Roboto:300,400,500,700" rel="stylesheet">
	<!--
			CSS
			============================================= -->
	<link rel="stylesheet" href="css/linearicons.css?ver=1">
	<link rel="stylesheet" href="css/font-awesome.min.css?ver=1">
	<link rel="stylesheet" href="css/bootstrap.css?ver=1">
	<link rel="stylesheet" href="css/magnific-popup.css?ver=1">
	<link rel="stylesheet" href="css/nice-select.css?ver=1">
	<link rel="stylesheet" href="css/animate.min.css?ver=1">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="css/owl.carousel.css?ver=1">
	<link rel="stylesheet" href="css/main.css?ver=1">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
	<link rel="stylesheet" href="css/instagram.css">
	
	<link rel="stylesheet" href="css/contentpopup.css">
    <link rel="stylesheet" href="css/modify.css">
</head>

<body>

	<!-- Start Header Area -->
	<header id="header">
		<div class="container">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="index.jsp"><img src="img/hairlogo.png" alt="" title="" /></a>
				</div>
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li class="menu-active"><a href="index.jsp">Home</a></li>
						<li class="menu-active"><a href="seouloffice.jsp">지점</a></li>
						<li class="menu-has-children"><a href="">Blog</a>
							<ul class="slide-menu">
								<li><a href="hairgallery.jsp">Insta Gallery</a></li>
								<li><a href="instragram.jsp">인스타헤어그램 테스트</a></li>
							</ul>
						</li>
						<li class="menu-active"><a href="#">질문게시판</a></li>
						
						<c:choose>
							<c:when test="${sessionScope.usersdto.userId!=null}">
								<li class="menu-has-children"><a href="">User</a>
									<ul class="slide-menu">
										<li class="menu-active"><a href="Logout.usr">${sessionScope.usersdto.userId} Logout</a></li>
										<li class="menu-active"><a href="Modify.usr"> Edit Profile </a></li>
									</ul>
								</li>
							</c:when>
							<c:otherwise>
								<li class="menu-active"><a href="Login.usr">Log-in</a></li>
								<li class="menu-active"><a href="SignUp.usr">sign-up</a></li>
							</c:otherwise>
						</c:choose>
						
						
						
						<c:if test="${sessionScope.usersdto.userId!=null}">
	
						</c:if>
						
					</ul>
				</nav><!-- #nav-menu-container -->
			</div>
		</div>
	</header>
	
	<!-- Start Header Area -->