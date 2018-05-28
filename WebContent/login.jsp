<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	
	<div id="mainBox">
	
		<div id="titleBox">
			<h2>LOGIN</h2>
		</div>
		
		
		<s:if test="session.loginError">
			<div class="error">ユーザー名、またはパスワードが間違っています。</div>
		</s:if>
		<s:form action="LoginCompleteAction">
			<div id="formBox">
				<p>
					USER NAME：<input type="text" name="userName" />
				</p>
				<p>
					PASSWARD：<input type="password" name="userPassword" />
				</p>
				<s:submit value="Login" class="submitBtn"/>
			</div>
		</s:form>
	
	</div>
</body>
</html>