<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 브라우저 타이틀바 로고 삽입(favicon -->
<link rel="icon" type="image/png" href="img/naversm.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- 익스는 png 파일도 돼지만 크롬은 ico확장자로 바꿔서 넣어줘야함 -->
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
         color: inherit;
         text-decoration: none;
     }
    
     a:hover{
         text-decoration: underline;
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
         font-size: 11px;
         font-weight: 700;
         line-height: 24px;
         color: #f46665;
         padding: 0px 15px;
         display: inline-block;
         width: 428px;
         text-align: center;
     }
     #err_check {
         display: none;
     }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
     $(document).ready(function() {
    	 $(".input_login").val("");
    	 
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
         	
        
         $("#btn_login").on("click", function(){
              var val1 = $("#inputid").val();
              var val2 = $("#inputpw").val();
              if(val1 != "" && val2 != "") {
                  alert("페이지 이동");
              } else {
                  $("#err_check").css("display", "block");
                  return;
              }
         });
         /* Modal창 켜고 끄기 */
         $("#login_btn").click(function(){

        	$("#modal_all").css("display", "block");
         });
         $("#close_btn").click(function(){
            $("#inputid").val("");
		    $("#inputpw").val("");
        	$("#modal_all").css("display", "none");
         });
     });
     
     $(document).on("click", "#close_btn", function(){
    	 
     });
</script>
</head>
<body>
	 <div id="modal_all"> 	
	     <div id="content_layout">
	     	 <span id="close_btn"><i class="fa fa-close"></i></span>
	              <div id="header_div">
	                  <a href="http://www.naver.com">
	                  <img alt="네이버 로고" src="img/1_Primary_logo_on_transparent_276x67.png"></a>
	              </div>
	        
	              <div class="div_input" id="naver_id"><input type="text" placeholder="아이디" class="input_login" id="inputid"></div>
	              <div class="div_input" id="naver_pw"><input type="password" placeholder="비밀번호" class="input_login" id="inputpw"></div>
	              <div id="err_check">
	                  <span id="err_check_msg">네이버 이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.</span>
	              </div>
	              <div><a id="btn_login" href="#">로그인</a></div>
	              <div><hr></div>
	              <div id="member">
	                  <a href="#">아이디 찾기</a>&nbsp;<span class="si"> | </span>&nbsp;
	                  <a href="#">비밀번호 찾기</a>&nbsp;<span class="si"> | </span>&nbsp;
	                  <a href="#">회원가입</a>
	              </div>
	              <div id="macketing">
	                       <img src="img/naver_img.JPG" alt="" id="naver_img">
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
     </div>
</body>
</html> 