<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/finalcss.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
	function boardcheck(){
		var title = $("#title").val();
		$.ajax({
			type: 'POST',
			url : "boardcheck.do",
			data : "title=" + title,
			dataType : "json",
			var cnt1 = data.cnt1;
			console.log(cnt1)
			if(cnt>0){
				alert("글이 작성되었습니다.");
			}else{
				alert("제목을 입력해주세요.");
				
			}
		}})
	}
</script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta charset="UTF-8">
<title>글 쓰기</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<form method="post" action="freewrite.do">

				<table class="writebbs">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">자유게시판</th>
						</tr>
					<tbody>

						<tr>
							<td><input type="text" class="form-control"
								placeholder="글 제목" name="title" maxlength="50"></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="작성자" name="writer" id="writer"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용"
									name="content" maxlength="2048" style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<br>
				<input type="submit" class="tapbutton-right" value="글쓰기"
					onclick="boardcheck();">

				
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>