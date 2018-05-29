<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報変更</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	
	<div id="mainBox">
		<div id="titleBox">
			<h2>登録内容確認</h2>
		</div>
		<div id="formBox">
		以下の内容で変更します。よろしいですか？
		<table>
				<tr>
						<td>e-mail：</td>
						<td><s:property value="#session.newUserDTO.getUserMail()"/></td>
					</tr>
					<tr>
						<th>所持しているバイク</th>
					</tr>
					<tr>
						<td>バイク1:</td>
						<td><s:property value="#session.newUserDTO.getBike1()"/></td>
					</tr>
					<tr>
						<td>バイク2：</td>
						<td><s:property value="#session.newUserDTO.getBike2()"/></td>
					</tr>
					<tr>
						<td>バイク3：</td>
						<td><s:property value="#session.newUserDTO.getBike3()"/></td>
					</tr>
					<tr>
						<td>コメント：</td>
						<td><s:property value="#session.newUserDTO.getComment()" /></td>
					</tr>
		
			</table>
		
			画像: <s:if test="!(imgFileName.equals(null))"><s:property value="imgFileName" /></s:if><s:else>画像はありません。</s:else><br/>
		画像イメージ:<br> <s:if test="!(imgFileName.equals(null))"><img src="uploadImg/<s:property value="imgFileName"/>" width="auto" height="100" /></s:if>
		
			
			<br>
			<a href="<s:url action='UserUpdateCompleteAction'/>"class="submitBtn">登録</a>
			<a href="<s:url action='UserUpdateAction'/>"class="submitBtn">変更</a>
		</div>
	</div>
	

</body>
</html>