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
			<h2>以下の内容で登録します。</h2>
		</div>
		<div id="formBox">
		
			<table>
				<tr>
					<td>林道名：</td>
					<td><s:property value="rindoName" /></td>
				</tr>
				<tr>
					<td>地域：</td>
					<td><s:property value="rindoPlaceName" /></td>
				</tr>
				<tr>
					<td>緯度：</td>
					<td><s:property value="latitude" /></td>
				</tr>
				<tr>
					<td>経度：</td>
					<td><s:property value="longitude" /></td>
				</tr>
				<tr>
					<td>難易度：</td>
					<td><s:if test="<s:property value='difficulty'/> == 1">☆</s:if>
						<s:elseif test="<s:property value='difficulty'/> == 2">☆☆</s:elseif>
						<s:else>☆☆☆</s:else></td>
				</tr>
				<tr>
					<td>説明：</td>
					<td><s:property value="comment" /></td>
				</tr>
		
			</table>
		
			画像: <s:if test="!(img1FileName.equals(null))"><s:property value="img1FileName" /></s:if><s:else>画像はありません。</s:else><br/>
		画像イメージ:<br> <s:if test="!(img1FileName.equals(null))"><img src="uploadImg/<s:property value="img1FileName"/>" width="auto" height="100" /></s:if>
		
			
			<br>
			<a href="<s:url action='RindoCompleteAction'/>"class="submitBtn">登録</a>
			<a href="<s:url action='RindoCreateAction'/>"class="submitBtn">変更</a>
		</div>
	</div>
</body>
</html>