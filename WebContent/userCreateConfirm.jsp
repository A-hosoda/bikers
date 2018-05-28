<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	<div id="mainBox">
		<div id="titleBox">
			<h2>以下の内容で登録します。よろしいですか？</h2>
		</div>
		<div id="formBox">
		<table>
			<tr>
				<td>ユーザー名：</td>
				<td><s:property value="session.userCreateDTO.getUserName()" /></td>
			</tr>
			<tr>
				<td>パスワード：</td>
				<td><s:property value="session.userCreateDTO.getUserPassword()" /></td>
			</tr>
			<tr>
				<td>年齢：</td>
				<td><s:property value="session.userCreateDTO.getUserAge()" /></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td><s:property value="session.userCreateDTO.getUserGender()" /></td>
			</tr>
			<tr>
				<td>メールアドレス：</td>
				<td><s:property value="session.userCreateDTO.getUserMail()" /></td>
			</tr>
		</table>
		<a href="<s:url action='UserCreateCompleteAction'/>" class="submitBtn">登録する</a>
		<a href="<s:url action='UserCreateAction'/>" class="submitBtn">再入力する</a>
		</div>
	
	</div>

</body>
</html>