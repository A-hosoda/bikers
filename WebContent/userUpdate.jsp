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
<script>
	function fileCheck() {
		var file = document.getElementById("file").files;
		var size = 0;
		var fileName = "";
		for (var i = 0; i < file.length; i++) {
			size += file[i].size;
			fileName = file[i].name;
		}
		if (size > 4 * 1024 * 1024) {
			alert('ファイルサイズの上限は4MBです');
			return false;
		} else {
			return true;
		}
	}
</script>
<body>
<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	
	<div id="mainBox">
		<div id="titleBox">
			<h2>登録内容変更</h2>
		</div>
		<div id="formBox">
		変更する項目を入力してください。
		<s:if test="!errorMessage.equals('')"><div class="error"><s:property value="errorMessage"/></div></s:if>
			<s:form action="UserUpdateConfirmAction" method="post"
				enctype="multipart/form-data" onsubmit="return fileCheck();">
				<table>
					<tr>
						<td>e-mail：</td>
						<td><input type="text" name="userMail" value=<s:property value="#session.newUserDTO.getUserMail()"/> ></td>
					</tr>
					<tr>
						<th>所持しているバイク</th>
					</tr>
					<tr>
						<td>バイク1:</td>
						<td><input type="text" name="bike1" value=<s:property value="#session.newUserDTO.getBike1()"/> ></td>
					</tr>
					<tr>
						<td>バイク2：</td>
						<td><input type="text" name="bike2" value=<s:property value="#session.newUserDTO.getBike2()"/> ></td>
					</tr>
					<tr>
						<td>バイク3：</td>
						<td><input type="text" name="bike3" value=<s:property value="#session.newUserDTO.getBike3()"/> ></td>
					</tr>
					<tr>
						<td>コメント：</td>
						<td><textarea name="comment" rows="5" cols="30"><s:property value="#session.newUserDTO.getComment()" /></textarea></td>
					</tr>
					<tr>
						<td>画像：</td>
						<td><s:file name="img" label="画像" id="file"/></td>
					</tr>
				</table>
				<s:submit value="変更" class="submitBtn" />
			</s:form>
		</div>
	</div>

</body>
</html>