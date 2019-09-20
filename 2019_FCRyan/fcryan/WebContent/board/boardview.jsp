<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>
<%
	String referer = request.getHeader("referer");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a {
		text-decoration: none;
	}
	
	#board_wrap {
		width: 800px;
		border: 1px solid black;
		margin: 230px auto 40px;
		border-radius: 5px;
		box-sizing: border-box;
		border-top: 20px solid #2C3E50 !important;
		padding: 20px;
		padding-bottom: 40px;
		box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19);
	}
	
	.box-title {
		margin: 0px;
		margin-bottom: 10px;
	}
	
	#content {
		resize: none;
	}
	
	#reply_wrap {
		margin: 0 auto 40px;
		border: 1px solid black;
		width: 800px;
		box-sizing: border-box;
		border-radius: 4px;
		box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19);
	}
	
	#reply_wrap_title {
		height: 30px;
		margin: 0px;
		border-bottom: 1px solid black;
		background-color: #2C3E50;
	}
	
	#knboard_detail_rspan {
		color: white;
		font-size: 15px;
		line-height: 30px;
		padding-left: 10px;
	}
	
	#detail_reply {
		width: 799px;
		padding: 20px;
		box-sizing: border-box;
	}
 	.reply_list:nth-child(2n) {
		margin-left: 130px;
	}
	.box {
		margin: 10px;
	}
	
	.reply_list {
		border: 1px solid black;
		border-radius: 4px;
		padding: 10px;
		background-color: white;
		width: 602px;
		box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19);
	}
	.reply_insert {
		width: 735px!important;
	}
	#replyInsert {
		width: 730px!important;
	}
	.reply_writer {
		color: #2C3E50;
		font-weight: bold;
		font-size: 16px;
		text-decoration: none;
	}
	
	#replylist_date {
		float: right;
		color: #2C3E50;
		font-size: 12px;
	}
	.replylist_textarea {
		padding: 5px;
		width: 600px;
		resize: none;
		border-radius: 4px;
		box-sizing: border-box;
		border: 1px solid #BBBBBB;
		font-size: 13px;
		margin-top: 10px;
	}
	
	.reply_login {
		border-top: 2px dashed black;
		padding-left: 10px;
	}
	
	.reply_nologin_span {
		width: 14px;
		line-height: 40px;
		font-size: 12px;
	}
	#reply_btn {
		background-color: #F39C12;
		display: inline-block;
		margin-top: 10px;
	}
	#reply_btn:hover {
		background-color: #FF5E00;
	}
	.reply_btn {
		background-color: #3498DB;
		padding: 7px 15px;
	    font-size: 14px;
	    border-radius: 25px;
	    color: white;
	    outline: none;
	    border: 0px;
	    cursor: pointer
	}
	.reply_btn:hover {
		box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19);
	}
	.reply_del {
		font-size: 14px;
		color: red;
	}
	.btn-warning {
		background-color: #F39C12;
		margin-left: 5px;
	}
	.btn-danger {
		background-color: #e12e1c;
	}
	.btn-primary {
		float: right;
	}
	#download {
		background-color: white;
		font-size: 17px;
	}
	#answer_btn {
		color: white;
		background-color: #18BC9C;
		margin-right: 10px;
	}
	#smart_form {
		background-color: white;
		border: 1px solid #2C3E50;
		border-radius: 5px;
		padding: 10px;
	}
	.form-group {
		border-radius: 5px;
		border: 1px solid #2C3E50;
		padding: 10px;
		margin-bottom: 10px;
	}
	.form-control {
		font-size: 20px;
		display: block;
		outline: none;
		border: 0px;
	}
	.category_text {
		font-size: 15px;
		display: block;
		margin-bottom: 5px;
		font-style:italic;
		color: #F39C12;
	}
	
	table {
		width: 738px;
		border-collapse: collapse;
		border-radius: 4px;
		border-top: 2px solid black;
		border-bottom: 2px solid black;
		border-left: 0px;
		border-right: 0px;
		margin-bottom: 10px;
		font-size: 17px;
	}
	th, td {
		border: 1px solid black;
		padding-left: 15px;
	}
	th {
		background-color: #2C3E50 !important;
		color: white;
		height: 35px;
		text-align: left;
		width: 20%;
	}
	td {
		height: 35px;
		background-color: white;
	}
	#detailContent {
		padding: 20px;
	}
	i {
		display: inline-block;
		padding-left: 10px;
	}
	i.fa-eye {
		color: #3498DB;
	}
	i.fa-heart {
		color: #e12e1c;
	}
	.reply_logina {
		font-size: 15px;
		font-weight: bold;
		color: #3498DB;
	}
	#frm_reply {
		margin: 0px;
	}
	#modal_all {
     	z-index: 200;
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
	 .error {
		color: #FF3636;
		font-size: 12px;
		display: inline-block;
		display: none;
		margin-top: 10px;
	}
	.btn_like {
	  position: relative;
	  display: inline-block;
	  width: 44px;
	  height: 44px;
	  border: 1px solid #e8e8e8;
	  border-radius: 44px;
	  font-family: notokr-bold,sans-serif;
	  font-size: 14px;
	  line-height: 16px;
	  background-color: #fff;
	  color: #DD5D54;
	  box-shadow: 0 2px 2px 0 rgba(0,0,0,0.03);
	  transition: border .2s ease-out,box-shadow .1s ease-out,background-color .4s ease-out;
	  cursor: pointer;
	  outline: none;
	}
	
	.btn_like:hover {
	  border: 1px solid rgba(228,89,89,0.3);
	  background-color: rgba(228,89,89,0.02);
	  box-shadow: 0 2px 4px 0 rgba(228,89,89,0.2);
	}
	
	.btn_unlike .img_emoti {
	    background-position: -30px -120px;
	}
	
	.img_emoti {
	    display: inline-block;
	    overflow: hidden;
	    font-size: 0;
	    line-height: 0;
	    background: url(https://mk.kakaocdn.net/dn/emoticon/static/images/webstore/img_emoti.png?v=20180410) no-repeat;
	    text-indent: -9999px;
	    vertical-align: top;
	    width: 20px;
	    height: 17px;
	    margin-top: 1px;
	    background-position: 0px -120px;
	    text-indent: 0;
	}
	
	.btn_like .ani_heart_m {
	    margin: -63px 0 0 -63px;
	}
	
	.ani_heart_m {
	    display: block;
	    position: absolute;
	    top: 50%;
	    left: 50%;
	    width: 125px;
	    height: 125px;
	    margin: -63px 0 0 -63px;
	    pointer-events: none;
	}
	
	.ani_heart_m.hi {
	    background-image: url(https://mk.kakaocdn.net/dn/emoticon/static/images/webstore/retina/zzim_on_m.png);
	    -webkit-background-size: 9000px 125px;
	    background-size: 9000px 125px;
	    animation: on_m 1.06s steps(72);
	}
	
	.ani_heart_m.bye {
	    background-image: url(https://mk.kakaocdn.net/dn/emoticon/static/images/webstore/retina/zzim_off_m.png);
	    -webkit-background-size: 8250px 125px;
	    background-size: 8250px 125px;
	    animation: off_m 1.06s steps(66);
	}
	
	@keyframes on_m {
	  from { background-position: 0 }
	  to { background-position: -9000px }
	}
	
	@keyframes off_m {
	  from { background-position: 0 }
	  to { background-position: -8250px }
	}
	
	#wrap_like {
		text-align: center;
	}
	i.fa-heart{
		font-size: 14px;
		padding-right: 5px;
	}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		/* 문서가 준비되면 댓글 목록을 조회하는 AJAX 실행 */
		comment_list();
		
		$("#btn_good").click(function(){
	    	if($(this).hasClass('btn_unlike')){
			    $(this).removeClass('btn_unlike');
			    $('.ani_heart_m').removeClass('hi');
			    $('.ani_heart_m').addClass('bye');
	    	}
	  		else{
			    $(this).addClass('btn_unlike');
			    $('.ani_heart_m').addClass('hi');
			    $('.ani_heart_m').removeClass('bye');
	    	}
		});
	});
	
	function comment_list() {
		$.ajax({
			type: "post",
			url: "commentlist.bizpoll",
			data: "bno=${boardview.bno}",
			success: function(result) {
				$("#commentList").html(result);
			}
		});
	}
	$(document).on("click", "#reply_btn", function(){
		oEditors.getById["replyInsert"].exec("UPDATE_CONTENTS_FIELD", []);
		var content = $("#replyInsert").val();
		
		if(content == "<p><br></p>") {
			$("#replyInsert").focus();			
			$(".error").css("display", "block");
			return false;	
		} else {
			var bno = ${boardview.bno};
			$("#re_bno").val(bno);
		
			$.ajax({
				url: "replyInsert.bizpoll",
				type: "POST",
				data: $("#frm_reply").serialize(),
				contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
				success: function() {
						comment_list();
						$("#replyInsert").val("");
				},
				error: function() {
					alert("System Error!!!");
				}
			});
		}
	});
	$(document).on("click", ".reply_del", function(){
		var rno = $(this).attr("data_num");
		var bno = ${boardview.bno};
		
		$.ajax({
			url: "replyDelete.bizpoll",
			data: "rno=" + rno + "&bno=" + bno,
			success: function(result) {
				comment_list();
			},
			error: function() {
				alert("System Error!!!");
			}
		});
	});
	
	$(document).on("click", "#answer_btn", function(){
		location.href="answer.bizpoll?bno=${boardview.bno}";
	});
	$(document).on("click", "#returnGo", function(){
		location.href = "<%=referer%>";
	});
	$(document).on("click", "#boardUpdate", function(){
		location.href="boardUpdate.bizpoll?bno=${boardview.bno}";
	});
	
	
	$(document).on("click", ".btn-danger", function(){
		var bno = $("#bno").val();
		var replycnt = $("#hidden_replycnt").val();
		
		if(replycnt > 0) {
			alert("댓글이 있는 글은 삭제하실수 없습니다.");
			$("#knboard_detail_rspan").focus();
			return false;
		} else {
			$("#modal_all").css("display", "block");
		}
	});
	$(document).on("click", "#close_btn", function(){
		$("#modal_all").css("display", "none");
	});
	$(document).on("click", "#no_btn", function(){
		$("#modal_all").css("display", "none");
	});
	$(document).on("click", "#yes_btn", function(){
		location.href="boardDelete.bizpoll?bno=${boardview.bno}&filename=${boardview.filename}";
	});
	
	
	
	
	
