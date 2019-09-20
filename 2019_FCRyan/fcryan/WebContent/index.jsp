<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- index.jps 페이지에 header.jsp 페이지를 추가 -->    
<%@ include file="include/header.jsp" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FCRyan</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Mali');
	#indexbody {
		padding-top: 200px;
	}
	#test {
		padding: 2000px 0;
	}
	.pdt_wrap {
		width: 1400px;
		margin: 15px auto;
		padding: 15px 30px 15px 50px;
		border-radius: 25px;
	} 
	.pdt_wrap:nth-child(2n) {
		background-color: #ecf0f1;
	}
	.pdt_wrap > div > span {
		font-size: 42px;
		display: block;
		padding-bottom: 20px;
		font-family: 'Mali', cursive;
		font-weight: bold;
	}
	.card {
		border: 5px solid #2C3E50;
		display: inline-block;
		margin: 0px 16px 35px 0px;
		border-radius: 25px;
		cursor: pointer;
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	}
	.card_img {
		overflow: hidden;
	    background-color: white;
	    border-radius: 20px 20px 0 0;
	}
	.card_img > img {
		width: 220px;
		height: 320px;
		padding: 15px;
	}
	.card_title{
		background-color: #2C3E50;
		color: white;
		text-align: center;
		font-size: 20px;
	}
	.card_title > span {
		display: block;
		padding: 10px;
		background-color: #18BC9C;
		border-top: 5px solid #2C3E50;
	}
	.card_content {
		background-color: #2C3E50;
		color: white;
		text-align: left;
		font-size: 15px;
		padding: 10px;
		border-radius: 0 0 16px 16px;
	}
	.card_content > span{
		display: block;
		padding: 5px 10;
	}
	#rank_wrap {
		width: 100%;
		padding: 10px 0 15px;
	}
	#rank_wrap > div {
		width: 256px;
		border: 0px;
		font-size: 25px;
		text-align: center;
		margin: 0 20px 0 0;
		font-family: 'Mali', cursive;
		color: #F39C12;
		font-weight: bold;
		border-radius: 25px;
		background-color: #ecf0f1 ;
		padding: 2px 0px;
	}
	.good_cnt {
		color: #FF0000;
	}
</style>
<script type="text/javascript">
	/* 뒤로가기 막기  */
	history.pushState(null, null, location.href);
	window.onpopstate = function () {
	    history.go(1);
	};
</script>
</head>
<body id="indexbody">
	<div id="wrap">
		<div id="best_pdt" class="pdt_wrap">
			<div><span>Best Football Teams</span></div>
			<div id="rank_wrap">
				<div class="card">Rank 1</div>
				<div class="card">Rank 2</div>
				<div class="card">Rank 3</div>
				<div class="card">Rank 4</div>
				<div class="card">Rank 5</div>
			</div>
			<c:forEach items="${bestlist}" var="bestDto">
				<div class="card">
					<div class="card_img">
						<img src="img/${bestDto.p_img}">
					</div>
					<div class="card_title">
						<span>${bestDto.p_name}</span>
					</div>
					<div class="card_content">
						<span>연고지: ${bestDto.p_local}</span>
						<span>홈구장: ${bestDto.p_statidum}</span>
						<fmt:setLocale value="en_us"/>
						<span>가격: <fmt:formatNumber value="${bestDto.p_price}" type="currency"/></span>
						<span><span class="good_cnt"><i class="fa fa-heart"></i></span> ${bestDto.p_good}</span>
					</div>
				</div>
			</c:forEach>
		</div>
		<div id="new_pdt" class="pdt_wrap">
			<div><span>New Football Teams</span></div>
			<c:forEach items="${newlist}" var="newDto">
				<div class="card">
					<div class="card_img">
						<img src="img/${newDto.p_img}">
					</div>
					<div class="card_title">
						<span>${newDto.p_name}</span>
					</div>
					<div class="card_content">
						<span>연고지: ${newDto.p_local}</span>
						<span>홈구장: ${newDto.p_statidum}</span>
						<span>가격: <fmt:formatNumber value="${newDto.p_price}" type="currency"/></span>
						<span><span class="good_cnt"><i class="fa fa-heart"></i></span> ${newDto.p_good}</span>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<div id="spain_club" class="pdt_wrap">
			<div><span>La Liga (SPAIN)</span></div>
			<c:forEach items="${spainList}" var="spainDto">
				<div class="card">
					<div class="card_img">
						<img src="img/${spainDto.p_img}">
					</div>
					<div class="card_title">
						<span>${spainDto.p_name}</span>
					</div>
					<div class="card_content">
						<span>연고지: ${spainDto.p_local}</span>
						<span>홈구장: ${spainDto.p_statidum}</span>
						<span>가격: <fmt:formatNumber value="${spainDto.p_price}" type="currency"/></span>
						<span><span class="good_cnt"><i class="fa fa-heart"></i></span> ${spainDto.p_good}</span>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<div id="england_club" class="pdt_wrap">
			<div><span>Premier League (UNITED KINGDOM)</span></div>
			<c:forEach items="${englandList}" var="englandDto">
				<div class="card">
					<div class="card_img">
						<img src="img/${englandDto.p_img}">
					</div>
					<div class="card_title">
						<span>${englandDto.p_name}</span>
					</div>
					<div class="card_content">
						<span>연고지: ${englandDto.p_local}</span>
						<span>홈구장: ${englandDto.p_statidum}</span>
						<span>가격: <fmt:formatNumber value="${englandDto.p_price}" type="currency"/></span>
						<span><span class="good_cnt"><i class="fa fa-heart"></i></span> ${englandDto.p_good}</span>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<div id="germany_club" class="pdt_wrap">
			<div><span>Bundesliga (GERMANY)</span></div>
			<c:forEach items="${germanyList}" var="germanyDto">
				<div class="card">
					<div class="card_img">
						<img src="img/${germanyDto.p_img}">
					</div>
					<div class="card_title">
						<span>${germanyDto.p_name}</span>
					</div>
					<div class="card_content">
						<span>연고지: ${germanyDto.p_local}</span>
						<span>홈구장: ${germanyDto.p_statidum}</span>
						<span>가격: <fmt:formatNumber value="${germanyDto.p_price}" type="currency"/></span>
						<span><span class="good_cnt"><i class="fa fa-heart"></i></span> ${germanyDto.p_good}</span>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<div id="italy_club" class="pdt_wrap">
			<div><span>Serie A (ITALY)</span></div>
			<c:forEach items="${italyList}" var="italyDto">
				<div class="card">
					<div class="card_img">
						<img src="img/${italyDto.p_img}">
					</div>
					<div class="card_title">
						<span>${italyDto.p_name}</span>
					</div>
					<div class="card_content">
						<span>연고지: ${italyDto.p_local}</span>
						<span>홈구장: ${italyDto.p_statidum}</span>
						<span>가격: <fmt:formatNumber value="${italyDto.p_price}" type="currency"/></span>
						<span><span class="good_cnt"><i class="fa fa-heart"></i></span> ${italyDto.p_good}</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
<%@ include file="include/footer.jsp" %> 
