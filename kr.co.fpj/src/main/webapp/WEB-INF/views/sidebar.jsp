<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/finalcss.css"
	rel="stylesheet" type="text/css" />


<meta charset="UTF-8">
<title>sidebar</title>
</head>
<body>
	<div class="sidebar" style="border: 1px solid black";>
		<table border="1" style="position: relative;">
			<thead>
				<tr>
					<th colspan="4" style="position: relative;">챔피언 검색</th>
				</tr>
			</thead>
			<tr>

				<td colspan="4"><input type="text" id="champname"> <input
					type="submit" id=champsearch onclick="champsearch()" value="검색">
					</td> 
				
			</tr>
			<tbody id="boardList">
				<c:forEach items="${sideboard}" var="board">
					<tr id="searchrow">
						<td id="searchd">${board.champname}</td>
						<td id="searchd">${board.player}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		function champsearch() {
			var champname = $('#champname').val();
			$.ajax({
				data : {
					"champname" : champname
				},
				url : "sidebar.do",
				type : "POST",
				success : function(data) {
					if (data.length === 0) {
						alert("챔프가 없습니다.")
					} else {
						$('#boardList').empty();
						var result = data;
						console.log(result);
						var str = '<TR id="searchrow">';
						$.each(result, function(i) {
							str += '<TD id="searchd">' + result[i].champname
									+ '</TD><TD>' + result[i].player + '</TD>'
							str += '</TR id="searchrow">'
							console.log(str)
						});
					}
					$("#boardList").append(str);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("에러발생")
				}
			});
		}
	</script>
</body>
</html>