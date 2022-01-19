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
	<div id="IdSearch">
		<form action="http://127.0.0.1:5000/param" method="get">
			<input type="text" name="name" value=""
				placeholder="input your name here"> <select name="po"
				class="po">
				<option value="supoter" selected>supoter</option>
				<option value="jungle">jungle</option>
				<option value="top" selected>top</option>
				<option value="mid">mid</option>
				<option value="bottomr" selected>bottom</option>
			</select> <input type="submit">
		</form>

	</div>

	<div id="KakaoLogin">
		<a
			href="https://kauth.kakao.com/oauth/authorize?client_id=	a3a2eb99f69485ea774186c509f3bea3&redirect_uri=http://localhost:8080/login&response_type=code">
			<img src="resources/image/KakaoLoginBtn.png">
		</a>
	</div>

</body>
</html>
