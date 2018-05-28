<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索結果</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	
	<div id="mainBox">
		<div id="titleBox">
			<h2>検索結果</h2>
		</div>
		<div id="formBox">
			<s:if test="(session.searchIventDTOList.size() > 0)&&(searchCheck.equals('iventSearch'))">
			検索内容に該当するイベントがありました。
			
			<s:iterator value="session.searchIventDTOList">
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
			<s:elseif test="(session.searchRindoDTOList.size() > 0)&&(searchCheck.equals('rindoSearch'))">
			検索内容に該当する林道がありました。
			
			<s:iterator value="session.searchRindoDTOList">
				<a href='<s:url action="RindoAction"><s:param name="id" value="id"/></s:url>' class="IventBox">
					<div class="iventTitle">
						<p class="ivent"><s:property value="rindoName" /></p>
					</div>
					<span class="centerText"></span>
					<br> 地域：
					<s:property value="rindoPlaceName" />
					<br> 難易度：
					<s:if test="difficulty == 1">☆</s:if>
					<s:elseif test="difficulty == 2">☆☆</s:elseif>
					<s:elseif test="difficulty == 3">☆☆☆</s:elseif>
				</a>
				</s:iterator>
			
			</s:elseif>
			<s:else>
			検索内容に該当するものはありませんでした。
			</s:else>
		</div>
	</div>
</body>
</html>