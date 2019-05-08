package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnADao;
import kr.or.bit.dto.QnADto;

public class QnAupdateservice implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		System.out.println("업데이트 서비스 시작");
		
		int boardID = Integer.parseInt(request.getParameter("boardid"));
		String boardName = request.getParameter("boardname");
		String boardSubject = request.getParameter("boardsubject"); 
		String boardContent = request.getParameter("boardcontent");
		String fileName = request.getParameter("filename");
		
		int result = 0;
		System.out.println("업데이트service 받아온 값을 봅시다.");
		System.out.println("boardid : " + boardID);
		System.out.println("name : " + boardName);
		System.out.println("subject : " + boardSubject);
		System.out.println("content : " + boardContent);
		System.out.println("filename : " + fileName);
		
		
		try {
			request.setCharacterEncoding("UTF-8");
			QnADto qna = new QnADto();
			
			qna.setBoardID(boardID);
			qna.setBoardName(boardName);
			qna.setBoardSubject(boardSubject);
			qna.setBoardContent(boardContent);
			qna.setFileName(fileName);
			
			System.out.println(qna.toString());
			
			QnADao dao = new QnADao();
			result = dao.updateQnA(qna);

			if (result > 0) {
				System.out.println("등록성공");
			} else { // -1 (제약, 컬럼길이 문제)
				System.out.println("등록실패");
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
