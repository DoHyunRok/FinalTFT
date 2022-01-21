<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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

nav {
	display: inline-block;
	vertical-align: middle;
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

header {
	background: #9999ff;
	padding: 20px;
}

.headtap {
	display: block;
	margin-left: 100px;
	font-size: 1vw;
	margin-right: 100px;
	width: 55%;
	height: 5%;
	color: white;
	text-align: center;
	padding: 3px 33px;
	text-decoration: none;
	opacity: 0.5;
}

.headtap:hover {
	height: 110%;
	background-color: gray;
}

html {
	box-sizing: border-box;
}

*, *:before, *:after {
	box-sizing: inherit;
}

.logo {
	height: 110px;
	text-align: center;
	border: 1px solid black;
	width: 100%;
	margin-bottom: 5px;
}
</style>

<title>자유게시판</title>
</head>
<body>
	<a href="http://localhost:8080"><div class="logo"></div></a>
	<header>

			<ul>
				<li><a href="champion.do" class="headtap">챔피언 분석</a></li>
				<li><a href="free.do" class="headtap">Tip</a></li>
				<li><a href="duo.do" class="headtap">듀오 게시판</a></li>
				<li><a href="#" class="headtap">대회 분석</a></li>
				<li><a href="map.do" class="headtap">Others</a></li>
			</ul>
	</header>
	<br>
	<br>

</body>
</html>