<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/finalcss.css" rel="stylesheet" type="text/css"/>
<meta charset="UTF-8">
<title>자유 게시판</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<table class="tap">
		<tr>
			<td><input type="button">인기순</td>
			<td>댓글순</td>
			<td>조회수순</td>
			<td>최신순</td>
		</tr>
	</table>

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

					<td colspan="2">[${board.tier1}~${board.tier2}] <a href="duoview.do?seq=${board.seq}">
							${board.title}</a></td>

					<td>${board.writer}</td>

					<td>${board.regdate}</td>
					<td>${board.cnt}</td>



				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="duowrite.do" class="tapbutton-right">글쓰기</a>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>