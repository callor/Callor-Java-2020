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
     	width: 201px;
     	height: 34px;
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
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#frm_mem input[type='text']").val("");
		
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
        
        $("#inputid").blur(function(){
        	var idVal = $(this).val();
        	
        	if(idVal != "") { 
        		$.ajax({
        			/* ajax db 갔다 
        			   View -> Controller -> Model -> DB
        			*/
        			url: "idCheck.bizpoll",
        			type: "POST",
        			dataType: "json",
        			data: "id=" + idVal,
        			success: function(data) {
        				if(data.message == "-1") {
                            $("#inputid").next().text("이미 사용 중인 아이디 입니다.").css("display", "block").css("color", "#FF3636");
                            $("#inputid").select();
                            $("#inputid").parent().css("margin-bottom", "30px");
        				} else {
        					$("#inputid").next().text("멋지 아이디네요!").css("display", "block").css("color", "#0000FF");
                            $("#inputpw").select();
                            $("#inputid").parent().css("margin-bottom", "30px");
        				}
        			},
        			error: function() {
        				alert("System Error!!!");
        			}
        		});
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
                    $(this).select();
                    $(this).parent().css("margin-bottom", "30px");
        		}
        	}
        });
        
		$("#selmail").change(function(){
			var selmail = $("#selmail").val();
			/* #selmail의 value 값을 selmail 변수에 담아라! */
			
			if(selmail == "directVal") {
				$("#email_url").val("");
				$("#email_url").focus();
			} else {
				$("#email_url").val(selmail);
				/* #email_url의 value 속성에 selmail변수에 값을 넣어라! */	
			}
		});
		
		/* 우편번호, 주소 클릭했을 때 다음 우편번호 API 실행 */
		$(".addrbtn").click(function(){
			$("#addr_btn").click();
		});
	});
	
	
	
	
	$(document).on("click", ".btn_agree", function(){
		/* 유효성체크하는 값을 받아온다. */
		var 
		form = $("#frm_mem"),
		mid = $("#inputid"),
		mpw = $("#inputpw"),
		mpw2 = $("#inputrpw"),
		mname = $("#inputname"),
		mphone = $("#inputphone"),
		memailid = $("#email_id"),
		memailurl = $("#email_url"),
		zipcode = $("#sample6_postcode"),
		maddr1 = $("#sample6_address"),
		maddr2 = $("#sample6_address2");
		
		
		/* trim: 앞뒤 공백 제거 */
		var id = $.trim(mid.val());
		var regId = /^[a-zA-Z0-9]{4,12}$/; /* 4~12자까지 영대소문자와 숫자만 입력 가능 */
		
		if(id == "") {
			mid.focus();
			mid.next().text("필수정보 입니다.").css("display", "block");
			mid.parent().css("margin-bottom", "30px");
			return false;
		} else if(!regId.test(id)) {
			mid.select();
			mid.next().text("4~12자 이내 영문자와 숫자만 입력하세요.").css("display", "block");
			mid.parent().css("margin-bottom", "30px");
			return false;
		} /* + ID 중복체크 */
		
		
		
		var pw = $.trim(mpw.val());
		var pw2 = $.trim(mpw2.val());
		/* 영문자,숫자 포함 특수문자 사용가능.8~20자리 */
		var regPass = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
		
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
		
		var name = $.trim(mname.val());
		
		if(name == "") {
			mname.focus();
			mname.next().text("필수정보 입니다.").css("display", "block");
			mname.parent().css("margin-bottom", "30px");
			return false;
		}
		
		
		var phone = $.trim(mphone.val());
    	var regphone = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
	
		if(phone == "") {
			mphone.focus();
			mphone.next().text("필수정보 입니다.").css("display", "block");
			mphone.parent().css("margin-bottom", "30px");
			return false;
		} else if($.isNumeric(phone) == false) { /* 숫자값만 들어왔는지 체크 */
			mphone.select();
			mphone.next().text("숫자만 입력하세요.").css("display", "block");
			mphone.parent().css("margin-bottom", "30px");
			return false;
		} else if(!regphone.test(phone)) {
			mphone.select();
			mphone.next().text("올바른 값을 입력하세요.").css("display", "block");
			mphone.parent().css("margin-bottom", "30px");
			return false;			
		}


		var mailid = $.trim(memailid.val());
		var mailurl = $.trim(memailurl.val());
		
		var mail = mailid + "@" + mailurl;
		var regMail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		
		if(mailid == "") {
			memailid.focus();
			$("#selmail").next().text("필수정보 입니다.").css("display", "block");
			memailid.parent().css("margin-bottom", "30px");
			return false;
		} else if(mailurl == "") {
			memailurl.select();
			memailid.parent().children().last().text("필수정보 입니다.").css("display", "block");
			memailurl.parent().css("margin-bottom", "30px");
			return false;
		} else if(!regMail.test(mail)) {
			memailid.select();
			memailid.parent().children().last().text("E-mail형식이 올바르지 않습니다.").css("display", "block");
			memailurl.parent().css("margin-bottom", "30px");
			return false;
		} 
		
		var zipcodeVal = $.trim(zipcode.val());
		var addr1 = $.trim(maddr1.val());
		var addr2 = $.trim(maddr2.val());
        
		if(zipcodeVal == "") {
			zipcode.parent().children().last().text("필수정보 입니다.").css("display", "block");
			zipcode.parent().css("margin-bottom", "30px");
			return false;
		} else if(addr1 == "") {
			maddr1.parent().children().last().text("필수정보 입니다.").css("display", "block");
			maddr1.parent().css("margin-bottom", "30px");
			return false;
		} else if(addr2 == "") {
			maddr2.focus();
			maddr2.parent().children().last().text("필수정보 입니다.").css("display", "block");
			maddr2.parent().css("margin-bottom", "30px");
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
	<h3 id="join_title">회원가입</h3>
	<div id="join_wrap" class="divsize">
		<form action="memberplay.bizpoll" method="POST" name="frm_mem" id="frm_mem">
			<div class="div_input" id="fcryan_id">
				<input type="text" placeholder="아이디" class="input_join input_msg" id="inputid" name="inputid" maxlength="20">
				<span id="input_error" class="error">필수 정보입니다.</span>
			</div>
			<div class="div_input" id="fcryan_pw">
				<input type="password" placeholder="비밀번호" class="input_join input_msg checkpw" id="inputpw" name="inputpw">
				<span class="error">필수 정보입니다.</span>
			</div>
			<div class="div_input" id="fcryan_rpw">
				<input type="password" placeholder="비밀번호 재확인" class="input_join input_msg checkpw" id="inputrpw" name="inputrpw">
				<span class="error">필수 정보입니다.</span>
			</div>
			<div class="div_input" id="fcryan_name">
				<input type="text" placeholder="이름" class="input_join input_msg" id="inputname" name="inputname">
				<span class="error">필수 정보입니다.</span>
			</div>
			<div class="div_input" id="fcryan_phone">
				<input type="text" placeholder="핸드폰번호(-없이 입력하세요.)" class="input_join input_msg" id="inputphone" name="inputphone" maxlength="11">
				<span class="error">필수 정보입니다.</span>
			</div>
			<div class="div_input" id="fcryan_email">
				<input type="text" id="email_id" class="input_msg" placeholder="ID" name="email_id">
				<span> @ </span>
				<input type="text" id="email_url" class="input_msg" placeholder="URL" name="email_url">
				<select id="selmail" class="input_msg">
					<option value="" selected="selected">Email 선택</option>
					<option value="directVal">직접입력</option>
					<option value="naver.com">naver.com(네이버)</option>
					<option value="daum.net">daum.net(다음카카오)</option>
					<option value="gmail.com">gmail.com(구글)</option>
					<option value="nate.com">nate.com(네이트)</option>
				</select>
				<span class="error">필수 정보입니다.</span>
			</div>
			<div class="div_input" id="fcryan_addr">
				<input type="text" class="addr input_msg addrbtn" id="sample6_postcode" name="zipcode" placeholder="우편번호" readonly="readonly">
				<input type="button" id="addr_btn" class="addr" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" class="addr input_msg addrbtn" id="sample6_address" placeholder="주소" name="addr1" readonly="readonly">
				<input type="text" class="addr input_msg" id="sample6_address2" placeholder="상세주소" name="addr2" >
				<span class="error">필수 정보입니다.</span>
			</div>
			
			<div id="err_check">
				<span id="err_check_msg">FcRyan 이용약관과 개인정보 
				수집 및 이용에 대한 안내 모두 동의해주세요.</span>
			</div>
			<div class="btn_double_area">
				<span><a href="index.bizpoll" class="btn_type btn_default">취소</a></span>
				<span><a href="#" class="btn_type btn_agree">회원가입</a></span>
			</div>
		</form>
	</div>
</body>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>
</html>
<%@ include file="include/footer.jsp" %> 