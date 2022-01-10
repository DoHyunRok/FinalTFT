<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<link href="${pageContext.request.contextPath}/resources/css/finalcss.css"
	rel="stylesheet" type="text/css" />
	
	
<div>
<html lang="ko" id = "all">
<style>

</style>
<script src="https://code.jquery.com/jquery-3.5.1.js"
integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
crossorigin="anonymous">
</script>

<head>

</head>
<title>TFT</title>

<body>
	<div id="IdSearch">
		<form action="" method="">
			<input type="text" placeholder="아이디를 입력해주세요" id = "Search">
			<input type="submit" value="검색" id = "IdBtn">
		</form>
	</div>

	<div id="KakaoLogin">
		<a href="https://kauth.kakao.com/oauth/authorize
            ?client_id=	00da4a8c1af4d8dc872603672e5439d3
            &redirect_uri=http://localhost:8080/fpj/          
            &response_type=code">
            <img src="resources/image/KakaoLoginBtn.png">
			<form action="" method="">
			<c:if test="${userId eq null}">
			</a>
		</c:if>
	</div>

</body>
</html>
</div>	