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
import kr.or.bit.service.QnAinsertservice;
import kr.or.bit.service.QnAlistservice;

@WebServlet("*.do")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public controller() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doProcess 실행");
		String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
	
    	Action action = null;
    	ActionForward forward = new ActionForward(); 
    	
    	if(url_Command.equals("/QnA.do")) { //QnA메인 이동
    		System.out.println("QnA.do 들어옴");
    		try {
    			action = new QnAlistservice();
    			forward = action.execute(request, response);
    			System.out.println("QnA.do ... try문 완료");
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(url_Command.equals("/QnAwrite.do")) { //QnA 글쓰기페이지 이동
    		System.out.println("QnAwrite.do 들어옴");
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/QnA/QnAwrite.jsp");
    	}else if(url_Command.equals("/QnAinsert.do")) { //QnA 데이터 추가하기
    		System.out.println("QnAinsert.do 들어옴");
    		try {
    			action = new QnAinsertservice();
    			forward = action.execute(request, response);
    			System.out.println("QnAinsert.do ... try문 완료");
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}

    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true
    			response.sendRedirect(forward.getPath());
    		}else {
    			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
    }

}
