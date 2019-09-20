package com.fcryan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PwUpdateAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "pw_update.jsp";
		
		HttpSession session = request.getSession(); // session 값 취득
		if(session.getAttribute("loginUser") == null) { // 로그인 NO
			url = "index.bizpoll";
		} else {  // 로그인 OK
			url= "pw_update.jsp";
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
