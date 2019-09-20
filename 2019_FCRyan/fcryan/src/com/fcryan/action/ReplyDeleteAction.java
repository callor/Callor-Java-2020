package com.fcryan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fcryan.dao.BoardDAO;
import com.fcryan.dao.ReplyDAO;

public class ReplyDeleteAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String rno = request.getParameter("rno");
		String bno = request.getParameter("bno");
		
		
		// 댓글 삭제
		ReplyDAO rDao = ReplyDAO.getInstance();
		rDao.replyDelete(rno);
		 
		
		// 게시판 테이블 replycnt - 1
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.boardReplyCntMinus(bno);
		
		return null;
	}

}
