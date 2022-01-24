<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head id="head">
<meta charset="UTF-8">
<style type="text/css">
nav {
	float: left;
}

h1 {
	display: inline-block;
	vertical-align: middle;
	color: white;
	margin: 0.5rem;
	padding: 0;
}

ul {
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
}

li.icon {
	flex-basis: 100%;
}

#header {
	background: #26272b;
	padding: 20px;
	text-transform: uppercase;
	margin-top: 150px;
	width :100%;
	left: 0%;
}

.headtap {
	margin-left: 100px;
	font-size: 1vw;
	margin-right: 100px;
	width: 55%;
	height: 5%;
	color: #fff;
	font-size: 16px;
	text-align: center;
	padding: 3px 33px;
	text-decoration: none;
	opacity: 1;
	letter-spacing: 2px;
	text-transform: uppercase;;
}

.headtap:hover {
	height: 100%;
	border: 1px dotted white;
}
</style>

<title>자유게시판</title>
<head>
<a href="http://localhost:8080"><div class="logo">
		<b> T <span> F </span><span> T<span></span></span></b>
		</div>
		</a>
<div id="header">
		<ul>
			<li><a href="champion.do" class="headtap">챔피언 분석</a></li>
			<li><a href="free.do" class="headtap">Tip</a></li>
			<li><a href="duo.do" class="headtap">듀오 게시판</a></li>
			<li><a href="#" class="headtap">대회 분석</a></li>
			<li><a href="map.do" class="headtap">Others</a></li>
		</ul>
	</div>

</head>
<body>
	
</body>
</html>