<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	
	<div id="mainBox">
		<div id="titleBox">
			<h2>MYPAGE</h2>
		</div>
		<div id="formBox">
			<table>
				<tr>
					<td>ユーザー名:</td>
					<td><s:property value="session.loginDTO.getUserName()" /></td>
				</tr>
				<tr>
					<td>年齢:</td>
					<td><s:property value="session.loginDTO.getUserAge()" /></td>
				</tr>
				<tr>
					<td>性別:</td>
					<td><s:property value="session.loginDTO.getUserGender()" /></td>
				</tr>
		
				<tr>
					<td>所持バイク1:</td>
					<s:if test="session.loginDTO.getBike1().equals(null)">
						<td>登録なし</td>
					</s:if>
					<s:else>
						<td><s:property value="session.loginDTO.getBike1()" /></td>
					</s:else>
				</tr>
		
				<tr>
					<td>所持バイク2:</td>
					<s:if test="!(session.loginDTO.getBike2().equals(null))">
						<td><s:property value="session.loginDTO.getBike2()" /></td>
					</s:if>
					<s:else>
						<td>登録なし</td>
					</s:else>
				</tr>
		
				<tr>
					<td>所持バイク3:</td>
					<s:if test="!(session.loginDTO.getBike3().equals(null))">
						<td><s:property value="session.loginDTO.getBike3()" /></td>
					</s:if>
					<s:else>
						<td>登録なし</td>
					</s:else>
				</tr>
		
				<tr>
					<td>コメント:</td>
					<s:if test="!(session.loginDTO.getComment().equals(null))">
						<td><s:property value="session.loginDTO.getComment()" /></td>
					</s:if>
					<s:else>
						<td>登録なし</td>
					</s:else>
				</tr>
			</table>
			<h3>参加中のイベント</h3>
			<s:iterator value="session.notAchievedIventList">
				<a href='<s:url action="IventAction"><s:param name="id" value="id"/></s:url>' class="IventBox">
					<div class="iventTitle">
						<p class="ivent"><s:property value="iventName" /></p>
						<p class="date">開催日時：<s:property value="iventDate" /></p>
					</div>
					<span class="centerText"></span>
					<br> 林道：
					<s:property value="rindoName" />
					<br> 開催者：
					<s:property value="sponsor" />
				</a>
			</s:iterator>
			<h3>終了したイベント</h3>
			<s:iterator value="session.oldIventList">
				<a href='<s:url action="IventAction"><s:param name="id" value="id"/></s:url>' class="IventBox">
					<div class="iventTitle">
						<p class="ivent"><s:property value="iventName" /></p>
						<p class="date">開催日時：<s:property value="iventDate" /></p>
					</div>
					<span class="centerText"></span>
					<br> 林道：
					<s:property value="rindoName" />
					<br> 開催者：
					<s:property value="sponsor" />
				</a>
			</s:iterator>
		
			<a href="<s:url action='IventCreateAction'/>" class="submitBtn">イベント作成</a>
			<a href="<s:url action='RindoCreateAction'/>" class="submitBtn">林道の追加</a>
			</div>
		</div>
</body>
</html>