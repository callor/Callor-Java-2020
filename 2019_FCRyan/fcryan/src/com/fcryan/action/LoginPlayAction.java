package com.fcryan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.fcryan.dao.MemberDAO;
import com.fcryan.dto.MemberDTO;

public class LoginPlayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
//		System.out.println(id + ", " + pw);
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto = mDao.loginCheck(id, pw);
		
		String message = null;
		
		if(mDto != null) { // 로그인 성공
			// session값에 login된 회원 정보를 담아야함
			session.removeAttribute("id"); // 혹시모를 기존에 남아있는 값을 제거
			// session은 DTO 객체로 값 받기, List는 안됌!
			session.setAttribute("loginUser", mDto);
			message = "1";
		} else { // 로그인 실패
			message = "-1";
		}
//		String referer = request.getHeader("referer");
//		System.out.println("이전 URL: " + referer);
		
		JSONObject jObj = new JSONObject();
		jObj.put("message", message);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		return null;
	}

}
