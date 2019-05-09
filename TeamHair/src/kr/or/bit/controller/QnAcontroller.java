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
import kr.or.bit.service.QnAcommentsinsertservice;
import kr.or.bit.service.QnAdeleteservice;
import kr.or.bit.service.QnAdetailservice;
import kr.or.bit.service.QnAinsertservice;
import kr.or.bit.service.QnAlistservice;
import kr.or.bit.service.QnAupdateFormservice;
import kr.or.bit.service.QnAupdateservice;

@WebServlet("*.do")
public class QnAcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QnAcontroller() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doProcess 실행");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url_Command = requestURI.substring(contextPath.length());

		Action action = null;
		ActionForward forward = new ActionForward();

		if (url_Command.equals("/QnA.do")) { // QnA메인 이동
			System.out.println("QnA.do 들어옴");
			try {
				action = new QnAlistservice();
				forward = action.execute(request, response);
				System.out.println("QnA.do ... try문 완료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/QnAwrite.do")) { // QnA 글쓰기페이지 이동
			System.out.println("QnAwrite.do 들어옴");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/QnA/QnAwrite.jsp");
		} else if (url_Command.equals("/QnAinsert.do")) { // QnA 데이터 추가하기
			System.out.println("QnAinsert.do 들어옴");
			try {
				action = new QnAinsertservice();
				forward = action.execute(request, response);
				System.out.println("QnAinsert.do ... try문 완료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/QnAdetail.do")) { // QnA 글 상세보기
			try {
				System.out.println("/QnAdetail.do 요청");
				action = new QnAdetailservice();
				forward = action.execute(request, response);
				System.out.println("QnAdetail.do ... try문 완료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/QnAdelete.do")) { // QnA 데이터 삭제
			System.out.println("QnAdelete.do 들어옴");
			try {
				action = new QnAdeleteservice();
				forward = action.execute(request, response);
				System.out.println("QnAdelete.do ... try문 완료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/QnAupdateform.do")) { // QnA 데이터 수정 페이지 이동
			System.out.println("QnAupdateform.do 들어옴");
			action = new QnAupdateFormservice();
			forward = action.execute(request, response);
		} else if (url_Command.equals("/QnAupdate.do")) { // QnA 데이터 수정
			System.out.println("QnAupdate.do 들어옴");
			try {
				action = new QnAupdateservice();
				forward = action.execute(request, response);
				System.out.println("QnAupdate.do ... try문 완료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/QnAcommentsinsert.do")) { // QnA 댓글 추가하기
			System.out.println("QnAcommentsinsert.do 들어옴");
			try {
				action = new QnAcommentsinsertservice();
				forward = action.execute(request, response);
				System.out.println("QnAinsert.do ... try문 완료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

		if (forward != null) {
			if (forward.isRedirect()) { // true
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}

}
