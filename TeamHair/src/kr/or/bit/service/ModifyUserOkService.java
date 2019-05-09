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

public class ModifyUserOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		
		try {
			
			HttpSession session = request.getSession();
			
			UsersDto usersDto = (UsersDto)session.getAttribute("usersdto");

			String id = usersDto.getUserId();


			String pwd = request.getParameter("pass");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String introduction = request.getParameter("introduction");
			String website = request.getParameter("website");
			String gender = request.getParameter("gender");
			
			String usertype = request.getParameter("usertype");
			String loginYn = request.getParameter("loginYn");
			String reserveYn = request.getParameter("reserveYn");
			String useSnsYn = request.getParameter("useSnsYn");
			
//			System.out.println("id : " + id);
//			System.out.println("pwd : " + pwd);
//			System.out.println("name : " + name);
//			System.out.println("email : " + email);
//			System.out.println("phone : " + phone);
//			System.out.println("introduction : " + introduction);
//			System.out.println("website : " + website);
//			System.out.println("gender : " + gender);
//
//			System.out.println("usertype : " + usertype);
//
//			System.out.println("loginYn : " + loginYn);
//			System.out.println("loginYn : " + TeamConvert.checkToYn(loginYn));



			UsersDto userDto = new UsersDto();
			
			userDto.setUserId(id);
			userDto.setPasswords(pwd);
			userDto.setUserName(name);
			userDto.setEmail(email);
			userDto.setPhone(phone);
			userDto.setGender(gender);;
			userDto.setUserType(usertype.trim());
			userDto.setLoginYn(TeamConvert.checkToYn(loginYn));
			userDto.setReserveYn(TeamConvert.checkToYn(reserveYn));
			userDto.setUseSnsYn(TeamConvert.checkToYn(useSnsYn));
				
			
			UsersDao userDao = new UsersDao();
			userDao.updateUsers(userDto);
			
			
			ProfileDto profileDto = new ProfileDto();
			
			profileDto.setUserId(id);
			profileDto.setIntroduction(introduction);
			profileDto.setWebsite(website);
			
			ProfileDao profileDao = new ProfileDao();
			profileDao.updateProfile(profileDto);
			
			forward.setRedirect(false);
			forward.setPath("index.jsp");
			
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return forward;
	}
}
