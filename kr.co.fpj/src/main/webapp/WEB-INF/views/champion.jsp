<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/finalcss.css"
	rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>챔피언 분석</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<table border="1">
		<%
			int i = 0;
		while (i < 143) {
			i++;
		%>
		<%
			if (i % 5 == 1) {
		%>
		<tr>
			<%
				}
			%>
			<td><img src="resources/champion/AA (<%=i%>).png" alt=""
				width="70" ,height="70"></td>

			<%
				}
			%>
		
	</table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>