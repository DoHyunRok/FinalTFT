<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>


<link href="${pageContext.request.contextPath}/resources/css/finalcss.css" rel="stylesheet" type="text/css"/>
<meta charset="UTF-8">
<title>자유 게시판</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sidebar.jsp"></jsp:include>
	<table class="tap">
		<tr>
			<td><input type="submit" value="인기순"></td>
			<td>댓글순</td>
			<td>조회수순</td>
			<td>최신순</td>
		</tr>
	</table>
	<div class="main">
	<table class="bbs">
		<tr>
			<th width=70px;>글 번호</th>
			<th width=200px colspan="2">글 제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th width=65px;>조회수</th>
		</tr>
		
		<tbody id="freebbs">

			<c:forEach items="${boardlist}" var="board">
				<tr>

					<td>${board.seq}</td>

					<td colspan="2"><a href="freeview.do?seq=${board.seq}">
							${board.title}</a></td>

					<td>${board.writer}</td>

					<td>${board.regdate}</td>
					<td>${board.cnt}</td>



				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	
	<br>
	<a href="freewrite.do" class="tapbutton-right">글쓰기</a>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		//function popular() {
			//$.ajax({
				//url : "psort.do",
				//type : "POST",
				//success : function(data) {
					//if (data.length === 0) {
						//alert("오류입니다.")
					//} else {
						//$('#freebbs').empty();
						//console.log(data)
						//var result = data;
						//console.log(result[1])
						//var str = '<TR>';
						//$.each(result, function(i) {
							//str += '<TD>' + result[i].seq+ '</TD><TD><a href="freeview.do?seq=' + result[i].seq + '>' + result[i].title + '</a></TD>' 
							//+'<TD>'+ result[i].content +'</TD> <TD>' + result[i].writer +'</TD><TD>' + result[i].regdate + '</TD><TD>'+ result[i].cnt + '</TD>'
							//str += '</TR>';
						//});
					//}
					//$("#freebbs").append(str);
					//console.log(str);
				//},
				//error : function(jqXHR, textStatus, errorThrown) {
					//alert("에러발생")
				//}
			//});
		//}
	</script>
</body>
</html>