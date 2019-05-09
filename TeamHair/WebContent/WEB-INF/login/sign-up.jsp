<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


	<!-- Header Include Start -->
	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
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
                        <form action="SignUpOk.usr" method="POST" class="register-form" id="register-form">
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
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="name" id="name" placeholder="이름"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="email" name="email" id="email" placeholder="E-mail"/>
                            </div>
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="phone" id="phone" placeholder="핸드폰번호"/>
                            </div>
                                                        
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="introduction" id="introduction" placeholder="자기소개"/>
                            </div>
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="website" id="website" placeholder="홈페이지"/>
                            </div>
                            
                            
                            <div class="form-group">
                                <label for="gender"><i class="zmdi zmdi-account material-icons-name"></i></label>
							    <select class="form-control form-control-lg" id="gender" name="gender">
							      <option value="M">MALE</option>
							      <option value="F" selected>FEMALE</option>
							    </select>
							</div>

                            <div class="form-group">
                                <label for="usertype"><i class="zmdi zmdi-account material-icons-name"></i></label>
							    <select class="form-control form-control-lg" id="usertype" name="usertype">
							      <option value="U" selected>User</option>
							      <option value="H">Hair Designer</option>
							      <option value="M">Administrator</option>
							    </select>
							</div>
                                        
                            <div class="form-group">
                                <div class="checkbox-sub">
								<div class="primary-checkbox">
									<input type="checkbox" id="termsOfUseYn" name="termsOfUseYn">
									<label for="termsOfUseYn"></label>
                                </div>
                                <label for="agree-term" class="label-agree-term"><span><span></span></span><a href="#" class="term-service">이용약관</a>에 동의합니다.</a></label>
							</div>
                            
                            <div class="form-group">
                                <div class="checkbox-sub">
								<div class="primary-checkbox">
									<input type="checkbox" id="loginYn" name="loginYn">
									<label for="loginYn"></label>
                                </div>
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>로그인상태 유지</a></label>
								</div>
                            </div>
                            
                            <!--  SNS 사용여부는 profile 수정하기에만 삽입 -->
						<!-- 
                            <div class="form-group">
                                <div class="checkbox-sub">
								<div class="primary-checkbox">
									<input type="checkbox" id="useSnsYn" name="useSnsYn">
									<label for="useSnsYn"></label>
                                </div>
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>SNS사용 여부</a></label>
								</div>
                            </div>
                        -->     
							<!--  헤어샵 가능여부는 profile 수정하기에만 삽입 -->
						<!-- 
                            <div class="form-group">
                                <div class="checkbox-sub">
								<div class="primary-checkbox">
									<input type="checkbox" id="reserveYn" name="reserveYn">
									<label for="reserveYn"></label>
                                </div>
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>헤어샵 예약가능 여부</a></label>
								</div>
                            </div>
                         -->    
                                
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
    
 	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>