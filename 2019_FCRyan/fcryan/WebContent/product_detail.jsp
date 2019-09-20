<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/include.jsp" %>
<%@ include file="include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FCRyan</title>
<style type="text/css">
	#detail_wrap {
		width: 1200px;
		box-sizing: border-box;
		margin: 230px auto 0;
		border: 5px solid black;
		height: 450px;
	}
	#detail_wrap_line1 {
		width: 100%;
		height: 355px;
	}
	#detail_wrap_line1 > div {
		display: inline-block;
		float: left;
		box-sizing: border-box;
	}
	#detail_wrap_line2 {
		width: 100%;
		height: 80px;
		border-top: 5px solid black;
	}
	.card_img {
		overflow: hidden;
	}
	.card_img > img {
		width: 220px;
		height: 320px;
		padding: 15px;
	}
	#detail_wrap_line1 > div:first-child {
		background-color: #263959;
		height: 355px;
		width: 40%;
		padding: 100px 15px;
	}
	#detail_wrap_line1 > div:last-child {
		width: 59%;
		text-align: center;
	}
	#detail_wrap_line1 > div:first-child > a{
		display: block;
		margin-bottom: 15px;
	}
	.fcinfo {
		color: white;
	}
	#fcname {
		font-size: 35px; 
		font-weight: bold;
		background-color: #9C1737;
		padding: 10px;
	}
	#fcclub {font-size: 25px; font-weight: bold;}
	#fcnation {font-size: 20px; color: #CCCCCC; }
	.fcinfo2 {
		box-sizing: border-box;
		float: left;
		padding: 15px 10px;
		height: 80px;
		font-size: 15px;
	}
	.fcinfo2:not(#fcgood) {
		width: 30%;
	}
	.fcinfo2_title {
		font-size: 20px;
		font-weight: bold;
		color: #263959;
		padding-bottom: 7px;
		display: block;
	}
</style>
</head>
<body>
	<div id="detail_wrap">
		<div id="detail_wrap_line1">
			<div>
				<a href="#" class="fcinfo" id="fcname">FC 바르셀로나</a>
				<a href="#" class="fcinfo" id="fcclub">프리메라리가</a>
				<a href="#" class="fcinfo" id="fcnation">스페인</a>
			</div>
			<div class="card_img"><img src="img/라이언30.jpg" alt="구단이미지"></div>
		</div>
		<div id="detail_wrap_line2">
			<div class="fcinfo2" id="fclocal"><span class="fcinfo2_title">연고지</span>스페인 바르셀로나</div>
			<div class="fcinfo2" id="fcstadium"><span class="fcinfo2_title">경기장</span>캄프 누</div>
			<div class="fcinfo2" id="fccoach"><span class="fcinfo2_title">감독</span>에르네스토 발베르데</div>
			<div class="fcinfo2" id="fcgood"><span></span>30</div>
		</div>
	</div>
</body>
</html>
<%@ include file="include/footer.jsp" %> 