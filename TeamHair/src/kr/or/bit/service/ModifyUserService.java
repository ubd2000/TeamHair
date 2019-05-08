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

public class ModifyUserService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		try {
			

			HttpSession session = request.getSession();
			
			UsersDto userDto = (UsersDto)session.getAttribute("usersdto");
			
			ProfileDao profileDao = new ProfileDao();
			ProfileDto profileDto = profileDao.getProfilebyId(userDto.getUserId());
			session.setAttribute("profiledto", profileDto);
			
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/login/modifyuserinfo.jsp");
			
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return forward;
	}


}
