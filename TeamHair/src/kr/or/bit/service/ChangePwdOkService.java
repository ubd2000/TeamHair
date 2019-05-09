package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ProfileDao;
import kr.or.bit.dao.UsersDao;
import kr.or.bit.dto.ProfileDto;
import kr.or.bit.dto.UsersDto;
import kr.or.bit.utils.TeamConvert;

public class ChangePwdOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = new ActionForward();

		try {

			HttpSession session = request.getSession();

			UsersDto usersDto = (UsersDto) session.getAttribute("usersdto");
			String id = usersDto.getUserId();
			String oldpwd = usersDto.getPasswords();

			String nowpwd = request.getParameter("nowpwd");
			String newpwd = request.getParameter("newpwd");
			String newpwd2 = request.getParameter("newpwd2");
			
			if (nowpwd != null) {
				if (oldpwd.trim().equals(nowpwd.trim()) && !oldpwd.trim().equals(newpwd.trim())) {
					UsersDao userDao = new UsersDao();
					userDao.changePassword(id, newpwd);

					// session의 pwd도 갱신
					usersDto.setPasswords(newpwd);
					session.removeAttribute("usersdto");
					session.setAttribute("usersdto", usersDto);
					
					forward.setRedirect(false);
					forward.setPath("index.jsp");
				} else {
					forward.setRedirect(false);
					forward.setPath("ChangePwd.usr");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
