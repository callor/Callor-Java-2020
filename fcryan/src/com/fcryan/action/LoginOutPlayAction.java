package com.fcryan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOutPlayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// session을 가져옴
		HttpSession session = request.getSession();
		
		if(session != null) {
			// session을 초기화 => 로그인 정보 삭제
			session.invalidate();
		}
		String referer = request.getHeader("referer");
		
		String url = referer;
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		
		return forward;
	}

}





