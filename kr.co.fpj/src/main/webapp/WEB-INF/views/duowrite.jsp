<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/finalcss.css"
	rel="stylesheet" type="text/css" />
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
			<form method="post" action="duowrite.do">

				<table class="writebbs">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">듀오게시판</th>
						</tr>
					<tbody>
						<tr>
							<td class="tierbox">티어 &nbsp: &nbsp <select name="tier1"
								class="tier1">
									<option value="아이언" selected>아이언</option>
									<option value="브론즈">브론즈</option>
									<option value="실버">실버</option>
									<option value="골드">골드</option>
									<option value="플래티넘">플래티넘</option>
									<option value="다이아몬드">다이아몬드</option>
									<option value="마스터">마스터</option>
									<option value="그랜드마스터">그랜드마스터</option>
									<option value="챌린저">챌린저</option>
							</select> ~ <select name="tier2" class="tier2">
									<option value="아이언" selected>아이언</option>
									<option value="브론즈">브론즈</option>
									<option value="실버">실버</option>
									<option value="골드">골드</option>
									<option value="플래티넘">플래티넘</option>
									<option value="다이아몬드">다이아몬드</option>
									<option value="마스터">마스터</option>
									<option value="그랜드마스터">그랜드마스터</option>
									<option value="챌린저">챌린저</option>
							</select>
							</td>
						</tr>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="글 제목" name="title" maxlength="50"></td>
						</tr>

						<tr>
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
			<input type="submit" value="글쓰기" class="duowrite" onclick="boardcheck();" id="duowrite">
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>