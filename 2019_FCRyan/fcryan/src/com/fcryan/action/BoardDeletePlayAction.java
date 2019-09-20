package com.fcryan.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fcryan.common.Constants;
import com.fcryan.dao.BoardDAO;
import com.fcryan.dao.ReplyDAO;
import com.fcryan.dto.BoardDTO;

public class BoardDeletePlayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "boardList.bizpoll";
		
		String bno = request.getParameter("bno");
		System.out.println("===> " + bno);

		// 댓글 삭제
		ReplyDAO rDao = ReplyDAO.getInstance();
		rDao.replyDeleteAll(bno);
		
		
		// 첨부파일 삭제		
		String filename = request.getParameter("filename");
		if(!filename.equals("-")) {
			File file = new File(Constants.UPLOAD_PATH + filename);
			file.delete();
		}
		
		
		// 게시글 삭제
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.boardDelete(bno);
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		
		return forward;
	}

}
