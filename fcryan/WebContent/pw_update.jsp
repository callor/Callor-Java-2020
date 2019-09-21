<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FCRyan 회원가입</title>
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
		border-top: 10px solid #263959;
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
     	background-color: #263959;
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
		border: 1px solid #263959;
		background-color: #263959;
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
		left: -140px;
	}
	#pw_line {
		border: 1px dashed black;
		margin: 30px 0px;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		
        $(".input_msg").focus(function() {
            $(this).parent().css("border", "1px solid #263959");         
        });
        $(".input_msg").blur(function() {
        	$(this).parent().css("border", "1px solid #dadada");         
        });
        

        /* input태그 값이 없으면 경고메세지 출력 */
        $(".input_msg").blur(function(){
        	if($(this).val() == "") {
        		/* $(".error").css("display", "block"); */
        		$(this).parent().children().last().text("필수정보 입니다.").css("display", "block");
            	$(this).parent().css("margin-bottom", "30px");	
        	} else {
        		/* $(".error").css("display", "none"); */
        		$(this).parent().children().last().css("display", "none");
            	$(this).parent().css("margin-bottom", "16px");	
        	}
        });
        
        /* 비빌번호 재확인 input태그를 blur했을 때 
                  비밀번호와 비밀번호 재확인 값을 비교 */
        $("#inputrpw").blur(function(){
        	/* 비밀번호와 비밀번호확인 값이 다르면 경고메세지 출력 */
        	var pw1 = $("#inputpw").val();
        	var pw2 = $("#inputrpw").val();
        	if(pw2 != "") {
        		/* alert("=====>" + pw1 + ", " + pw2); */
        		if(pw1 == pw2) { /* 값이 일치하는 경우 */
        			$(".checkpw").next().css("display", "none");
        		} else {         /* 값이 일치하지 않는 경우 */
        			/* 1.비밀번호확인 메시지에 “비밀번호가 일치하지 않습니다.” 출력
                       2.비밀번호확인(input) -> select */
                    $(this).next().text("비빌번호가 일치하지 않습니다.").css("display", "block");
                    $(this).parent().css("margin-bottom", "30px");
        		}
        	}
        });
        
	});
	
	$(document).on("blur", "#pw_now", function(){
		// 현재비밀번호 입력받은 값이 일치한지 확인하는 과정
		var nowPw = $("#pw_now").val();
		
		if(nowPw != "") {
			$.ajax({
				url: "pwCheck.bizpoll",
				type: "POST",
				dataType: "json",
				data: "id=${sessionScope.loginUser.id}&pw=" + nowPw,
				success: function(data) {
					if(data.message == "-1") {
						$("#pw_now").next().text("비밀번호가 일치합니다.").css("display", "block").css("color", "#0000FF");
						$("#inputpw").focus();
						$("#pw_now").parent().css("margin-bottom", "30px");
    				} else {
        				$("#pw_now").next().text("비밀번호가 일치하지 않습니다.").css("display", "block").css("color", "#FF3636");
        				$("#pw_now").select();
        				$("#pw_now").parent().css("margin-bottom", "30px");
    				}
				},
				error:function(){
					alert("System Error!!");
				}
			});
		}
		
	});
	
	
	$(document).on("click", ".btn_agree", function(){
		/* 유효성체크하는 값을 받아온다. */
		var 
		form = $("#frm_mem"),
		nowpw = $("#pw_now"),
		mpw = $("#inputpw"),
		mpw2 = $("#inputrpw");

		
		var npw = $.trim(nowpw.val());
		var pw = $.trim(mpw.val());
		var pw2 = $.trim(mpw2.val());
		var checkTest = $("#pw_now").next().text();
		/* checkTest = 필수정보입니다.
		                        비밀번호가 일치하지 않습니다.
		                        비밀번호가 일치합니다.*/
		
		
		/* 영문자,숫자 포함 특수문자 사용가능.8~20자리 */
		var regPass = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
		if(npw == "") {
			nowpw.focus();
			nowpw.next().text("필수정보 입니다.").css("display", "block");
			nowpw.parent().css("margin-bottom", "30px");
			return false;
		} else if(checkTest != "비밀번호가 일치합니다.") {
			nowpw.select();
			nowpw.parent().css("margin-bottom", "30px");
			return false;
		}
		
		if(pw == "") {
			mpw.focus();
			mpw.next().text("필수정보 입니다.").css("display", "block");
			mpw.parent().css("margin-bottom", "30px");
			return false;
		} else if(!regPass.test(pw)) {
			mpw.select();
			mpw.next().text("8~20자 이내 영문자, 숫자, 특수문자만 입력해주세요.").css("display", "block");
			mpw.parent().css("margin-bottom", "30px");
			return false;
		} else if(pw2 == "") {
			mpw2.focus();
			mpw2.next().text("필수정보 입니다.").css("display", "block");
			mpw2.parent().css("margin-bottom", "30px");
			return false;
		} else if(pw != pw2) {
			mpw2.select();
			mpw2.next().text("비밀번호가 일치하지 않습니다.").css("display", "block");
			mpw2.parent().css("margin-bottom", "30px");
			return false;
		}
				
		if(npw == pw) {
			mpw.focus();
			mpw.val("");
			mpw2.val("");
			mpw.next().text("현재 비밀번호와 동일합니다.").css("display", "block");
			mpw.parent().css("margin-bottom", "30px");
			return false;
		}
		
		/* 유효성체크 값이 유효한값 확인 끝!!!*/
		form.submit();
		
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
	<h3 id="join_title">비밀번호 수정</h3>
	<div id="join_wrap" class="divsize">
		<form action="memberpwplay.bizpoll" method="POST" name="frm_mem" id="frm_mem">
			<div class="div_input" id="fcryan_pw">
				<label class="label_pw" for="pw_now">현재 비밀번호</label>
				<input type="password" placeholder="현재 비밀번호" class="input_join input_msg checkpw" id="pw_now" name="pw_now">
				<span class="error">필수 정보입니다.</span>
			</div>
			
			<hr id="pw_line">
		
			<div class="div_input" id="fcryan_pw">
				<label class="label_pw" for="inputpw">새 비밀번호</label>
				<input type="password" placeholder="새 비밀번호" class="input_join input_msg checkpw" id="inputpw" name="inputpw">
				<span class="error">필수 정보입니다.</span>
			</div>
			<div class="div_input" id="fcryan_rpw">
				<label class="label_pw" for="inputrpw">새 비밀번호 확인</label>
				<input type="password" placeholder="새 비밀번호 재확인" class="input_join input_msg checkpw" id="inputrpw" name="inputrpw">
				<span class="error">필수 정보입니다.</span>
			</div>
	
			<input type="hidden" name="updateId" value="${sessionScope.loginUser.id}">
			
			<div class="btn_double_area">
				<span><a href="index.bizpoll" class="btn_type btn_default">취소</a></span>
				<span><a href="#" class="btn_type btn_agree">저장하기</a></span>
			</div>
			
		</form>
	</div>
	
</body>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

</html>