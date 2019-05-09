package kr.or.bit.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.UsersDao;
import kr.or.bit.dto.UsersDto;

public class LoginOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		try {
			
			
			String id = request.getParameter("userid");
			String pwd = request.getParameter("pwd");

			UsersDto dto = null;
			UsersDao dao = new UsersDao();
			
			dto = dao.getUserbyId(id);
			
			
			if(dto.getUserId() != null) { // 회원인 경우
				if(pwd.equalsIgnoreCase(dto.getPasswords())) { // 비밀번호가 맞는 경우
					
					HttpSession session = request.getSession(); // servlet마다
					session.setAttribute("usersdto", dto);
					forward.setRedirect(true);
					forward.setPath("index.jsp");
					
				} else { // 비밀번호가 틀린 경우
					System.out.println("비밀번호가 틀린 경우");
					
					forward.setRedirect(false);
					forward.setPath("/WEB-INF/login/log-in.jsp");	
					
				}
			} else { // 회원이 아닌 경우
				System.out.println("회원이 아닌 경우");
				
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/login/sign-up.jsp");
			}
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return forward;
	}
}
