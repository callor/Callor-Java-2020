package com.fcryan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fcryan.dao.MemberDAO;
import com.fcryan.dto.MemberDTO;

public class MemberUpdatePlayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		HttpSession session = request.getSession();
		
		// view단에서 전송한 데이터를 받아오세요.
		String id = request.getParameter("inputid");
		String name = request.getParameter("inputname");
		String phone = request.getParameter("inputphone");
		String email_id = request.getParameter("email_id");
		String email_url = request.getParameter("email_url");
		String email = email_id + "@" + email_url;
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		MemberDTO mDto = new MemberDTO(id, name, phone, email, zipcode, addr1, addr2);
		System.out.println(mDto.toString());
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.updateMember(mDto);
		
		if(result > 0) { // 성공
			url = "index.bizpoll";
			
			// session값을 최신정보로 수정!!!
			session.removeAttribute("id");
			session.setAttribute("loginUser", mDto);
			// 최신 회원 정보
			// DB로가서 SELECT 최신 회원정보
		} else { // 실패
			url = "memberUpdate.bizpoll";
		} 
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		
		return forward;
	}

}
