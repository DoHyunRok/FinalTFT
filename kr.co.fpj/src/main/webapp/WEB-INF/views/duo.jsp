<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/finalcss.css"
	rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>자유 게시판</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sidebar.jsp"></jsp:include>
	<div id="parafree">
		<p id="para">
			<button onclick="sort()" id="cntsort" class="sort" value="cntsort"
				name="cntsort">조회수순</button>
			<button onclick="sort()" id="commentsort" class="sort"
				value="commentsort" name="commentsort">댓글순</button>
			<button onclick="sort()" id="regsort" class="sort" value="regsort"
				name="regsort">등록일순</button>
		</p>
	</div>
	<div class="main">
		<table class="bbs">
			<tr>
				<th width=70px;>글 번호</th>
				<th width=200px colspan="2">글 제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th width=65px;>조회수</th>
			</tr>
			<tbody>

				<c:forEach items="${duoboard}" var="board">
					<tr>

						<td>${board.seq}</td>

						<td colspan="2">[${board.tier1}~${board.tier2}] <a
							href="duoview.do?seq=${board.seq}"> ${board.title}</a></td>

						<td>${board.writer}</td>

						<td>${board.regdate}</td>
						<td>${board.cnt}</td>



					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="duowrite">
			<form action="duowrite.do">
				<input type="submit" value="글쓰기" id="duowrite"><br>
			
			</form>
		</div>
		<br>	<br>	<br>

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>