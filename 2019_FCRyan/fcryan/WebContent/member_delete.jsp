<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FCRyan 회원탈퇴</title>
<style type="text/css">
	body, ul {
		margin: 0; padding: 0;
	}
	ul {
		list-style-type: none;
	}
	a {
		text-decoration: none;
		color: inherit;
	}
	/* header */
	#join_wrap {
		margin-top: 50px;
	}
	#header {
		width: 100%;
		border-top: 10px solid #2C3E50;
	}
	.divsize {
		width: 768px;
		margin: 0 auto;
		box-sizing: border-box;
	}
	#header {
		height: 139px;
		padding-top: 30px;
		position: relative;
	}
	#fcryan_logo {
		margin: 0; padding: 0;
	}
	.n_logo {
		display: block;
		width: 240px;
		height: 44px;
		margin: 0 auto;
		box-si5zing: border-box;
	}
	
	
	.div_input{
         background-color: white;
         border: 1px solid #dadada;
         padding : 10px 35px 10px 15px;
         margin-bottom: 14px;
         width: 408px;
         height: 29px;
         margin: 0 auto 14px;
         position: relative;
     }
     .input_join{
         border-width: 0px;
         width: 408px;
         padding: 7px 0px 6px 0px;
     }
     
     #email_id{
     	width: 150px;
     	height: 28px; 
     }
     #email_url {
     	width: 220px;
     	height: 28px;
     }
     #selmail {
     	margin-top: 10px;
     	width: 405px;
     	height: 28px;
     }
     #fcryan_email {
     	height: 72px!important;
     }
     .addr {
     	width: 197px;
     	height: 28px;
     	margin-bottom: 10px;
     }
     #fcryan_addr {
     	height: 78px;
     }
     #addr_btn {
     	border: 0px;
     	background-color: #2C3E50;
     	color: white;
     	width: 201px;
     	height: 34px;
     	float: right;
     }
     #fcryan_addr > input:last-child {
		float: right;
	}	
	
	.btn_type {
		width: auto;
		font-size: 20px;
		font-weight: 600;
		line-height: 61px;
		display: block;
		box-sizing: border-box;
		height: 61px;
		padding-top: 1px;
		text-align: center;
	}
	.btn_agree {
		color: #fff;
		border: 1px solid #2C3E50;
		background-color: #2C3E50;
		margin-left: 5px;
	}
	.btn_default {
		margin-right: 5px;
		color: #333;
		border: 1px solid #e7e7e7;
		background-color: #fff;
	}
	.btn_double_area {
		margin: 30px auto 45px;
		overflow: hidden;
		width: 460px;
	}
	.btn_double_area > span {
		display: block;
		float: left;
		width: 50%;
	}
	
	#join_title {
		text-align: center;
		font-size: 45px;
		margin: 30px 0px;
	}
	
	#err_check {
		display: none;
	}	
	#err_check_msg {
		display: inline-block;
		width: 428px;
		height: 24px;
		font-size: 11px;
		font-weight: 700;
		line-height: 24px;
		color: #f46665;
		padding: 0px 15px;
		text-align: center;
	}
	.error {
		position: absolute;
		color: #FF3636;
		font-size: 12px;
		display: inline-block;
		bottom: -19px;
		left: 0px;
		display: none;
	}
	.label_pw {
		position: absolute;
		top: 12px;
		left: -90px;
	}
	#fcryan_msg {
		border: 2px solid #2C3E50;
		border-radius: 25px;
		margin: 0px auto 30px;
		width: 760px;
		height: 270px;
		padding: 0px 50px;
		box-sizing: border-box;
	}
	#fcryan_msg h3 {
		text-align: center;
		font-size: 25px;
	}
	.point {
		font-weight: bold;
		color: #0054FF;
	}
	#modal_all {
     	z-index: 3;
     	position: fixed;
     	top: 0;
     	left: 0;
     	width: 100%;
     	height: 100%;
     	overflow: auto;
     	background-color: rgba(0, 0, 0, 0.4);
     	padding-top: 100px;
     	display: none;
     }
     #close_btn {
		float: right;
		cursor: pointer;
		margin-top: 8px;
     }
	 #content_layout{
         width: 460px;
         height: 160px;
         box-sizing: border-box;
         background-color: white;
         border-radius: 25px;
         position: absolute;
         top: 50%;
         left: 50%;
         margin-left: -230px;     
         margin-top: -160px;
         border: 2px solid #2C3E50;
     }
     #modal_header {
     	height: 35px;
     	background-color: #2C3E50;
     	color: white;
     	border-radius: 20px 20px 0 0;
     	padding: 0 20px;
     	line-height: 35px;
     }
     #modal_content {
     	text-align: center;
     	font-size: 20px;
     	padding: 20px 0px;
     }
     .btn_login {
     	text-align: center;
     }
     .btn_login > a {
     	width: 90px;
     	height: 35px;
     	border: 2px solid #2C3E50;
     	font-size: 20px;
     	border-radius: 25px;
     	display: inline-block;
     	text-align: center;
     	font-weight: bold;
     	color: #2C3E50;
     	margin: 0px 20px 20px;
     	line-height: 33px;
     }
     .btn_login > a:hover {
		background-color: #2C3E50;
		color: white;
	 }
