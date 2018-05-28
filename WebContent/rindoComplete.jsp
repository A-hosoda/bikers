<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	<div id="mainBox">
		<div id="titleBox">
			<h2>登録が完了しました。</h2>
		</div>
		<div id="completeBox">
			<h2><span id="timer"></span>秒後に<a href='<s:url action="GoHomeAction"/>'>HOME</a>に戻ります。</h2>
		 </div>
	</div>

	<script>
		var waitTime = new Date();
		waitTime = waitTime.getTime() + 5000; //5秒間待つ設定

		var countdown = function(wait) {
			var now = new Date();

			var rest = wait - now.getTime();
			var counter = Math.floor(rest / 1000) % 60;

			return counter
		}

		var timer = function() {
			var counter = countdown(waitTime);
			document.getElementById('timer').textContent = counter;
			if (counter != 0) {
				cycle();
			} else {
				window.location.href = '<s:url action="GoHomeAction"/>';
			}

		}

		var cycle = function() {
			setTimeout(timer, 1000);
		}

		window.onload = function() {
			timer();
		};
	</script>
</body>
</html>