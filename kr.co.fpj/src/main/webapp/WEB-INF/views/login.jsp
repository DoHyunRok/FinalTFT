x<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/finalcss.css"
	rel="stylesheet" type="text/css" />
<script src="./resources/js/security/rsa.js"></script>
<script src="./resources/js/security/jsbn.js"></script>
<script src="./resources/js/security/prng4.js"></script>
<script src="./resources/js/security/rng.js"></script>
<script src="./resources/js/security/core.min.js"></script>
<script src="./resources/js/security/sha256.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
<meta charset="UTF-8">
<style>
body {
	background-image: url("resources/image/TFT.png");
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
<title>로그인</title>
</head>
<body>
	<form action="login.do" method="post" class="loginform">
		<div id="idpass">

			<div>
				<input type="text" placeholder="ID" class="loginform" name="id"
					style="height: 40px; width: 230px;">
			</div>
			<br>

			<div>
				<input type="password" placeholder="Password" class="loginform"
					name="password" id="password" style="height: 40px; width: 230px;">
			</div>
		</div>
		<div>
			<input type="submit" value="로그인" class="submitbutton" id="encbtn"
				onclick="encrypt()" style="width: 95px;"> <input
				type="hidden" id="encryptedPWD" name="encryptedPWD">
		</div>

		<form action="join.do" method="POST">
			<input type="submit" value="회원가입" id="join" style="width: 95px;">
		</form>
	</form>
	<script>
	<!-- 암호화 -->
		var publicKeyExponent = "${publicKeyExponent}";
		var publicKeyModulus = "${publicKeyModulus}";
		function encrypt() {
			var inputPWD = document.getElementById("password").value;
			var sha256 = CryptoJS.SHA256(
					document.getElementById("password").value).toString();
			console.log(inputPWD);
			console.log(sha256);
			var rsa = new RSAKey();

			rsa.setPublic(publicKeyModulus, publicKeyExponent);

			document.getElementById("encryptedPWD").value = rsa.encrypt(sha256);

			document.getElementById("password").value = "";

			console.log(document.getElementById("encryptedPWD").value);

			document.getElementById("loginform").submit();
		}
	</script>
</body>
</html>
