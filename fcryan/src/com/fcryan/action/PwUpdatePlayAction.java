package com.fcryan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fcryan.dao.MemberDAO;

public class PwUpdatePlayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		
		// 변경할 비밀번호
		String id = request.getParameter("updateId");
		String pw = request.getParameter("inputpw");
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.updatePw(id, pw);
		
		if(result > 0) { // pw수정 성공
			url = "index.bizpoll";
		} else { // pw수정 실패
			url = "memberPw.bizpoll";
		}
		
		
		// 값을 못받아온다!!!
		// 1. getParameter("") 매개변수가 name값으로 설정돼있는지 확인한다.
		// 2. 현재 Action단으로 이동하는지 체크!
		//    - console창에 *.bizpoll이 출력되는지 확인
		//      가) 안탐
		//         : 화면단으로 가서 form태그에 action 속성값, submit() 등을 확인
		//      나) 간다
		// 
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
