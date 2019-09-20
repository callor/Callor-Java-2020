package com.fcryan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.fcryan.dao.MemberDAO;

public class PwCheckAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id: " + id);
		System.out.println("pw: " + pw);
		
		MemberDAO mDao = MemberDAO.getInstance();
		String message = mDao.confirmPW(id, pw);
		
		System.out.println("msg: " + message);
		JSONObject jObj = new JSONObject();
		jObj.put("message", message);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		
		// DB에서 pw값 가지고 와서 비교
		// SELECT pw FROM member
		// WHERE id = ?;
		
		// id값을 구하는 방법 2가지(Session)
		// 1. Controller단에서 Session객체 호출해서 ID값 빼오는 방법
		// 2. View단에서 Session에 담겨있는 ID값을 PW값과 함께 보내는 방법
		
		
		return null;
	}
}






