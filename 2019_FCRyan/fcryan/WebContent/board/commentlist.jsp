<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
	<div id="reply_wrap_title">
		<span id="knboard_detail_rspan">댓글 ${replyList.size()}</span>
		<%-- <input type="hidden" id="hidden_replycnt" value="${boardview.replycnt}"> --%>
	</div>
	
	<div id="detail_reply">
		<c:if test="${replyList.size() == 0}">
			<div class="reply_list">
				<div class="reply_line2">
					등록된 댓글이 없습니다. 첫번째 댓글을 남겨주세요:)
				</div>
			</div>
		</c:if>	
		<c:forEach items="${replyList}" var="replyview">
			<div class="reply_list">
				<div class="reply_line1" style="width: 600px;">
					<a href="#" class="reply_writer">${replyview.writer}</a> 
					<c:if test="${sessionScope.loginUser.id == replyview.writer}">
						<a href="#" class="reply_del" data_num="${replyview.rno}">삭제</a>
					</c:if>
					<span id="replylist_date">
						<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${replyview.regdate}"/>
					</span>
				</div>
				<div class="reply_line2">
					<div class="replylist_textarea" 
						id="replylist_textarea">${replyview.content}</div>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<c:choose>
			<c:when test="${empty sessionScope.loginUser}">
				<div class="reply_login" id="reply_nologin">
					<span class="reply_nologin_span"><a href="login.bizpoll"
						class="reply_logina">로그인</a>을 하시면 댓글을 등록할 수 있습니다.</span>
				</div>
			</c:when>
			<c:otherwise>
				<form action="replyinsert.bizpoll" method="POST" name="frm_reply" id="frm_reply">
					<div id="detail_reply" class="reply_login">
						<div class="reply_list reply_insert">
							<div class="reply_line1">
								<a href="#" class="reply_writer">작성자: ${sessionScope.loginUser.id}</a>
							</div>
							<div class="reply_line2">
								<textarea class="replylist_textarea" name="re_textarea"
									id="replyInsert" rows="" cols="150"
									placeholder="댓글을 남겨보세요."></textarea>
								<script type="text/javascript">
									var oEditors = [];
									nhn.husky.EZCreator.createInIFrame({
									    oAppRef: oEditors,
									    elPlaceHolder: "replyInsert",
									    sSkinURI: "<%=request.getContextPath()%>/smarteditor/SmartEditor2Skin.html",
									    fCreator: "createSEditor2",
									    htParams: { fOnBeforeUnload : function(){} } /* 에디터 내용 변경 경고창 끄기 */
									});
								</script>
								<span class="error">내용을 입력해 주세요.</span>
								<a href="#" class="reply_btn" id="reply_btn">댓글등록</a>
								
								<input type="hidden" name="re_writer" value="${sessionScope.loginUser.id}">
								<input type="hidden" id="re_bno" name="re_bno">
							</div>
						</div>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
</body>
</html>





