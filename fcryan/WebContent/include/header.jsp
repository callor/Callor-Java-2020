<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>
<%
	String path = request.getContextPath(); //컨텍스트 경로
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/hanna.css);
@import url(http://fonts.googleapis.com/earlyaccess/jejugothic.css);
@import url('https://fonts.googleapis.com/css?family=Fjalla+One');
@import url('https://fonts.googleapis.com/css?family=Sunflower:300');
@import url('https://fonts.googleapis.com/css?family=Jua|Sunflower:300');

	* {
		/* font-family: 'Hanna', sans-serif; */
		font-family: 'Jeju Gothic', serif;
	}
	body, ul {
		margin: 0px;
		padding: 0px;
	}
	ul {
		list-style-type: none;
	}
	a {
		text-decoration: none;
	}
	#header_wrap {
		box-sizing: border-box;
		position: fixed;
		top: 0px;
		left: 0px;
		width: 100%;
		background-color: white;
		z-index: 100;
	}
	#header_wrap * {
		font-family: 'Jeju Gothic', serif!important;
	}
	
	#hide_menu {
		position: absolute;
		top: 30px;
		width: 100%;
		transition: 0.6s;
		background-color: white;
	}
	/* header(로그인, 회원가입, 마이페이지, 고객센터) */
	#header_line1 {
		position: fixed;
		z-index: 500;
		height: 30px;
		width: 100%;
		background-color: #2C3E50 !important;
		box-sizing: border-box;
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2),
		            0 6px 20px 0 rgba(0, 0, 0, 0.19);
	}
	#header_line1_in {
		width: 1400px;
		margin: 0 auto;
	}
	#header_line1_ul {
		float: right;
	}
	#header_line1_ul > li > a {
		color: white;
		font-size: 12px;
		font-weight: bold;
		height: 30px;
		padding: 0 10px;
		display: inline-block;
		line-height: 30px;
	}
	#header_line1_ul > li {
		float: left; /* 태그들을 좌측, 우측 유동 배치 */
		height: 30px;
		position: relative;
	}
	#header_line1_ul > li:hover { /* li태그에 마우스를 올렸을 때 동작하는 내용 */
 		background-color: #18BC9C;
	}
	
	#header_line1_ul > li:hover #header_line1_dropdown {
		/* #header_line1_ul > li:hover 했을 때
		   #header_line1_dropdown을 어떻게 변경할지 적용 */
	   	display: block;
	}
	
	#header_line1_dropdown {
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2),
		            0 6px 20px 0 rgba(0, 0, 0, 0.19);
		display: none;
		position: absolute;
		z-index: 1;
	}
	
	#header_line1_dropdown > a {
		display: block;
		font-size: 12px;
		background-color: #2C3E50;
		color: white;
		padding: 5px 10px;
		border-top: 1px solid white;
		width: 82px;
	}
	#header_line1_dropdown > a:hover {
		background-color: #18BC9C;
		text-decoration: underline;
	}
	#header_line1_mypage {
		width: 82px;
		text-align: center;
	}
	#loginInfo {
		font-size: 14px;
		line-height: 30px;
		color: white;
		padding: 0px 10px;
	}
	#loginInfo:hover {
		background-color: inherit!important;
	}
	#loginInfo > span {
		color: orange;
	}
	
	/* 로고이미지, 검색창 */
	#header_line2 {
		width: 1400px;
		height: 80px;
		margin: 0px auto;
		box-sizing: border-box;
		transition: 0.1s;
		background-color: white;
	}
	#header_line2 img {
		display: inline-block;
		margin-top: 8px;
		width: 250px;
	}
	
	/* line2 검색창 */
	div.header_line2_wrap_search {
		height: 34px;
		display: inline-block;
		float: right;
		padding-top: 46px;
		padding-right: 10px;
	}
	div.header_line2_search {
		border: 2px solid #18BC9C;
		height: 34px;
		box-sizing: border-box;
		position: relative;
		border-radius: 25px;
	}
	input.search_keyword {
		width: 353px;
		height: 30px;
		font-size: 13px;
		box-sizing: border-box;
		border: 0px;
		padding-left: 10px;
		outline: none;
		border-radius: 25px;
	}
	input.search_btn {
		width: 55px;
		height: 30px;
		background-color: #18BC9C;
		color: white;
		font-size: 13px;
		border: 0px;
		position: absolute;
		right: 0px;
		top: 0px;
		border-radius: 0 12px 13px 0;
	}
	.search_btn:hover {
		font-size: 17px;
	}

	/* 네비게이션 메뉴바 */
	#header_line3 {
		width: 100%;
		min-width: 1400px;
		height: 49px;
		background-color: #18BC9C;
		box-shadow: 0 4px 10px 0 rgba(0, 0, 0, 0.2), 
		            0 4px 20px 0 rgba(0, 0, 0, 0.19);
		box-sizing: border-box; /* 크기 고정 */
		position: relative;
		margin-top: 35px;
		transition: 0.6s;
		padding: 0px 35px;
	}
	#header_line3_ul > li {
		float: left;
		box-sizing: border-box;
		height: 49px;
		position: relative;
	}
	
    #header_line3_ul > li:hover {
		background-color: #2C3E50;
		border-top: 5px solid white;
	}
 	#header_line3_ul > li:hover .header_line3_dropdown{
		display: block;
		top: 44px;
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	} 
	#header_line3:hover #big_drop {
		display: block;
	}
	#header_line3_ul > li > a {
		width: 118px;
		color: white;
		line-height: 49px;
		font-size: 17px;
		padding: 0 13px;
		display: inline-block;
		height: 49px;
		text-align: center;
	}
	#header_line3_in {
		width: 1400px;
		margin: 0 auto;
		box-sizing: border-box;
	}
	.header_line3_dropdown {
		position: absolute;
		background-color: #2C3E50;
		display: none;
	}
	.header_line3_dropdown > a{
		display: block;
		color: white;
		padding: 7px 0px;
		width: 144px;
		text-align: center;
		border-top: 1px solid white;
	}
	.header_line3_dropdown > a:hover {
		background-color: #18BC9C;
		text-decoration: underline;
	}
	
	
	#rightmenu {
		float: left;
	}
	#leftmenu {
		float: left;
		transition: 0.6s;
	}
	#leftmenu > span {
		color: white;
		line-height: 49px;
		font-size: 25px;
		font-family: 'Fjalla One', sans-serif;
		padding-right: 20px;
	}
	#small_wrap_search {
		padding: 8px 0 0 0;
	}
	#small_wrap_search > div {
		border: 2px solid #2C3E50;
	}
	
	#small_search_keyword {
		width: 250px;
	} 
	#small_search_btn {
		background-color: #2C3E50;
	}
	
	#myBtn {
		border-top: 2px dashed #F39C12;
		width: 200px;
		height: 200px;
		background-color: #2C3E50;
		color: white;
		transform: rotate(315deg);
		position: fixed;
		right: -100px;
		bottom: -100px;
		text-align: center;
		font-size: 25px;
		transition: 0.5s;
	}
	#myBtn:hover {
		background-color: #18BC9C;
	}
	#small_logo > a{
		color: inherit;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#myBtn").css("opacity", "0");
		$("#leftmenu").css("display", "block");
	});
	$(window).scroll(function(){
		if($(document).scrollTop() > 200) {
			$("#myBtn").css("opacity", "1");
		} else {
			$("#myBtn").css("opacity", "0");
		}
	});
	$(document).on("click", "#myBtn", function(){
		/* $(document).scrollTop(0); */
		$("html, body").animate({scrollTop: 0}, 700);
	});  
