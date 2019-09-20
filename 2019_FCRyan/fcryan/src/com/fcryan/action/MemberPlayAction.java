package com.fcryan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fcryan.dao.MemberDAO;
import com.fcryan.dto.MemberDTO;

public class MemberPlayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 페이지 이동 기능 X
		String url = "welcome_join.jsp";
		
		// view단에서 전송한 데이터를 받아오세요.
		String id = request.getParameter("inputid");
		String pw = request.getParameter("inputpw");
		String name = request.getParameter("inputname");
		String phone = request.getParameter("inputphone");
		String email_id = request.getParameter("email_id");
		String email_url = request.getParameter("email_url");
		String email = email_id + "@" + email_url;
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		MemberDTO mDto = new MemberDTO(id, pw, name, phone, email, zipcode, addr1, addr2);
		
		
		// 싱글톤 패턴
		// 객체생성은 한번만이루이지고
		// 나머지는 생성된 객체를 빌려 쓰는 형태로 작성됨
		
		MemberDAO mDao = MemberDAO.getInstance();

		// MemberDAO 클래스의 insertMember() 메서드를
		// 호출하고 View단에서 전달한 데이터를 mDto에 담아
		// 보낸다
		int result = mDao.insertMember(mDto);
		
		if(result > 0) { // 회원가입 성공
			
		} else {  // 회원가입 실패
			url = "memberaction.bizpoll";
		}
		
		// ActionForward 객체생성
		// forward 인스턴스 생성
		ActionForward forward = new ActionForward();
		
		// ActioForward 클래스의 setPath()메서드를
		// 호출하고 url값을 매개변수로 전달
		forward.setPath(url);
		
		// ActionForward 클래스의 setRedirect() 메서드를
		// 호출하고 true라고 하는 boolean값을 매개변수로 전달
		forward.setRedirect(true);
		
		return forward;
	}

}
