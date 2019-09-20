package com.fcryan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fcryan.dao.BoardDAO;

public class BoardViewcntAction implements Action{
	
	// 게시글 조회수 증가
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bno = request.getParameter("bno");
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		// 조회수 1증가
		// Session을 활용한 조회수 증가 방지
		HttpSession session = request.getSession();
		bDao.viewCnt(bno, session);
		
		String url = "boardDetail.bizpoll?bno=" + bno;
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