</script>
</head>
<body>
	<div id="myBtn">
		<span>TOP</span>
	</div>

	<header>
		<div id="hide_header">
			<div id="hide_header_in">
			</div>
		</div>
		<div id="header_wrap">
			<div id="header_line1">
				<div id="header_line1_in">
					<ul id="header_line1_ul">
						<c:choose>
							<c:when test="${empty sessionScope.loginUser}">
								<li><a href="<%=path%>/login.bizpoll" id="login_btn">로그인</a></li>
								<li><a href="<%=path%>/constract.bizpoll">회원가입</a></li>
							</c:when>
							<c:otherwise>
							    <li id="loginInfo">
							    	<span>${sessionScope.loginUser.name}</span>
							    	(${sessionScope.loginUser.id})
							    </li>
								<li><a href="<%=path%>/loginOut.bizpoll">로그아웃</a></li>	
							</c:otherwise>
						</c:choose>
						<li>
							<a id="header_line1_mypage"  href="">마이페이지▼</a>
							<div id="header_line1_dropdown">
								<a href="#">주문/배송조회</a>
								<a href="#">장바구니</a>
								<a href="#">위시리스트</a>
								<c:choose>
									<c:when test="${!empty sessionScope.loginUser}">
										<a href="<%=path%>/memberPw.bizpoll">비밀번호 수정</a>
										<a href="<%=path%>/memberUpdate.bizpoll">내정보 수정</a>
										<a href="<%=path%>/memberDelete.bizpoll">회원 탈퇴</a>
									</c:when>
								</c:choose>
							</div>
						</li>
						<li><a href="">고객센터</a></li>
					</ul>
				</div>
			</div>
			<div id="hide_menu">
				<div id="header_line2">
					<a href="<%=path%>/index.bizpoll">
						<img id="header_logo" src="<%=path%>/img/FCRyan_Logo.png" alt="로고이미지">
					</a>
					<div class="header_line2_wrap_search">
						<div class="header_line2_search">
							<input class="search_keyword" type="text" placeholder="검색어를 입력하세요.">
							<input class="search_btn" type="submit" value="검색">
						</div>
					</div>
					
				</div>
				
				<div id="header_line3">
					<div id="header_line3_in">
						<div id="rightmenu">
							<ul id="header_line3_ul">
								<li><a href="#">FC Info.</a></li>
								<li><a href="#">프리미어리그</a></li>
								<li><a href="#">라리가</a>
									<div class="header_line3_dropdown">
										<a href="">FC바르셀로나</a>
										<a href="">레알마드리드</a>
										<a href="">AT마드리드</a>
										<a href="">세비야 FC</a>
										<a href="">RCD 에스파뇰</a>
									</div>
								</li>
								<li><a href="#">세리에 A</a></li>
								<li><a href="#">분데스리가</a></li>
								<li><a href="boardList.bizpoll">게시판</a></li>
							</ul>	
						</div>
						<div id="leftmenu">
							<span id="small_logo"><a href="<%=path%>/index.bizpoll">FCRyan</a></span>
							<div class="header_line2_wrap_search" id="small_wrap_search">
								<div class="header_line2_search">
									<input class="search_keyword" id="small_search_keyword" type="text" placeholder="검색어를 입력하세요.">
									<input class="search_btn" id="small_search_btn" type="submit" value="검색">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		$("#leftmenu").css("opacity", "0");
		window.onscroll = function() {scrollFunction()};
		
		function scrollFunction() {
			if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
				$("#hide_menu").css("top", "-85px");
				$("#rightmenu").css("float", "right");
				$("#leftmenu").css("display", "block");
				$("#leftmenu").css("opacity", "1");
				$("#header_line1").css("box-shadow", "none");
			} else {
				$("#hide_menu").css("top", "30px");
				$("#rightmenu").css("float", "left");
				$("#leftmenu").css("display", "none");
				$("#leftmenu").css("opacity", "0");
				$("#header_line1").css("box-shadow", "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)");
			}
		}
	});
	
</script>
</html>







