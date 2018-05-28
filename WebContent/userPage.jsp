<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー詳細</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	
	<div id="mainBox">
		<div id="titleBox">
			<h2>ユーザー詳細</h2>
		</div>
		<div id="formBox">
			<table>
				<tr>
					<td>ユーザー名:</td>
					<td><s:property value="userDTO.getUserName()" /></td>
				</tr>
				<tr>
					<td>年齢:</td>
					<td><s:property value="userDTO.getUserAge()" /></td>
				</tr>
				<tr>
					<td>性別:</td>
					<td><s:property value="userDTO.getUserGender()" /></td>
				</tr>
		
				<tr>
					<td>所持バイク1:</td>
					<s:if test="!(userDTO.getBike1().equals(null))">
						<td><s:property value="userDTO.getBike1()" /></td>
					</s:if>
					<s:else>
						<td>登録なし</td>
					</s:else>
				</tr>
		
				<tr>
					<td>所持バイク2:</td>
					<s:if test="!(userDTO.getBike2().equals(null))">
						<td><s:property value="userDTO.getBike2()" /></td>
					</s:if>
					<s:else>
						<td>登録なし</td>
					</s:else>
				</tr>
		
				<tr>
					<td>所持バイク3:</td>
					<s:if test="!(userDTO.getBike3().equals(null))">
						<td><s:property value="userDTO.getBike3()" /></td>
					</s:if>
					<s:else>
						<td>登録なし</td>
					</s:else>
				</tr>
		
				<tr>
					<td>コメント:</td>
					<s:if test="!(userDTO.getComment().equals(null))">
						<td><s:property value="userDTO.getComment()" /></td>
					</s:if>
					<s:else>
						<td>登録なし</td>
					</s:else>
				</tr>
			</table>
		
			<s:if test="session.iventDTO.getId() != 0">
				<a href="<s:url action='IventAction'><s:param name="id" value="session.iventDTO.getId()"/></s:url>"class="submitBtn">イベント詳細へ戻る</a>
			</s:if>
		</div>
	</div>

</body>
</html>