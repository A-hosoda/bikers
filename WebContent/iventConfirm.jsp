<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認画面</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	
	<div id="mainBox">
		<div id="titleBox">
			<h2>以下の内容で登録しますか？</h2>
		</div>
		<div id="formBox">
			<table>
					<tr>
						<td>イベント名：</td>
						<td><s:property value="session.newIventDTO.getIventName()" /></td>
					</tr>
					<tr>
						<td>開催日時：</td>
						<td><s:property value="session.newIventDTO.getIventDate()" /></td>
					</tr>
					<tr>
						<td>林道：</td>
						<td><s:property value="session.newIventDTO.getRindoName()" /></td>
					</tr>
					<tr>
						<td>最大参加人数：</td>
						<td><s:property value="session.newIventDTO.getMaxPeople()" /></td>
					</tr>
					<tr>
						<td>コメント：</td>
						<td><s:property value="session.newIventDTO.getComment()" /></td>
					</tr>
				</table>
				<a href="<s:url action='IventCompleteAction'/>"class="submitBtn">登録</a>
				<a href="<s:url action='IventCreateAction'/>"class="submitBtn">再入力</a>
			</div>
		</div>

</body>
</html>