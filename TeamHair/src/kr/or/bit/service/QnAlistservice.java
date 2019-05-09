package kr.or.bit.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnADao;
import kr.or.bit.dto.QnADto;

public class QnAlistservice implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;		
		
		try {
  		  	QnADao qnadao = new QnADao();
  		  	List<QnADto> qnalist = qnadao.QnAlist();
  		 
  		  	request.setAttribute("qnalist",qnalist);
  		  	
  		  	System.out.println("list서비스 리스트 목록 : " + qnalist);
  		  	
  		  	 forward = new ActionForward();
  			 forward.setRedirect(false); //forward 방식
  			 forward.setPath("/WEB-INF/QnA/QnA.jsp");

		  	}catch(Exception e){
		  		System.out.println(e.getMessage());
		  	}

		return forward;
	}

}
