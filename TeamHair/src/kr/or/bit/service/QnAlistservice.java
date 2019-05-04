package kr.or.bit.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnADao;
import kr.or.bit.dto.QnA;

public class QnAlistservice implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		String board_name = request.getParameter("board_name");
		String board_title = request.getParameter("board_title"); 
		

		int result = 0;
		System.out.println("service 받아온 값을 봅시다.");
		System.out.println("name : " + board_name);
		System.out.println("name : " + board_title);

		
		
		try {
			request.setCharacterEncoding("UTF-8");
			QnA qna = new QnA();
			
			qna.setBoard_name(board_name);
			qna.setBoard_title(board_title);

			
			System.out.println(qna.toString());
			
			if (result > 0) {
				System.out.println("등록성공");
			} else { // -1 (제약, 컬럼길이 문제)
				System.out.println("등록실패");
			}
			

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/QnA/QnA.jsp"); //리스트

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}
