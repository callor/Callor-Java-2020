<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
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
	margin: 30px auto;
	border-radius: 4px;
	box-sizing: border-box;
	border-top: 20px solid #E71D36;
	padding: 20px;
	padding-bottom: 40px;
}

.box-title {
	margin: 0px;
	margin-bottom: 10px;
}

.form-control {
	width: 739px;
	box-sizing: border-box;
	font-size: 17px;
	margin-bottom: 10px;
}

label {
	font-size: 17px;
	color: black;
	display: block;
}

#content {
	resize: none;
}

#reply_wrap {
	margin: 0 auto;
	border: 1px solid black;
	width: 800px;
	box-sizing: border-box;
	border-radius: 4px;
}

#reply_wrap_title {
	height: 40px;
	margin: 0px;
	border-bottom: 1px solid black;
	background-color: #E71D36;
}

#knboard_detail_rspan {
	color: white;
	font-size: 15px;
	line-height: 40px;
	padding-left: 10px;
}

#detail_reply {
	width: 799px;
	padding: 20px;
	box-sizing: border-box;
}

.box {
	margin: 10px;
}

.reply_list {
	border: 1px solid black;
	border-radius: 4px;
	padding: 10px;
	margin: 10px;
	background-color: white;
}

.reply_writer {
	color: black;
	font-weight: bold;
	font-size: 16px;
	text-decoration: none;
}

#replylist_date {
	float: right;
	color: black;
}

.replylist_textarea {
	padding: 5px;
	width: 718px;
	resize: none;
	border-radius: 4px;
	box-sizing: border-box;
	border: 1px solid #BBBBBB;
	font-size: 13px;
}

.reply_login {
	border-top: 1px solid black;
	padding-left: 10px;
}

#reply_nologin {
	
}

.reply_nologin_span {
	width: 14px;
	line-height: 40px;
	font-size: 12px;
}

.reply_btn {
	padding: 6px 10px;
	font-size: 14px;
	border-radius: 4px;
	background-color: black;
	color: white;
	margin-top: 10px;
	outline: none;
	border: 0px;
}
.reply_del {
	font-size: 14px;
	color: red;
}
.btn-warning {
	background-color: #ff9800;
}
.btn-danger {
	background-color: #da190b;
}
.btn-primary {
	float: right;
}
#download {
	background-color: white;
	border: 1px solid #BBBBBB;
	font-size: 17px;
}
#answer_btn {
	color: white;
	background-color: orange;
	margin-right: 10px;
}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
	
	
	
	$(document).on("click", ".btn-primary", function(elClickedObj){
		alert("test");
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		
		
		$("#frm_bin").submit();
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
			<form role="form" id="frm_bin" name="frm_bin" action="answerinsertsave.bizpoll" method="post" enctype="multipart/form-data">
				<input type="hidden" name="bno" id="bno" value="${bDto.bno}">

			<div class="box-body">
				<div class="form-group">
					<label for="title">제목</label> <input type="text" id="title" name="title" class="form-control" value="└ ${bDto.title}" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="content">내용</label>
					<textarea class="form-control" id="content" name="content" rows="10" cols="100">${bDto.content}</textarea>
					
				</div>
				<div class="forn-group">
					<label for="writer">작성자</label> <input type="text" id="writer" name="writer" class="form-control" value="${sessionScope.loginUser.mid}" readonly="readonly">
				</div>
				<div><input type="file" name="uploadfile" id="uploadfile"></div>
			</div>
			<div>
				<button class="btn btn-primary">답변 등록</button>
			</div>
			</form>
		</div>
	</div>
		<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
		    oAppRef: oEditors,
		    elPlaceHolder: "content",
		    sSkinURI: "smarteditor/SmartEditor2Skin.html",
		    fCreator: "createSEditor2"
		});
	</script>
</body>
</html>