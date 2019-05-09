package kr.or.bit.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnADao;
import kr.or.bit.dto.QnADto;

public class QnAinsertservice implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		String userID = request.getParameter("userid");
		String boardSubject = request.getParameter("boardsubject"); 
		String boardContent = request.getParameter("boardcontent");
		String fileName = request.getParameter("filename");
		
//		
//		String uploadpath = request.getSession().getServletContext().getRealPath("upload");
//		System.out.println("uploadpath  " + uploadpath);
//		
//		int size = 1024*1024*10;	//10M 네이버 계산기
//		MultipartRequest multi;		
//		
//		
//				
//		
		
		
		int result = 0;
		System.out.println("service 받아온 값을 봅시다.");
		System.out.println("userid : " + userID);
		System.out.println("subject : " + boardSubject);
		System.out.println("content : " + boardContent);
		System.out.println("filename : " + fileName);
		
		
		try {
			request.setCharacterEncoding("UTF-8");	
			
			QnADto qna = new QnADto();
			
			qna.setUserID(userID);
			qna.setBoardSubject(boardSubject);
			qna.setBoardContent(boardContent);
			qna.setFileName(fileName);
			
			
			System.out.println(qna.toString());
			
			QnADao dao = new QnADao();
			result = dao.insertQnA(qna);

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
