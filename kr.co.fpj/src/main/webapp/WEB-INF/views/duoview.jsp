<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/finalcss.css" rel="stylesheet" type="text/css"/>
<meta charset="UTF-8">
<title>게시판 보기</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

		<div class="row">

			<table class="writebbs">

				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">게시판
							글쓰기 보기</th>
					</tr>

				</thead>
				<c:forEach items="${duoboard}" var="board">
					<tbody>

						<tr>
							<td style="width: 20%;">글 제목</td>
							<td colspan="2">${board.title }</td>
						</tr>

						<tr>
							<td>작성자</td>
							<td colspan="2">${board.writer }</td>
						</tr>
						<tr>
							<td>작성일자</td>
							<td>${board.regdate }</td>

						</tr>
						<tr>
							<td>조회수</td>
							<td>${board.cnt}</td>

						</tr>
						<tr>
							<td>내용</td>
							<td colspan="2" style="height: 500px;">${board.content}</td>
						</tr>
				</c:forEach>

			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>