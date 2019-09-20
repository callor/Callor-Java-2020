<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Fjalla+One');
	body{margin: 0; padding: 0;}
	#footer_wrap {
		width: 100%;
		background-color: #3c404a;
	}
	#footer_info {
		width: 1200px;
		margin: 0 auto;
		padding: 50px 0;
	}
	#footer_info > div {
		position: relative;
	}
	#footer_name {
		color: white;
		line-height: 49px;
		font-size: 38px;
		font-family: 'Fjalla One', sans-serif;
		cursor: pointer;
		text-shadow: 0 0 6px #18BC9C;
	}
	#footer_name:hover {
		color: #18BC9C;
	}
	#footer_name:before {
	  content: '';
	  position: absolute;
	  bottom: 0;
	  left: 0;
	  display: inline-block;
	  width: 104px;
	  height: 1px;
	  background: #000;
	  transform: scale(0);
	  transition: all 0.2s;
	}
	
	#footer_name:hover:before {
	  background: #01c9ca;
	  transform: scale(1);
	}
	
	
	
	#footer_info > div > p > a:hover {
		color: #18BC9C;
	}
	#footer_info > div p {
		vertical-align: middle;
		display: inline-block;
		margin: 10px 0 0 0;
	}
	#footer_info > div p > a {
		display: inline-block;
		height: 30px;
		padding: 0 10px;
		line-height: 30px;
		font-size: 14px;
		font-weight: 200;
		color: #d1d7e5;
		text-decoration: none;
	}
	#footer_info > div > p:nth-of-type(2) {
		padding: 0 20px;
		margin: 16px 0 0 0;
	}
	#footer_info > address {
		display: block;
		position: relative;
		margin-top: 10px;
	}
	#footer_info > address > span {
		display: inline-block;
		font-size: 13px;
		line-height: 1.4em;
		color: #9da3b2;
	}
	.footer_tel {
		padding-left: 15px;
		font-weight: 600;
	}
	.copyright {
		display: block!important;
	}
	.footer_tel:hover {
		color: #F39C12!important;
		cursor: pointer;
	}
</style>
</head>
<body>
	<div id="footer_wrap">
		<div id="footer_info">
			<div>
				<p><span id="footer_name">FCRyan</span></p>
				<p>
					<a href="#">기관소개</a>
					<a href="#">찾아오시는길</a>
					<a href="#">개인정보처리방침</a>
				</p>
			</div>
			<address>
				<span class="footer_addr">광주광역시 북구 경양로170 (중흥동) 한경빌딩(구 남양건설빌딩) 5층 한국경영원 인재개발원</span>
				<span class="footer_tel">대표전화: 062-720-1234</span>
				<span class="copyright">copyrightⓒ 2018 FCRyan All rights reserved.</span>
			</address>
		</div>
	</div>
</body>
</html>