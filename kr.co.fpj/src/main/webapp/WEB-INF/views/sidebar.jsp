<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
			<form method="post" action="sidebar.do">
				<table border="1">
					<thead>
						<tr>
							<th colspan="4">챔피언 검색</th>
						</tr>
					</thead>
					<tr>
						<td colspan="3"><input type="text" id="champname"></td> 
						<td colspan="1"><input type="submit" id=champsearch></td>
					</tr>
					<c:forEach items="${sideboard}" var="champ">
						<tr>
							<td colspan="1">${champ.champname}</td>
							<td colspan="3">${champ.player}</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
</body>
</html>