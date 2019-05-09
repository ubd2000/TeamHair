package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnADao;

public class QnAdeleteservice implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		int boardid = Integer.parseInt(request.getParameter("boardid"));
		
		int result = 0;
		int result2 = 0;
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			QnADao dao = new QnADao();
			result = dao.deleteQnA(boardid);
			result2 = dao.deleteQnAComments(boardid);
			
			if (result > 0) {
				System.out.println("글 삭제 성공");
			} else { // -1 (제약, 컬럼길이 문제)
				System.out.println("글 삭제 실패");
			}
			
			if (result2 > 0) {
				System.out.println("댓글 등록 성공");
			} else { // -1 (제약, 컬럼길이 문제)
				System.out.println("댓글 등록 실패");
			}
			

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/QnA.do"); //리스트

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}
