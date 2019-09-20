package com.fcryan.action;

public class ActionForward {
	
	// View Page(결과값을 어디로 전송할지)
	private String path;  // "welcome_join.jsp"
	
	// 페이지 이동하는 방법(sendRedirect, Forward)
	// true -> sendRedirect, false -> forward
	private boolean isRedirect;  // true

	public String getPath() {
		return path;
	}

	public void setPath(String path) { // path = "welcome_join.jsp"
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {  // true
		this.isRedirect = isRedirect;
	}
	
	
}