</style>
<script type="text/javascript">
	$(document).ready(function(){
		
        $(".input_msg").focus(function() {
            $(this).parent().css("border", "1px solid #2C3E50");         
        });
        $(".input_msg").blur(function() {
        	$(this).parent().css("border", "1px solid #dadada");         
        });
        
        
        /* input태그 값이 없으면 경고메세지 출력 */
        $(".input_msg").blur(function(){
        	if($(this).val() == "") {
        		$(this).parent().children().last().text("필수정보 입니다.").css("display", "block");
            	$(this).parent().css("margin-bottom", "30px");	
        	} else {
        		$(this).parent().children().last().css("display", "none");
            	$(this).parent().css("margin-bottom", "16px");	
        	}
        });
	});
	
	
	
	
	$(document).on("click", ".btn_agree", function(){
		var mpw = $("#inputpw");
		var pw = $.trim(mpw.val());
		if(pw == "") {
			mpw.focus();
			mpw.next().text("필수정보 입니다.").css("display", "block");
			mpw.parent().css("margin-bottom", "30px");
			return false;
		}
		$("#modal_all").css("display", "block");
	});
	$(document).on("click", "#close_btn", function(){
		$("#modal_all").css("display", "none");
	});
	$(document).on("click", "#no_btn", function(){
		$("#modal_all").css("display", "none");
	});
	$(document).on("click", "#yes_btn", function(){
		var nowPw = $("#inputpw").val();  // input태그의 PW값
		
		$.ajax({
			url: "memberdeleteplay.bizpoll",
			type: "POST",
			dataType: "json",
			data: "id=${sessionScope.loginUser.id}&pw=" + nowPw,
			success: function(data) {
				if(data.message == "-1") {
					location.href="welcomeDelete.bizpoll";
				} else {
					$("#modal_all").css("display", "none");
    				$("#inputpw").next().text("정확한 비밀번호를 입력해주세요.").css("display", "block").css("color", "#FF3636");
    				$("#inputpw").select();
    				$("#inputpw").parent().css("margin-bottom", "30px");
				}
			},
			error:function(){
				alert("System Error!!");
			}
		});
	});
</script>
</head>
<body>
	<div id="header" class="divsize">
		<h1 id="fcryan_logo">
			<a href="index.bizpoll" class="n_logo">
				<img src="img/1_Primary_logo_on_transparent_276x67.png" >
			</a>
		</h1>
	</div>
	<hr>
	<h3 id="join_title">회원탈퇴</h3>
	<div id="join_wrap" class="divsize">
			<div class="div_input" id="fcryan_msg">
				<h3><span class="point">"${sessionScope.loginUser.name}님"</span> 회원탈퇴시 아래의 조취가 취해집니다.</h3>
				<span>1. 계정정보는 <span class="point">'개인 정보 보호 정책'에 따라 60일간 보관(잠김) 되며,</span> 
				      60일이 경과된 후에는 모든 개인정보는 완전히 삭제되며 더 이상 복구할 수 없게 됩니다.
				  <br><br>2. 작성된 게시물은 삭제되지 않으며, 익명처리 후 <span class="point">FCRyan로 소유권이 귀속</span>됩니다.
				  <br><br>3. 게시물 삭제가 필요한 경우에는 <span class="point">관리자(sentilemon02@fcryan.co.kr)</span>로 문의해 주시기 바랍니다.
				</span>
			</div>
			<div class="div_input" id="fcryan_pw" >
				<label class="label_pw" for="inputpw">비밀번호</label>
				<input type="password" placeholder="비밀번호" class="input_join input_msg checkpw" id="inputpw" name="inputpw">
				<span class="error">필수 정보입니다.</span>
			</div>


			<div class="btn_double_area">
				<span><a href="index.bizpoll" class="btn_type btn_default">취소</a></span>
				<span><a href="#" class="btn_type btn_agree">예, 탈퇴하겠습니다.</a></span>
			</div>
	</div>
	
	
	<div id="modal_all"> 	
	     <div id="content_layout">
	     	<div id="modal_header">회원탈퇴 <span id="close_btn"><i class="fa fa-close"></i></span></div>
	     	<div id="modal_content">정말 <span class="point">FCRyan</span>을 탈퇴하시겠습니까?</div> 
	        
	        <div class="btn_login">
	        	<a id="no_btn" href="#">아니오</a>
	        	<a id="yes_btn" href="#">네</a>
	        </div>
	     </div>
	</div>
</body>

</html>