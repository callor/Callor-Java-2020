<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<style type="text/css">

.content {
	width: 1000px;
	box-sizing: border-box;
	border: 1px solid black;
	border-radius: 25px;
	margin: 230px auto 40px;
	padding: 20px;
	box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19);
}
table {
	width: 960px;
	border: 1px solid black;
	border-collapse: collapse;
	border-radius: 4px;
}
th, td {
	border: 1px solid black;
}
th {
	font-size: 20px;
	background-color: #2C3E50 !important;
	color: white;
	height: 35px;
}
td {
	height: 35px;
	background-color: white;
	text-align: center;
}
td:nth-child(2) {
	text-align: left;
	padding-left: 10px;
}
.btn {
	padding: 7px 15px;
	font-size: 14px;
	border-radius: 25px;
	background-color: #F39C12;
	color: white;
	outline: none;
	border: 0px;
	float: right;
	cursor: pointer;
}
.btn:hover {
	box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19);
	background-color: #FF5E00;
}


.pagination > li {
	display: inline-block;
	border: 1px solid black;
	height: 24px;
	text-align: center;
	border-radius: 4px;
	vertical-align: middle;
}
a {
	text-decoration: none;
	color: inherit;
}
.text_center {
	text-align: center;
}
h3 {
	display: inline-block;
}
.board_pagination {
	clear: both;
	text-align: center;
}
.active {
	background-color: #2C3E50 !important;
	color: white;
}
#div_search {
	float: right;
	margin: 10px 0 20px;
}
#search_board {
	height: 29px;
	width: 200px;
	margin: 0 10px;
	border: 1px solid #CCCCCC;
	border-radius: 25px;
	outline: none;
	padding-left: 8px;
}
.btn_search {
	margin-top: 0;
}
#selsearch {
	height: 29px;
	width: 100px;
	font-size: 15px;
	float: left;
	border-radius: 25px;
	outline: none;
}
#search_result {
	margin: 15px 0px 15px;
	font-size: 20px;
	display: inline-block;
}
.search_span {
	color: #E71D36;
	font-weight: bold;
}

.new_time {
	background-color: #FF8224;
	font-size: 11px;
	color: white;
	border-radius: 25px;
	padding: 2px 5px;
	animation-name: twinkle;
    animation-duration: 1.2s;
    animation-iteration-count: infinite;
}
.replyCnt_Color {
	background-color: rgb(231, 29, 54);
	font-size: 11px;
	color: white;
	border-radius: 25px;
	padding: 2px 5px;
}

@keyframes twinkle {
    0%   {opacity: 0;}
    100% {opacity: 1;}
}
.box-title {
	margin: 20px 0 10px 0;
	display: block;
	font-size: 35px;
}
#order_board {
	display: inline-block;
}
#order_board > span {
	margin-right: 8px;
	display: inline-block;
	height: 29px;
	line-height: 40px;
}
.box-body {
	margin-top: 7px;
}
.good_cnt {
	color: #FF0000;
}
.good_cnt > i {
	font-size: 12px;
	margin-right: 2px;
	display: inline-block;
}
.pagination * {
	font-family: 'Sunflower', sans-serif!important;
	font-weight: bold;
	display: inline-block;
	height: 24px;
}

.pagination a {
	padding: 0px 7px;
	line-height: 24px;
}
#order_board > span {
	cursor: pointer;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		var code = $("#code").val();
		if(code == "new") {
			$("#orderNew").css("color", "#E71D36").css("font-weight", "bold").css("text-decoration", "underline");
		} else if(code == "good") {
			$("#orderGood").css("color", "#E71D36").css("font-weight", "bold").css("text-decoration", "underline");
		} else if(code == "reply") {
			$("#orderReply").css("color", "#E71D36").css("font-weight", "bold").css("text-decoration", "underline");
		} else if(code == "cnt") {
			$("#orderCnt").css("color", "#E71D36").css("font-weight", "bold").css("text-decoration", "underline");
		} 
		
		// 게시글 등록 버튼 클릭시 이벤트 처리
		$("#boardAdd").on("click", function() {
			location.href = "boardInsert.bizpoll";
		});
		
		$("td").hover(function(){
			$(this).parent().children().css("background-color", "#DDDDDD");
		}, function(){
			$(this).parent().children().css("background-color", "white");
		});
	});
	
	$(document).on("click", "#search_btn", function(){
		var flag = $("#selsearch").val();
		var keyword = $("#search_board").val();
		location.href="boardList.bizpoll?flag="+flag+"&keyword="+keyword;
	});

