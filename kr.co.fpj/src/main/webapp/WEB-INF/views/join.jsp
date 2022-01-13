<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/finalcss.css"
	rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<style>
body {
	background-image: url("resources/image/TFT.png");
	background-size: cover;
	background-repeat: no-repeat;
}


.loginform {
	display: block;
	width: 100%;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
	margin:5px;
}
.submitbutton{
	margin:5px;
	width: 113.5%;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	color: #555;
	background-color: #66fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;`
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;

}
.logjoin{
	text-decoration: none;
	color: white;
}
.form_design ul{
	width:100%;
	hegiht:45px;
	list-style:none;
}
.form_design li{
	float:left;
	list-style:none;
}
.form_design li:first-child{
	width:150px;
	padding: 6px 0 0 0;
}
.form_design li input{
	width:300px;
	height:30px;
}
.form_design li .check{
	width: 80px; margin: 0 0 10px 10px; background-color:#999999;
	color:#fff; clear:both;
	height:45px;
}
.form_design ul {
	float:left;
	margin-bottom: 5px;
	color:white;
}
#content{
	width:100%;
	margin-left: 30%;
	margin-top :15%;
}
#joinsubmit{
	margin-left: 170px;
	height:30px;
}
</style>
<script src="resources/js/core.min.js"></script>
<script src="resources/js/security/jsbn.js"></script>
<script src="resources/js/security/prng4.js"></script>
<script src="resources/js/security/rng.js"></script>
<script src="resources/js/security/core.min.js"></script>
<script src="resources/js/security/sha256.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
<title>로그인</title>
</head>
<body>
	<div id="content">
	<form class="form_design" method="post" action="join.do">
		<ul>
			<li>아이디</li>
			<li><input type="text" placeholder="ID" class="loginform" id="id" name="id"></li>
			<li><button type="button" onclick="check();" class="check">중복체크</button></li>
		</ul>
		<ul>
			<li>비밀번호</li>
			<li><input type="password" placeholder="Password" class="loginform" name="password" id="password1"></li>
		</ul>	
		<ul>
			<li>비밀번호 재확인</li>
			<li><input type="password" placeholder="PasswordCheck" class="loginform" name="password2" id="password2"></li>
		</ul>	
		<ul>
			<li><font id="passcheck" size='2'></font></li>
		</ul>
		<ul>
			<li>롤 닉네임 입력</li>
			<li><input type="text" class="loginform" placeholder ="LoL NickName"></li>
		</ul>
		<input type="hidden" id="encryptedID" name="encryptedID">
		<input type="hidden" id="encryptedPWD" name="encryptedPWD">
		<ul>
			<li id="joinsubmit"><input type="submit"  value="회원가입" id="encbtn" onclick="encrypt()"></li>
		</ul>
	
	</form>

</div>
	<script>
	function check(){
 		var id = $("#id").val();
 		
 		$.ajax({
 			type: 'POST',
 			url : "idcheck.do",
 			data: id,
 			dataType : "json",
            contentType: "application/json; charset=UTF-8",
 			success: function(cnt){
 				var cnt = cnt.cnt;
 					 if (cnt > 0) {
 	                    alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
 	                    $("#divInputId").addClass("has-error");
 	                    $("#divInputId").removeClass("has-success");
 	                    $("#id").focus();
 					   } else {
 		                    alert("사용가능한 아이디입니다.");
 		                    //아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
 		                    $("#divInputId").addClass("has-success");
 		                    $("#divInputId").removeClass("has-error");
 		                    $("#userpwd").focus();
 		                    //아이디가 중복하지 않으면  idck = 1 
 		                    idck = 1;
 		                    
 		                }
 					 
 		            }
 		})
 	}
	$(function (){
			$('#password').keyup(function(){
				$('#passcheck').html('');
			  });
			
		$('#password2').keyup(function(){
			if($('#password').val() != $('#password2').val()){
				$('#passcheck').html('비밀번호가 일치하지 않습니다.')
				$('#passcheck').attr('color','red');
			}else{
				$('#passcheck').html('비밀번호가 일치합니다.');
				$('#passcheck').attr('color','white');
				
			}
		});
		});
	
	<!-- 암호화 -->
	var publicKeyExponent = "${publicKeyExponent}";
	var publicKeyModulus = "${publicKeyModulus}";
	console.log(publicKeyExponent);
	console.log(publicKeyModulus);
	function encrypt(){
		var inputID = document.getElementById("id").value;
		var inputPWD = document.getElementById("password").value;
		var sha256 = CryptoJS.SHA256(document.getElementById("password").value).toString();
		console.log(inputID);
		console.log(inputPWD);
		console.log(sha256);
		var rsa = new RSAKey();
		
		rsa.setPublic(publicKeyModulus,publicKeyExponent);
		
		document.getElementById("encryptedID").value = rsa.encrypt(inputID);
        document.getElementById("encryptedPWD").value = rsa.encrypt(sha256);
        
        document.getElementById("id").value ="";
        document.getElementById("password").value ="";
        
        console.log(document.getElementById("encryptedID").value);
        console.log(document.getElementById("encryptedPWD").value);
        
        document.getElementById("form_design").submit();
	}

</script>
</body>
</html>
