package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnADao;
import kr.or.bit.dto.QnADto;

public class QnAupdateFormservice implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		QnADao qnadao = null;
		QnADto qna = null;
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			qnadao = new QnADao();
			qna= new QnADto();
			
			
			qna = qnadao.searchQnA(Integer.parseInt(request.getParameter("boardID")));
			request.setAttribute("qna", qna);
			
			forward = new ActionForward();
			forward.setRedirect(false); // forward 방식
			forward.setPath("/WEB-INF/QnA/QnAUpdate.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}
//		ActionForward forward = null;
//		
//		int boardID = Integer.parseInt(request.getParameter("boardID"));
//		String boardName = request.getParameter("boardname");
//		String boardSubject = request.getParameter("boardsubject"); 
//		String boardContent = request.getParameter("boardcontent");
//		String fileName = request.getParameter("filename");
//		
//		int result = 0;
//		System.out.println("service 받아온 값");
//		System.out.println("boardid : " + boardID);
//		System.out.println("name : " + boardName);
//		System.out.println("subject : " + boardSubject);
//		System.out.println("content : " + boardContent);
//		System.out.println("filename : " + fileName);
//		
//		
//		try {
//			request.setCharacterEncoding("UTF-8");
//			QnADto qna = new QnADto();
//			
//			qna.setBoardID(boardID);
//			qna.setBoardName(boardName);
//			qna.setBoardSubject(boardSubject);
//			qna.setBoardContent(boardContent);
//			qna.setFileName(fileName);
//
//			
//			System.out.println(qna.toString());
//			
//			QnADao dao = new QnADao();
//			result = dao.updateQnA(qna);
//
//			if (result > 0) {
//				System.out.println("등록성공");
//			} else { // -1 (제약, 컬럼길이 문제)
//				System.out.println("등록실패");
//			}
//			
//
//			forward = new ActionForward();
//			forward.setRedirect(false);
//			forward.setPath("/QnA.do"); //리스트
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return forward;

}
