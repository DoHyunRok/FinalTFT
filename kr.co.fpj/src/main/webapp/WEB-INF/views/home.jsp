<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<link
	href="${pageContext.request.contextPath}/resources/css/finalcss.css"
	rel="stylesheet" type="text/css" />


<html lang="ko">
<style>
body {
	background-image: url("resources/image/TFT.png");
	background-size: cover;
	background-repeat: no-repeat;
}


</style>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<head>

</head>
<title>TFT</title>

<body>
	<div  id="content">
		<form action="http://127.0.0.1:5000/param" method="get">
		<select name="po" class="po"
			style="height: 30px; border-radius: 10px;">
			<option value="supoter" selected>Supporter</option>
			<option value="jungle">Jungle</option>
			<option value="top" selected>Top</option>
			<option value="mid">Mid</option>
			<option value="bottomr" selected>Bottom</option>
		</select>
		<input type="text" name="name" placeholder="아이디를 입력해주세요"
			style="width: 200px; height: 50px; font-size: 15; opacity: 0.5; border-radius: 10px;">
		<input type="image" src="../image/" class ="search"
			style="border-radius: 10px; height: 30px; width: 50px;">
		</form>
	</div>


	<div id="homelogin">
		<form action="login.do">
			<input type="submit" value="로그인"
				style="width: 120px; height: 50px; font: white;" id="homeloginbox">
			<p class="arrow_box">
				아이디가 없으신가요?<br>회원가입시 더 많은 <br>컨텐츠를 즐기실수 있습니다 !
			</p>
		</form>
	</div>

	<div id="KakaoJoin">
		<a
			href="https://kauth.kakao.com/oauth/authorize?client_id=00da4a8c1af4d8dc872603672e5439d3&redirect_uri=http://localhost:8080/login&response_type=code">
			<img src="resources/image/KakaoLoginBtn.png">
		</a>
	</div>

</body>
</html>
