<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


	<!-- Header Include Start -->
	<jsp:include page="common/header.jsp"></jsp:include>
			<link rel="stylesheet" href="css/member.css">
	<!-- Header Include End -->


<body>
	  
<!-- Sign up form -->
        <section class="condition-area event-details-area section-gap">
    	<div class="container">
    	<div class="row">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form method="POST" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="name" id="name" placeholder="이름"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="text" name="id" id="id" placeholder="아이디"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="pass" id="pass" placeholder="비밀번호"/>
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="re_pass" id="re_pass" placeholder="비밀번호 확인"/>
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-code"></i></label>
                                <input type="password" name="re_pass" id="re_pass" placeholder="디자이너 전용코드"/>
                            </div>
                            <div class="form-group">
                                <div class="checkbox-sub">
								<div class="primary-checkbox">
									<input type="checkbox" id="default-checkbox">
									<label for="default-checkbox"></label>
                                </div>
                                <label for="agree-term" class="label-agree-term"><span><span></span></span><a href="#" class="term-service">이용약관</a>에 동의합니다.</a></label>
								</div>
                                
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="img/signup.jpg" alt="sing up image"></figure>
                        <a href="log-in.jsp" class="signup-image-link">이미 회원이신가요?</a>
                    </div>
                </div>
                </div>
                </div>
</section>
    
 	<jsp:include page="common/footer.jsp"></jsp:include>