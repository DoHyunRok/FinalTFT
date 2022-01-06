<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#champname').keyup(function() {
			if ($('#champname').val() == '가렌') {
				$('#champsearch').html('<td><a href="#">가렌</a</td> <td> <br><br>')
				$('#champsearch').attr('color', '#f82a2aa3');
			}
		})
	});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<th>캐릭터 검색</th>
		<tbody>
			<tr>
				<form method="post" action="champ.do">
				<input type="text" id ="champname">
			</tr>
			<tr>
				<font id="champsearch" size='2'></font>
			</tr>
		</form>
		</tbody>
	</table>
</body>
</html>