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
	
	.form-control {
		width: 739px;
		box-sizing: border-box;
		font-size: 17px;
		padding: 5px;
	}
	#writer {
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
	.btn {
		padding: 7px 15px;
	    font-size: 14px;
	    border-radius: 25px;
	    background-color: #F39C12;
	    color: white;
	    outline: none;
	    border: 0px;
	    cursor: pointer;
	}
	.btn-file {
		background-color: #3498DB; 
	}
	.btn-file:hover {
		background-color: #0054FF!important; 
	}
	.btn:hover {
		box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19);
		background-color: #FF5E00;
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
	.form-group {
		margin-bottom: 20px;
	}
	.error {
		color: #FF3636;
		font-size: 12px;
		display: inline-block;
		display: none;
		margin-top: 8px;
	}
	#file_wrap > *{
		float: left;
		margin-right: 8px;
	}
	.files {
		display: inline-block;
		height: 29px;
		line-height: 31px!important;
		cursor: pointer;
		font-size: 15px;
	}
	#close_btn {
		line-height: 29px;
		cursor: pointer;
		font-size: 15px;
	}
	#close_btn:hover {
		font-size: 25px;
	}
</style>
<script type="text/javascript" src="<%=path%>/smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
	$(document).on("click", ".btn-primary", function(elClickedObj){
		var title = $("#title").val();
		// 스마트에디터로 content부분 값 넘겨받는 부분
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		
		if(title == "") {
			$("#title").focus();
			$(".error").css("display", "block");
			return false;
		}
		$("#frm_bin").submit();
	});
	
	$(document).on("blur", "#title", function(){
		var title = $("#title").val();
		
		if(title == "") {
			$(".error").css("display", "block");
		} else {
			$(".error").css("display", "none");
		}
	});
	
	$(document).on("click", ".btn-file", function(){
		$("#uploadfile").click();
	});
	
	$(document).on("change", "#uploadfile", function(){
		var filesize = $(this)[0].files;
		if(filesize.length < 1) {
			$("#file-name").text("선택된 파일 없음");
			$("#close_btn").css("display", "none");
		} else {
			var filename = this.files[0].name;
			var size = this.files[0].size;
			var maxSize  = 10 * 1024 * 1024;
			
	        if(size > maxSize)
	        {
	            alert("첨부파일 사이즈는 10MB 이내로 등록 가능합니다.");
	            $("#file-name").text("선택된 파일 없음");
	            $("#uploadfile").val("");
	            $("#now-file-size").val(0);
	        } else {
	        	$("#file-name").text(filename);
				$("#close_btn").css("display", "block");	
	        }

		}
	});
	

	
	$(document).on("click", "#close_btn", function(){
		$("#uploadfile").replaceWith($("#uploadfile").clone(true));
		$("#uploadfile").val("");
		$("#file-name").text("선택된 파일 없음");
		$("#close_btn").css("display", "none");
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
			<form role="form" id="frm_bin" name="frm_bin" action="boardInsertPlay.bizpoll" method="post" enctype="multipart/form-data">

			<div class="box-body">
				<div class="form-group">
					<label for="title">제목</label> 
					<input type="text" id="title" name="title" class="form-control">
					<span class="error">제목을 입력해 주세요.</span>
				</div>
				<div class="form-group" style="width: 750px;">
					<label for="content">내용</label>
					<textarea class="form-control" id="content" name="content" rows="10" cols="100"></textarea>
					
				</div>
				<div class="forn-group">
					<label for="writer">작성자</label> <input type="text" id="writer" name="writer" class="form-control" value="${sessionScope.loginUser.id}" readonly="readonly">
				</div>
				<div id="file_wrap">
					<input type="file" name="uploadfile" id="uploadfile" style="display: none;">
					<input type="button" class="btn btn-file" value="파일 선택"> 
					<span class="files" id="file-name" style="height: 29px; border: none;" >선택된 파일 없음</span> 
					<i class="fa fa-close" id="close_btn" style="display: none"></i>
				</div>
			</div>
			<div>
				<button class="btn btn-primary">게시글 등록</button>
			</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
		    oAppRef: oEditors,
		    elPlaceHolder: "content",
		    sSkinURI: "<%=path%>/smarteditor/SmartEditor2Skin.html",
		    fCreator: "createSEditor2"
		});
	</script>
</body>
<%@ include file="../include/footer.jsp" %> 
</html>








