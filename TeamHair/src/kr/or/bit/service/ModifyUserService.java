package kr.or.bit.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.CodeDao;
import kr.or.bit.dao.ProfileDao;
import kr.or.bit.dao.UsersDao;
import kr.or.bit.dto.CodeDto;
import kr.or.bit.dto.ProfileDto;
import kr.or.bit.dto.UsersDto;

public class ModifyUserService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		try {
			

			HttpSession session = request.getSession();
			
			UsersDto useridDto = (UsersDto)session.getAttribute("usersdto");
			// update후 갱신 필요
			UsersDao usersDao = new UsersDao();
			UsersDto usersDto = usersDao.getUserbyId(useridDto.getUserId());
			request.setAttribute("usersdto", usersDto);
			
			ProfileDao profileDao = new ProfileDao();
			ProfileDto profileDto = profileDao.getProfilebyId(useridDto.getUserId());
			request.setAttribute("profiledto", profileDto);
			
			CodeDao codeDao = new CodeDao();
			List<CodeDto> codeDtoList = new ArrayList<CodeDto>(); 
			codeDtoList = codeDao.getCodeListById("U100");
			request.setAttribute("codedtolist", codeDtoList);
			
			
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/login/modifyuserinfo.jsp");
			
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return forward;
	}


}
