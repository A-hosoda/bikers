<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベント詳細</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	
	<div id="mainBox">
		<div id="titleBox">
			<h2>IVENT</h2>
		</div>
		
		<div id="formBox">

			<s:if test="session.iventDTO.getId() == 0">
				<!-- 該当イベントが存在しなかった場合のページ（エラー画面） -->
				<h1>
					該当ページが見つかりませんでした。<br>管理者に問い合わせてください。
				</h1>
				<a href="<s:url action='GoHomeAction'/>">ホームへ戻る</a>
			</s:if>
		
			<s:else>
				イベント開催日時：<s:property value="session.iventDTO.getIventDate()" />
				<br>
				イベント名：<s:property value="session.iventDTO.getIventName()" />
				<br>
				林道：<a href="<s:url action='RindoAction'><s:param name="id" value="session.iventDTO.getRindo_id()"/></s:url>"><s:property value="session.iventDTO.getRindoName()" /></a>
				<br>
				主催者：<a href="<s:url action='UserPageAction'><s:param name="id" value="session.iventDTO.getSponsor_id()"/></s:url>"><s:property value="session.iventDTO.getSponsor()" /></a>
				<br>
				参加人数/参加可能人数:<s:property value="session.iventDTO.getCurrentPeople()" />/<s:property value="session.iventDTO.getMaxPeople()" />
				<br>
				コメント：<s:property value="session.iventDTO.getComment()" />
				<br>
			</s:else>
		
			<!-- 	他の参加者がいた場合、追記していく。リンク先に飛ぶと同時にidを送る。 -->
			<s:if test="session.iventDTO.getParticipant1_id() != 0">
				参加者：<a href="<s:url action='UserPageAction'><s:param name="id" value="session.iventDTO.getParticipant1_id()"/></s:url>"><s:property value="session.iventDTO.getParticipant1()" /></a>
			</s:if>
			<s:if test="session.iventDTO.getParticipant2_id() != 0">
				<a href="<s:url action='UserPageAction'><s:param name="id" value="session.iventDTO.getParticipant2_id()"/></s:url>"><s:property value="session.iventDTO.getParticipant2()" /></a>
			</s:if>
			<s:if test="session.iventDTO.getParticipant3_id() != 0">
				<a href="<s:url action='UserPageAction'><s:param name="id" value="session.iventDTO.getParticipant3_id()"/></s:url>"><s:property value="session.iventDTO.getParticipant3()" /></a>
			</s:if>
			<br>
		
			<!-- 参加のif文 -->
			<s:if test="session.loginDTO.getId() == session.iventDTO.getSponsor_id() || session.loginDTO.getId() == session.iventDTO.getParticipant1_id() || session.loginDTO.getId() == session.iventDTO.getParticipant2_id() || session.loginDTO.getId() == session.iventDTO.getParticipant3_id()">
				参加中です。
			</s:if>
			<s:elseif test="!(session.loginDTO.isLoginFlg())">
				ゲストユーザーなのでイベントに参加できません。<br>
				ログイン、もしくは新規ユーザー作成をしてください。
			</s:elseif>
			<s:elseif test="session.iventDTO.getCurrentPeople() == session.iventDTO.getMaxPeople()">
				満員のためこのイベントには参加できません。
			</s:elseif>
			<s:else>
				<s:form action="SankaAction">
					<s:submit value="参加する" class="submitBtn" />
				</s:form>
			</s:else>
		</div>
	</div>

</body>
</html>