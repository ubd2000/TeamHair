<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<!-- Header Include Start -->
	<jsp:include page="common/header.jsp"></jsp:include>
			<link rel="stylesheet" href="css/member.css">
			
	<!-- Header Include End -->
	
<body>
	  
<!-- Sign In form -->

<section class="condition-area event-details-area section-gap">
    	<div class="container">
    	<div class="row">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="img/login.jpg" alt="sing up image"></figure>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Log-in</h2>
                        <form method="POST" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="your_name" id="your_name" placeholder="아이디"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="your_pass" id="your_pass" placeholder="비밀번호"/>
                            </div>
                            <div class="form-group">
                            <div class="checkbox-sub">
								<div class="primary-checkbox">
									<input type="checkbox" id="default-checkbox">
									<label for="default-checkbox"></label>
                                </div>
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>로그인상태 유지</label>
								</div>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                            </div>
                        </form>
                        <a href="sign-up.jsp" class="signup-image-link">새로운 계정 생성</a>
                    </div>
                </div>
                </div>
                </div>
	</section>
    
 	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>