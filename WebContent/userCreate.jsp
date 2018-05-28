<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	
	<div id="mainBox">
		<div id="titleBox">
			<h2>USER CREATE</h2>
		</div>
		<!-- エラー表示などが改行して表示されてしまう。どうしようもなければ行列にして対応する。 -->
	
		<s:if test="(session.loginDTO).isLoginFlg()">
	ログイン中です。<br> ユーザー作成とともにログインユーザーを切り替えます。<br>
		</s:if>
			<s:form action="UserCreateConfirmAction">
				<!-- 	エラーが起き、再度データを記入する場合valueにエラーはなかった項目を記入しておく -->
				<table>
					<tr>
						<td>ユーザー名：</td>
						<td><input type="text" name="userName"
							<s:if test="!((session.userCreateDTO.getUserName()).equals('error1') || (session.userCreateDTO.getUserName()).equals('error2'))"> value=<s:property value="session.userCreateDTO.getUserName()"/>  </s:if> >
						</td>
						<td><s:if
								test="(session.userCreateDTO.getUserName()).equals('error1')">
								<div class="error">未入力です。</div>
							</s:if> <s:if
								test="(session.userCreateDTO.getUserName()).equals('error2')">
								<div class="error">すでに使用されているユーザー名です。</div>
							</s:if></td>
					</tr>
		
					<tr>
						<td>パスワード：</td>
						<td><input type="password" name="userPassword1" ></td>
						<td><s:if
								test="(session.userCreateDTO.getUserPassword()).equals('error1')">
								<div class="error">未入力です。</div>
							</s:if> <s:if
								test="(session.userCreateDTO.getUserPassword()).equals('error3')">
								<div class="error">異なるパスワードが入力されています。</div>
							</s:if></td>
					</tr>
					<tr>
						<td>パスワード(確認)：</td>
						<td><input type="password" name="userPassword2" ></td>
					</tr>
		
					<tr>
						<td>年齢：</td>
						<td><select name="userAge">
		
								<option value=0 selected>選択してください。</option>
								<%
									for (int i = 16; i < 100; i++) {
								%>
								<option value=<%=i%>><%=i%></option>
								<%
									}
								%>
						</select></td>
						<td><s:if test="(session.userCreateDTO.getUserAge())==1">
								<div class="error">未選択です。</div>
							</s:if></td>
					</tr>
		
					<tr>
						<td>性別：</td>
						<td><label><input type="radio" name="userGender"
								value="男" checked>男</label> <label><input type="radio"
								name="userGender" value="女">女</label></td>
					</tr>
		
					<tr>
						<td>メールアドレス：</td>
						<td><input type="text" name="userMail"
							<s:if test="!((session.userCreateDTO.getUserMail()).equals('error1') || (session.userCreateDTO.getUserMail()).equals('error4'))"> value=<s:property value="session.userCreateDTO.getUserMail()"/> </s:if> >
						</td>
						<td><s:if
								test="(session.userCreateDTO.getUserMail()).equals('error1')">
								<div class="error">未入力です。</div>
							</s:if> <s:if
								test="(session.userCreateDTO.getUserMail()).equals('error4')">
								<div class="error">@が入っていません。</div>
							</s:if></td>
					</tr>
				</table>
				<div id="submitBox">
					<s:submit value="登録" class="submitBtn"/>
				</div>
			</s:form>
		</div>
	
</body>
</html>