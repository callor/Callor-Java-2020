<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta http-equiv="refresh" content="3; url=index.bizpoll"> -->
<title>Insert title here</title>
<style>
	#join_ok {
		margin: 10% auto;
		width: 1000px;
		border: 5px solid #263959;
		border-radius: 15px;
		padding: 40px 20px;
		background-color: #EAEAEA;
	}
	.welcome_text {
		margin: 0px auto;
		text-align: center;
	}
	.text1 {
		font-size: 45px;		
	}
	.text2 {
		font-size: 30px;
	}
	#rCnt {
		font-size: 35px;
		color: #F15F5F;
		font-weight: bold;
	}
</style>
<script type="text/javascript">
	var cnt=2;  
	function countdown(){
		if(cnt == 0) {
			clearInterval(s);
			location.href="index.bizpoll";
		}
		document.getElementById("rCnt").innerHTML=cnt;
		cnt--;
	}
	var s = setInterval(countdown, 1000); // 1초 단위로 countdown() 실행
</script>
</head>
<body>
	<div id="join_ok">
		<div class="welcome_text text1">탈퇴되셨습니다. <br>FC Ryan을 그동안 이용해주셔서 감사합니다!</div>
		<div class="welcome_text text2"><span id="rCnt">3</span>초후에 메인 페이지로 이동합니다.</div>
		
		<!-- 카운트다운 방법
		       1. meta 태그 활용
		       2. JavaScript의 setInterval() 활용 -->
	</div>
</body>
</html>







