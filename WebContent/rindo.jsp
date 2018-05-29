<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>林道詳細</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	
	<div id="mainBox">
		<div id="titleBox">
			<h2>Rindo</h2>
		</div>
		<div id="formBox">
			<s:if test="session.rindoDTO.getId() == 0">
				<!-- 該当イベントが存在しなかった場合のページ（エラー画面） -->
				<h1>該当ページが見つかりませんでした。<br>管理者に問い合わせてください。</h1>
			</s:if>
		
			<s:else>
				<table>
					<tr>
						<th>林道：</th>
						<td><s:property value="session.rindoDTO.getRindoName()" /></td>
					</tr>
					<tr>
						<th>地域：</th>
						<td><s:property value="session.rindoDTO.getRindoPlaceName()" /></td>
					</tr>
					<tr>
						<th>難易度：</th>
						<td><s:if test="session.rindoDTO.getDifficulty() == 1">☆</s:if>
							<s:elseif test="session.rindoDTO.getDifficulty() == 2">☆☆</s:elseif>
							<s:elseif test="session.rindoDTO.getDifficulty() == 3">☆☆☆</s:elseif>
						</td>
					</tr>
					<tr>
						<th>コメント：</th>
						<td><s:property value="session.rindoDTO.getComment()" /></td>
					</tr>
				</table>
				
		<!-- 		画像 -->
				<s:if test="!(session.rindoDTO.getImg1().equals(null))">
					<img src="img/<s:property value="session.rindoDTO.getImg1()"/>"
						width="auto" height="400" />
				</s:if>
		<!-- 		画像終了 -->
		
			</s:else>
			<h3>イベント</h3>
			<s:if test="session.iventDTOList.size() != 0">
				<s:iterator value="session.iventDTOList">
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
			</s:if>
			<s:else>
			現在イベントはありません。
			</s:else>
		
			<br>
			<a href="<s:url action='IventCreateAction'/>"class="submitBtn">イベントを作成する</a>
		</div>
	</div>
</body>
</html>