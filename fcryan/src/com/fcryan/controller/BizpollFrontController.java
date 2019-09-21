package com.fcryan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fcryan.action.Action;
import com.fcryan.action.ActionForward;
import com.fcryan.action.BoardDeletePlayAction;
import com.fcryan.action.BoardDetailAction;
import com.fcryan.action.BoardDownloadAction;
import com.fcryan.action.BoardInsertAction;
import com.fcryan.action.BoardInsertPlayAction;
import com.fcryan.action.BoardListAction;
import com.fcryan.action.BoardUpdateAction;
import com.fcryan.action.BoardUpdatePlayAction;
import com.fcryan.action.BoardViewcntAction;
import com.fcryan.action.CommentListAction;
import com.fcryan.action.ConstractAction;
import com.fcryan.action.IdCheckAction;
import com.fcryan.action.IndexAction;
import com.fcryan.action.LoginAction;
import com.fcryan.action.LoginOutPlayAction;
import com.fcryan.action.LoginPlayAction;
import com.fcryan.action.MemberAction;
import com.fcryan.action.MemberDeleteAction;
import com.fcryan.action.MemberDeletePlayAction;
import com.fcryan.action.MemberPlayAction;
import com.fcryan.action.MemberUpdateAction;
import com.fcryan.action.MemberUpdatePlayAction;
import com.fcryan.action.PwCheckAction;
import com.fcryan.action.PwUpdateAction;
import com.fcryan.action.PwUpdatePlayAction;
import com.fcryan.action.ReplyDeleteAction;
import com.fcryan.action.ReplyInsertAction;
import com.fcryan.action.WelcomeDeleteAction;

/**
 * Servlet implementation class BizpollFrontController
 */
@WebServlet("/BizpollFrontController")
public class BizpollFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BizpollFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET, POST 둘다 받음
		
		// 한글깨짐 방지(POST 방식): 가장 위에 적어주세요.
		request.setCharacterEncoding("UTF-8");
		
		Action action = null;         // 실제 동작하는 부분
		ActionForward forward = null; // forward, sendRedirect 설정
		
		
//		uri = /fcryan/memberPlay.bizpoll
//		ctx = /fcryan
//		command = /memberPlay.bizpoll
		// uri - ctx = 내가 원하는 Action경로
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());  // /index.bizpoll
		
//		System.out.println("uri: " + uri);
//		System.out.println("ctx: " + ctx);
		System.out.println("페이지 이동 =====> " + command);
		
		// Action단 이동
		if(command.equals("/index.bizpoll")) {
			action = new IndexAction();  // 객체 생성
			forward = action.excute(request, response);  // 객체(인스턴스) 사용
			// Web에서는 무조건 request, response를 매개변수로 받아야 함.
		} else if(command.equals("/constract.bizpoll")) {
			action = new ConstractAction();
			forward = action.excute(request, response);
		} else if(command.equals("/member.bizpoll")) {
			action = new MemberAction();
			forward = action.excute(request, response);
		} else if(command.equals("/memberplay.bizpoll")) {
			// 이동
			action = new MemberPlayAction(); // 객체생성
			forward = action.excute(request, response);
		} else if(command.equals("/login.bizpoll")) {
			action = new LoginAction();
			forward = action.excute(request, response);
		} else if(command.equals("/LoginPlay.bizpoll")) {
			action = new LoginPlayAction();
			forward = action.excute(request, response);
		} else if(command.equals("/loginOut.bizpoll")) {
			action = new LoginOutPlayAction();
			forward = action.excute(request, response);
		} else if(command.equals("/memberUpdate.bizpoll")) {
			action = new MemberUpdateAction();
			forward = action.excute(request, response);
		} else if(command.equals("/memberupdateplay.bizpoll")) {
			action = new MemberUpdatePlayAction();
			forward = action.excute(request, response);
		} else if(command.equals("/idCheck.bizpoll")) {
			action = new IdCheckAction();
			forward = action.excute(request, response);
		} else if(command.equals("/pwCheck.bizpoll")) {
			action = new PwCheckAction();
			forward = action.excute(request, response);
		} else if(command.equals("/memberPw.bizpoll")) {
			action = new PwUpdateAction();
			forward = action.excute(request, response);
		} else if(command.equals("/memberpwplay.bizpoll")) {
			action = new PwUpdatePlayAction();
			forward = action.excute(request, response);
		} else if(command.equals("/memberDelete.bizpoll")) {
			action = new MemberDeleteAction();
			forward = action.excute(request, response);
		} else if(command.equals("/memberdeleteplay.bizpoll")) {
			action = new MemberDeletePlayAction();
			forward = action.excute(request, response);
		} else if(command.equals("/welcomeDelete.bizpoll")) {
			action = new WelcomeDeleteAction();
			forward = action.excute(request, response);
		} else if(command.equals("/boardList.bizpoll")) {
			action = new BoardListAction();
			forward = action.excute(request, response);
		} else if(command.equals("/boardDetail.bizpoll")) {
			action = new BoardDetailAction();
			forward = action.excute(request, response);
		} else if(command.equals("/boardViewcnt.bizpoll")) {
			action = new BoardViewcntAction();
			forward = action.excute(request, response);
		} else if(command.equals("/boardInsert.bizpoll")) {
			action = new BoardInsertAction();
			forward = action.excute(request, response);
		} else if(command.equals("/boardInsertPlay.bizpoll")) {
			action = new BoardInsertPlayAction();
			forward = action.excute(request, response);
		} else if(command.equals("/download.bizpoll")) {
			action = new BoardDownloadAction();
			forward = action.excute(request, response);
		} else if(command.equals("/boardUpdate.bizpoll")) {
			action = new BoardUpdateAction();
			forward = action.excute(request, response);
		} else if(command.equals("/boardUpdatePlay.bizpoll")) {
			action = new BoardUpdatePlayAction();
			forward = action.excute(request, response);
		} else if(command.equals("/boardDelete.bizpoll")) {
			action = new BoardDeletePlayAction();
			forward = action.excute(request, response);
		} else if(command.equals("/commentlist.bizpoll")) {
			action = new CommentListAction();
			forward = action.excute(request, response);
		} else if(command.equals("/replyInsert.bizpoll")) {
			action = new ReplyInsertAction();
			forward = action.excute(request, response);
		} else if(command.equals("/replyDelete.bizpoll")) {
			action = new ReplyDeleteAction();
			forward = action.excute(request, response);
		} 
		
		
		
		// 공통 분기작업(페이지 이동)
		if(forward != null) {
			if(forward.isRedirect()) { // true: sendRedirect 방식
				response.sendRedirect(forward.getPath());
			} else { // false: forward 방식
				// 목적지: index.jsp
				// 짐: bestlist
				// 이동수단: forward
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
		
	}

}






