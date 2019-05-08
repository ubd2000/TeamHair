package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

public class LogOutService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		try {
			HttpSession session = request.getSession(); // servlet마다
			session.invalidate();
			
			System.out.println("LogOutService");
			
			forward.setRedirect(true);
			forward.setPath("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
