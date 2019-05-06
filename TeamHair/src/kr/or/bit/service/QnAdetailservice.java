package kr.or.bit.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnADao;
import kr.or.bit.dto.QnA;

public class QnAdetailservice implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;		
		
		try {
			//일단 제목으로 받았음.. num으로 변경해야함
			String title = request.getParameter("board_title");
			
  		  	QnADao qnadao = new QnADao();
  		  	QnA q = qnadao.searchQnA(title);
  		  	
  		  	request.setAttribute("detail",q);
		  		  
  		  	System.out.println("servicce 디테일 q의 값 : " + q);
  		  	
  		  	forward = new ActionForward();
  			forward.setRedirect(false); //forward 방식
  			forward.setPath("/WEB-INF/QnA/QnAdetail.jsp");

		  	}catch(Exception e){
		  		System.out.println(e.getMessage());
		  	}

		return forward;
	}

}
