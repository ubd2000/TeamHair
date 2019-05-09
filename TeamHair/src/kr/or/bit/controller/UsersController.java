package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.ChangePwdOkService;
import kr.or.bit.service.LogOutService;
import kr.or.bit.service.LoginOkService;
import kr.or.bit.service.ModifyUserOkService;
import kr.or.bit.service.ModifyUserService;
import kr.or.bit.service.SignUpOkService;

@WebServlet("*.usr")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsersController() {
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlCommand = requestURI.substring(contextPath.length());
	
    	Action action = null;
    	ActionForward forward = new ActionForward(); 
    	
    	if(urlCommand.equals("/Login.usr")) { // 로그인
    		try {
    			System.out.println("/Login.usr");
    			forward.setRedirect(false);
    			forward.setPath("/WEB-INF/login/log-in.jsp");
			}catch(Exception e) {
					e.printStackTrace();
			}
    	} else if(urlCommand.equals("/LoginOk.usr")) { // 로그인 OK
    		try {
    			action = new LoginOkService();
    			forward = action.execute(request, response);
			}catch(Exception e) {
					e.printStackTrace();
			}
    	}  else if(urlCommand.equals("/Logout.usr")) { // 로그아웃
    		try {
    			System.out.println("LogOutService 호출");
    			action = new LogOutService();
    			forward = action.execute(request, response);
			}catch(Exception e) {
					e.printStackTrace();
			}
    	}  else if(urlCommand.equals("/SignUp.usr")) { // 회원등록
    		try {
    			forward.setRedirect(false);
    			forward.setPath("/WEB-INF/login/sign-up.jsp");
			}catch(Exception e) {
					e.printStackTrace();
			}
    	}   else if(urlCommand.equals("/SignUpOk.usr")) { // 회원등록
    		try {
    			System.out.println("SignUpOkService 호출");
    			action = new SignUpOkService();
    			forward = action.execute(request, response);
			}catch(Exception e) {
					e.printStackTrace();
			}
    	}   else if(urlCommand.equals("/Modify.usr")) { // 회원정보 수정
    		try {
    			System.out.println("ModifyUserService 호출");
    			action = new ModifyUserService();
    			forward = action.execute(request, response);

			}catch(Exception e) {
					e.printStackTrace();
			}
    	}   else if(urlCommand.equals("/ModifyUserOk.usr")) { // 회원정보 수정
    		try {
    			System.out.println("ModifyUserOkService 호출");
    			action = new ModifyUserOkService();
    			forward = action.execute(request, response);
			}catch(Exception e) {
					e.printStackTrace();
			}
    	}   else if(urlCommand.equals("/ChangePwd.usr")) { // 비밀번호 변경이동
    		try {
    			System.out.println("/ChangePwd.usr");
    			forward.setRedirect(false);
    			forward.setPath("/WEB-INF/login/changepwd.jsp");
			}catch(Exception e) {
					e.printStackTrace();
			}
    	}  else if(urlCommand.equals("/ChangePwdOk.usr")) { // 비밀번호 변경
    		try {
    			System.out.println("ChangePwdOkService 호출");
    			action = new ChangePwdOkService();
    			forward = action.execute(request, response);
			}catch(Exception e) {
					e.printStackTrace();
			}
    	}
    	
    	
//    	
//    	
//    	 else if(urlCommand.equals("/FileUpload.do")) {  // 화일 업로드
//    		try {
//    			System.out.println("/FileUpload.do 요청");
//    			action = new FileUploadService(); 
//    			forward = action.execute(request, response);
//    			
//
//			}catch(Exception e) {
//					e.printStackTrace();
//			}
//    	} else if(urlCommand.equals("/ViewFile.do")) {  // 화일 업로드
//    		try {
//    			System.out.println("/ViewFile.do 요청");
//    			action = new ViewFileService(); 
//    			forward = action.execute(request, response);
//    			
//
//			}catch(Exception e) {
//					e.printStackTrace();
//			}
//    	}
    	
    	
    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true
    			response.sendRedirect(forward.getPath());
    		}else {
    			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
