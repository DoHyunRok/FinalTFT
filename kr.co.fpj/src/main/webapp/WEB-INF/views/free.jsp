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
		<p id="para">
			<button onclick="sort()" id = "cntsort" class="sort" value ="cntsort" name="cntsort">조회수순</button>
			<button onclick="sort()" id = "commentsort" class="sort" value="commentsort" name="commentsort">댓글순</button>
			<button onclick="sort()" id = "regsort" class="sort" value ="regsort" name="regsort">등록일순</button>
		</p>
	<div class="main">
	<table class="bbs" id="bbs">
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

					<td>${board.rownum}</td>

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
	
	<form action = "BoardSearch.do" method = "POST" > 
	<select name="SearchCategory">
		<option value="title">제목 검색</option>
		<option value="content">내용 검색</option>
	</select>
	<input type = "text" placeholder = "검색어를 입력해주세요"id = "boardSearch"  name="boardSearch">
	<input type = "submit" value = "검색" id="boardSeach1">
	</form>
		<input type="submit" onclick="morelist()" >
	<br>
	<a href="freewrite.do" class="tapbutton-right">글쓰기</a>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
<script>
//더보기
		cntsort = document.getElementById("cntsort");
		cntsort.addEventListener("click", function() {
		  document.getElementById("para").className = "cntsort";
		  console.log(cntsort)
		});

		commentsort = document.getElementById("commentsort");
		commentsort.addEventListener("click", function() {
		  document.getElementById("para").className = "commentsort";
		});

		regdatesort = document.getElementById("regsort");
		regdatesort.addEventListener("click", function() {
		  document.getElementById("para").classList.add("regdatesort");
		});
	function morelist() {
		var cpage =$('#bbs >#freebbs tr').length;
		var sorttype = $('#para').attr('class');
		console.log(sorttype);
		 $.ajax({
		        data : {"cpage":cpage+10 , "sorttype":sorttype},
		        url : "nextpage.do",
		        type : "get",
		        success : function(data) {
		            	$("#freebbs").empty();  
		            	var result = data;
						console.log(result);
						var str	 = '<TR>';
						$.each(result, function(i) {
							str += '<TD>' + result[i].rownum
									+ '</TD><TD colspan="2"><a href="freeview.do?seq=${board.seq}">' + result[i].title + '</a></TD>'
									+'<TD>'+ result[i].writer +'</TD><TD>' + result[i].regdate + '</TD><TD>'+ result[i].cnt +'</TD>'
							str += '</TR>'
						}); // 더보기 버튼을 div 클래스로 줘야 할 수도 있음
						$("#freebbs").append(str);
		            },
		            error : function(jqXHR, textStatus, errorThrown) {
						alert("에러발생");
						alert( textStatus );
						alert( errorThrown );
		        }
		    })
	};
	//조회수순 
	function sort(){
		var cpage =$('#bbs >#freebbs tr').length;
		var sorttype = event.srcElement.id;
		console.log(sorttype);
		$.ajax({
			data :{"sorttype":sorttype,"cpage":cpage},
			url : "cntsort.do",
			type : "post",
			success : function(data){
				$("#freebbs").empty();
				var csort = data;
				console.log(csort);
				var str	 = '<TR>';
				$.each(csort, function(i) {
					str += '<TD>' + csort[i].rownum
							+ '</TD><TD colspan="2"><a href="freeview.do?seq='+csort[i].seq+'">' + csort[i].title + '</a></TD>'
							+'<TD>'+ csort[i].writer +'</TD><TD>' + csort[i].regdate + '</TD><TD>'+ csort[i].cnt +'</TD>'
					str += '</TR>'
				});
				$("#freebbs").append(str);
			},
			error : function(jqXHR, textStatus, errorThrown){
				alert("에러발생");
			}
		})
		
	};
</script>

</html>
