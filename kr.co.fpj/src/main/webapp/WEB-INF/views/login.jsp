<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/finalcss.css"
	rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<style>
body {
	background-image: url("resources/image/TFT.png");
	background-size: cover;
	background-repeat: no-repeat;
}

.loginbox {
	width:100%
}

.loginform {
	display: block;
	width: 100%;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
	margin:5px;
}
.submitbutton{
	margin:5px;
	width: 113.5%;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	color: #555;
	background-color: #66fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;`
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;

}
.loginreg{
	padding: 6px 12px;
	text-align: center;
	position: relative;
	margin-left: 40px;
}
.logjoin{
	text-decoration: none;
	color: white;
}
</style>
<title>로그인</title>
</head>
<body>
	<div class="loginbox">
		<form action="login.do" method="post">
			<div>
				<input type="text" placeholder="ID" class="loginform">
			</div>
			<div>
				<input type="password" placeholder="Password" class="loginform">
				<input type="submit" value="로그인" class="submitbutton">
			</div>
			<div class="loginreg">
				<a href="join.do" class="logjoin">회원가입</a>
			</div>
		</form>
	</div>
</body>
</html>