</script>
</head>
<body>  
	<div id="board_wrap">
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">질문 게시판</h3>
			</div>
			<!-- form속성에 action을 지정하지 않으면 현재 경로를 그대로 action의 대상 경로로 설정 -->
			<form role="form" method="post" id="frm1">
				<input type="hidden" name="bno" id="bno" value="${boardview.bno}">
			</form>

			<div class="box-body">
				<table>
					<tr>
						<th style="border-left: 0px">제목</th>
						<td colspan="3" style="border-right: 0px">
							<span class="category_text">${boardview.bno}번째 글</span>
							<span id="title" class="form-control" >${boardview.title}</span>
						</td>
					</tr>
					<tr>
						<th style="border-left: 0px">작성일</th>
						<td style="width: 30%;"><fmt:formatDate pattern="yyyy-MM-dd" value="${boardview.regdate}" /></td>
						<th style="border-left: 0px;">작성자</th>
						<td style="width: 30%; border-right: 0px;">${boardview.writer}</td>
					</tr>
					<tr>
						<th style="border-left: 0px">첨부파일</th>
						<td colspan="2" style="border-right:0px">
							<c:if test="${boardview.filesize > 0}">
								<div id="download">
								<a href="download.bizpoll?file=${boardview.filename}">${boardview.filename}
																			   (<fmt:formatNumber type="number" pattern="0.0" value="${boardview.filesize / 1024}"></fmt:formatNumber> kb)</a></div>
							</c:if>
						</td>
						<td style="border-left: 0px; border-right: 0px; text-align: center;">
							<i class="fa fa-eye"></i> ${boardview.viewcnt}  <i class="fa fa-heart"></i>${boardview.goodcnt}
						</td>
					</tr>
					<tr>
						<td id="detailContent" colspan="4" style="border-left: 0px; border-right: 0px;">
							${boardview.content}
							<!-- <textarea class="form-control" id="content" name="content" rows="3"
						cols="" readonly="readonly"></textarea> -->
						</td>
					</tr>
				</table>
			</div>
			
			<div id="user_btn">
				<button type="button" id="returnGo" class="reply_btn">게시판 목록</button>
				<button id="answer_btn" class="reply_btn">답변</button>
				
				<c:if test="${sessionScope.loginUser.id == boardview.writer}">
					<button type="submit" class="reply_btn btn-warning btn-primary" id="boardUpdate">수정</button>
					<button type="button" class="reply_btn btn-danger btn-primary" id="boardDelete">삭제</button>
				</c:if>
			</div>
			
			<div id="wrap_like">
				<button type="button" class="btn_like" id="btn_good">
					<span class="img_emoti">좋아요</span>
					<span class="ani_heart_m"></span>
				</button> 
			</div>
		</div>
	</div>

	<div id="reply_wrap">
		<div id="commentList">
		</div>
	</div>
	
	<div id="modal_all"> 	
	     <div id="content_layout">
	     	<div id="modal_header">게시글 삭제 <span id="close_btn"><i class="fa fa-close"></i></span></div>
	     	<div id="modal_content">정말 <span class="point">게시글</span>을 삭제하시겠습니까?</div> 
	        
	        <div class="btn_login">
	        	<a id="no_btn" href="#">아니오</a>
	        	<a id="yes_btn" href="#">네</a>
	        </div>
	     </div>
	</div>
</body>
<%@ include file="../include/footer.jsp" %> 
</html>