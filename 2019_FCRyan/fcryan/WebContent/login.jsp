<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
<%
	String referer = request.getHeader("referer");
	String code = request.getParameter("code");
%>      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
     @import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
     body, ul{
         font-family: 'Nanum Gothic', serif;
         margin: 0px;
         padding: 0px;
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
     	position: absolute;
     	right: 15px;
     	top: 15px;
     	color: black!important;
     	font-size: 25px;
     	padding: 5px;
     	display: block;
     }
     #close_btn:hover {
		background-color: #ccc;		
	 }
     #header_div{
         width: 240px;
         margin: 0px auto 62px;
     }
     #content_layout{
     	 position: relative;
         width: 460px;
         margin: 0px auto;
         background-color: white;
         padding: 20px;
         border-radius: 25px;
     }
     a:link, a:visited {
         text-decoration: none;
     }
    
     .div_input{
         background-color: white;
         border: 1px solid #dadada;
         padding : 10px 35px 10px 15px;
         margin-bottom: 14px;
         width: 408px;
         height: 29px;
     }
     .input_login{
         border-width: 0px;
         width: 408px;
         padding: 7px 0px 6px 0px;
     }
     #btn_login {
         display: block;
         background-color: #263959;
         color: white;
         font-size: 22px;
         padding-top: 2px;
         margin: 30px 0px 13px 0px;
         width: 460px;
         height: 59px;
         text-decoration: none;
         text-align: center;
         line-height: 61px;
     }
     #ip_ud:hover {
         text-decoration: underline;
     }
     #ip_ud {
         color: #747474;
     }
     #login_ud {
         text-decoration: underline;
         color: #747474;
     }
     .si {
         color: #D5D5D5;
     }
     #off {
         display: inline-block;
         font-weight: bold;
         width: 22px;
         text-align: left;
     }
     hr {
         width: 98%;
         margin: 20px auto;
         border: thin solid #EAEAEA;
         padding: 0px auto;
     }
     #member {
         color: #8C8C8C;
         font-size: 12px;
         text-align: center;
     }
     #macketing {
         width: 100%;
     }
     #naver_img {
         width: 460px;
         display: block;
         margin: 47px 0px 15px 0px;
     }
    
    
    
     #footer {
         padding: 15px 0;
     }
     #footer > ul {
         margin: 0 auto 9px;
         text-align: center;
     }
     #footer * {
         font-size: 11px;
         line-height: normal;
         list-style: none;
         color: #333;
     }
     #footer > ul > li {
         display: inline;
         padding: 0 5px 0 7px;
         border-left: 1px solid #dadada;
     }
     #footer > ul > li a:HOVER {
         color: #263959;
     }
     #footer ul li:first-child {
         border-left: 0px!important;
     }
    
    
     #addr_logo {
         width: 63px;
         height: 11px;
     }
     #address {
         margin: 0px auto;
         text-align: center;
     }
     #address * {
         font: 9px verdana;
     }
     #address a {
         font-weight: bold;
     }
     #address a:HOVER {
         color: #263959;
     }
     #err_check_msg {
         height: 24px;
         font-size: 13px;
         font-weight: 700;
         line-height: 24px;
         color: #f46665;
         padding: 0px 15px;
         display: inline-block;
         width: 428px;
     }
     #err_check {
         display: none;
     }
     #indexbody {
		padding-top: 200px;
	 }
	 #header_div h3 {
	 	text-align: center;
	 	font-size: 45px;
	 }
	 .input_login {
	 	font: 400 15px Roboto,RobotoDraft,Helvetica,Arial,sans-serif!important;
	 }
</style>
<script type="text/javascript">
     $(document).ready(function() {
    	 $("#inputid").val("");
    	 
         $("#inputid").focus(function() {
              $("#naver_id").css("border", "1px solid #263959");         
         });
         $("#inputpw").focus(function() {
              $("#naver_pw").css("border", "1px solid #263959");         
         });
         $("#inputid").blur(function() {
              $("#naver_id").css("border", "1px solid #dadada");         
         });
         $("#inputpw").blur(function() {
              $("#naver_pw").css("border", "1px solid #dadada");         
         });
         	
         /* 로그인버튼을 클릭했을 때 유효성 체크 */	
         $("#btn_login").on("click", function(){
        	  /* input의 id와 pw 값을 입력 */
              var val1 = $("#inputid").val();
              var val2 = $("#inputpw").val();
              
              /* 유효성 체크
                 id와 pw 중 하나라도 값이 없으면 경고문 출력*/
              if(val1 != "" && val2 != "") {
      			$.ajax({
      				url: "LoginPlay.bizpoll",
      				type: "POST",
      				dataType: "json",
      				data: "id=" + val1 + "&pw=" + val2,
      				success: function(data) {
      					if(data.message == "1") {
      						if(<%=code%> == "5") {
      							location.href="boardInsert.bizpoll";
      						} else {
      							location.href= "<%=referer%>";
      						}
          				} else {
          					$("#err_check_msg").text("아이디 또는 패스워드가 일치하지 않습니다.");
          					$("#err_check").css("display", "block");
          				}
      				},
      				error:function(){
      					alert("System Error!!");
      				}
      			});
                 
                 
                 
                 
              } else {
            	  $("#err_check_msg").text("필수정보입니다");
                  $("#err_check").css("display", "block");
                  return;
              }
         });
     });
     
</script>
</head>
<body id="indexbody">
	     <div id="content_layout">
	              <div id="header_div">
	                  
	                  <h3>L O G I N</h3>
	              </div>
		              <div class="div_input" id="naver_id"><input type="text" placeholder="아이디" class="input_login" id="inputid" name="inputid"></div>
		              <div class="div_input" id="naver_pw"><input type="password" placeholder="비밀번호" class="input_login" id="inputpw" name="inputpw"></div>
		              <div id="err_check">
		                  <span id="err_check_msg">ID와 PW를 모두 입력해주세요.</span>
		              </div>
		              <div><a id="btn_login" href="#">로그인</a></div>
	              <div><hr></div>
	              <div id="member">
	                  <a href="#">아이디 찾기</a> &nbsp;<span class="si"> | </span>&nbsp;
	                  <a href="#">비밀번호 찾기</a> &nbsp;<span class="si"> | </span>&nbsp;
	                  <a href="#">회원가입</a>
	              </div>
	              <div id="footer">
	                  <ul>
	                       <li><a href="#">이용약관</a></li>
	                       <li><strong><a href="#">개인정보처리방침</a></strong></li>
	                       <li><a href="#">책임의 한계와 법적고지</a></li>
	                       <li><a href="#">회원정보 고객센터</a></li>
	                  </ul>
	                 
	                  <div id="address">
	                       <span><a href="http://www.naver.com">
	                       <img id="addr_logo" alt="FCRyan 로고" src="img/1_Primary_logo_on_transparent_276x67.png"></a></span>
	                       <span>Copyright</span>
	                       <span>©</span>
	                       <span><strong><a href="#">FCRyan Corp.</a></strong></span>
	                       <span>All Rights Reserved.</span>
	                  </div>
	              </div>
	     </div>
</body>
</html>  
<%@ include file="include/footer.jsp" %> 