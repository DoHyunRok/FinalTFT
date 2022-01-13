<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul, li{
	margin:0;
	padding:0;
	list-style: none;
}
#wrapper{
	display: table;
	width: auto;
	height: auto;
	margin:0 auto;
}
hr{
	border:1px;
	solid: #e6e6e6;
	margin:25px 0 25px 0;
}
#top{
	width:100%;
	text-align:center;
	clear: both;
	margin:0 0 30px 0;
}
#content{
	width:100%
}
.form_design ul{
	width:100%;
	hegiht:45px;
}
.form_design li{
	float:left;
}
.form_design li:first-child{
	width:150px;
	padding: 6px 0 0 0;
}
.form_design li input{
	width:300px;
	height:30px;
}
.form_design li .check{
	width:100px; margin: 0 0 0 10px; background-color:#999999;
	color:#fff; clear:both;
}
.form_design ul {
	float:left;
	margin-bottom: 5px;
}

	

</style>
</head>
<body>
<div id = "wrapper">
	<div id="top">
	<div class="logo">로고</div>
		<ul><h2> 가입 정보 입력</h2></ul>
		<ul>로그인 정보 및 가입 정보를 입력하세요</ul>
	</div>
</div>
<div id="content">
	<form class="form_design">
		<hr>
		<ul>
			<li>아이디</li>
			<li><input type="text" placeholder="ID" class="loginform" id="id" name="id"></li>
			<li><button type="button" onclick="check();" class="check">중복체크</button></li>
		</ul>
		<ul>
			<li>비밀번호</li>
			<li><input type="password" placeholder="Password" class="loginform" name="password1" id="password1"></li>
		</ul>	
		<ul>
			<li>비밀번호 재확인</li>
			<li><input type="password" placeholder="PasswordCheck" class="loginform" name="password2" id="password2"></li>
		</ul>	
		<ul>
			<li>롤 닉네임 입력</li>
			<li><input type="text" class="loginform" placeholder ="LoL NickName"></li>
		</ul>
		
	
	</form>

</div>
</body>
</html>