</script>
</head>
<body>
	<section class="content">
		<div class="row">
			<!-- left column -->
			<div class="col-md-12">
				<!-- general form element -->
				<div class="box">
					<h3 class="box-title">질문 게시판</h3>
					<div>
						<div id="order_board">
							<input type="hidden" value="${code}" id="code">
							<span><a href="boardList.bizpoll?flag=${flag}&keyword=${keyword}&key=new" id="orderNew">최신순</a></span>
							<span><a href="boardList.bizpoll?flag=${flag}&keyword=${keyword}&key=good" id="orderGood">추천순</a></span>
							<span><a href="boardList.bizpoll?flag=${flag}&keyword=${keyword}&key=reply" id="orderReply">댓글순</a></span>
							<span><a href="boardList.bizpoll?flag=${flag}&keyword=${keyword}&key=cnt" id="orderCnt">조회순</a></span>
						</div>						
						<button class="btn btn-primary" id="boardAdd">게시글 등록</button>
					</div>
				</div>

				<div class="box-body">
					<table class="table table-boarded">
						<tr style="width: 10px">
							<th style="width: 50px">No.</th>
							<th style="width: 450px">제목</th>
							<th style="width: 120px">작성자</th>
							<th style="width: 130px">작성일</th>
							<th style="width: 60px">좋아요</th>
							<th style="width: 60px">조회수</th>
							<th style="width: 60px">첨부</th>
						</tr>
						<c:forEach items="${boardList}" var="bDto">
							<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="today2"/>
							<fmt:formatDate value="${bDto.regdate}" pattern="yyyy-MM-dd" var="regdate2"/>
							<tr>
								<td class="text_center">${bDto.bno}</td>
								<td class="title_table"><a href="boardViewcnt.bizpoll?bno=${bDto.bno}">
								<!-- 답글 들여쓰기 -->
								<%-- <c:forEach var = "i" begin = "1" end = "${bDto.re_level}">
									&nbsp;&nbsp;
								</c:forEach> --%>
								${bDto.title}
								
								<c:if test="${bDto.replycnt > 0}">
									<span class="replyCnt_Color">${bDto.replycnt}</span>
								</c:if>
								
								<c:if test="${today2 == regdate2}">
									<span class="new_time">New</span>
								</c:if>
								
								</a></td>
								<td>${bDto.writer}</td>
								<td class="text_center">
								
								<c:choose>
									<c:when test="${today2 == regdate2}">
										<fmt:formatDate pattern="HH:mm:ss" value="${bDto.regdate}"/>
									</c:when>
									<c:otherwise>
										<fmt:formatDate pattern="yyyy-MM-dd" value="${bDto.regdate}" />
									</c:otherwise>
								</c:choose>
								</td>
								<td class="text_center"><span class="good_cnt"><i class="fa fa-heart"></i></span>${bDto.goodcnt}</td>
								<td class="text_center">${bDto.viewcnt}</td>
								<td class="text_center">
									<c:if test="${bDto.filesize > 0}">
										<i class="fa fa-floppy-o"></i>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div id="div_search">
							<select id="selsearch" name="selsearch">
					          <option value="3" selected="selected">-조건 선택-</option>
							  <option value="1">제목</option>
							  <option value="2">내용</option>
							  <option value="3">제목+내용</option>
							  <option value="4">작성자</option>
							</select>
							
							
							<input type="text" placeholder="검색할 값을 입력하세요." id="search_board" name="search_board">
							<a href="#" id="search_btn" class="btn btn_search">검색</a>
					</div>
					
				<c:if test="${!empty keyword}">
					<div id="search_result">
						<span class="search_span">"${keyword}"</span>로 검색한 결과는 총 
						<span class="search_span">${totalCount}</span>건입니다.
					</div>
				</c:if>
					



					<div class="board_pagination">
						<ul class="pagination">
							<c:if test="${pageMaker.prev}">
								<li>
									<a href="boardList.bizpoll?page=${pageMaker.startPage - 1}">&laquo;</a>
								</li>
								<li>
									<a href="boardList.bizpoll?page=1">1</a>
								</li>
								<li>
									<a>...</a>
								</li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage}"
								end="${pageMaker.endPage}" var="idx">
								<li <c:out value="${pageMaker.criDto.page == idx ? 'class=active':''}"/>>
									<a href="boardList.bizpoll?page=${idx}&flag=${flag}&keyword=${keyword}&key=${code}">${idx}</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next}">
								<li>
									<a>...</a>
								</li>
								<li>
									<a href="boardList.bizpoll?page=${pageMaker.finalPage}">${pageMaker.finalPage}</a>
								</li>
								<li>
									<a href="boardList.bizpoll?page=${pageMaker.endPage + 1}">&raquo;</a>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
<%@ include file="../include/footer.jsp" %> 
</html>