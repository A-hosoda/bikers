<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- datetimepickerを使うためにプラグインを導入する -->
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索ページ</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
<!-- datetimepickerを使うために必要。cache="false"を使うと文字化けがなくなる -->
<sx:head cache="false" />
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	
	<div id="mainBox">
		<div id="titleBox">
			<h2>SEARCH</h2>
		</div>
		<div id="formBox">
			必要ない項目は空欄で問題ありません。
				<!-- 	----------イベント検索-------------- -->
				<div class="searchBox">
					<h2>イベント検索</h2>
					<s:form action="SearchConfirmAction">
						<table>
							<tr>
								<td>イベント名：</td>
								<td><input type="text" name="iventName" /></td>
							</tr>
							<tr>
								<td>林道名：</td>
								<td><input type="text" name="rindoName" /></td>
							</tr>
							<tr>
								<td>開催日時：</td>
								<td><sx:datetimepicker name="iventDate"
										displayFormat="yyyy-MM-dd" /></td>
							</tr>
							<tr>
								<td>投稿者：</td>
								<td><input type="text" name="sponsor" /></td>
							</tr>
							<tr>
								<td>参加可能人数：</td>
								<td><select name="maxPeople">
										<option value="0" selected>指定しない</option>
										<option value="2">2人</option>
										<option value="3">3人</option>
										<option value="4">4人</option>
								</select></td>
							</tr>
							<s:hidden name="searchCheck" value="iventSearch" />
						</table>
						<s:submit value="検索" class="submitBtn"/>
					</s:form>
				</div>
			
				<!-- 	//--------------------------------- -->
			
				<!-- 	----------林道検索-------------- -->
				<div class="searchBox">
					<h2>林道検索</h2>
					<s:form action="SearchConfirmAction">
						<table>
							<tr>
								<td>林道名：</td>
								<td><input type="text" name="rindoName" /></td>
							</tr>
							<tr>
								<td>地域：</td>
								<td><select name="rindoPlaceName">
										<option value="" selected>指定しない</option>
										<option value="北海道地方">北海道地方</option>
										<option value="東北地方">東北地方</option>
										<option value="関東地方">関東地方</option>
										<option value="中部地方">中部地方</option>
										<option value="近畿地方">近畿地方</option>
										<option value="中国地方">中国地方</option>
										<option value="四国地方">四国地方</option>
										<option value="九州地方">九州地方</option>
								</select></td>
							</tr>
							<tr>
								<td>難易度：</td>
								<td><select name="difficulty">
										<option value="0" selected>指定しない</option>
										<option value="1">☆</option>
										<option value="2">☆☆</option>
										<option value="3">☆☆☆</option>
								</select></td>
							</tr>
							<s:hidden name="searchCheck" value="rindoSearch" />
						</table>
						<s:submit value="検索" class="submitBtn"/>
					</s:form>
				</div>
			
				<!-- 	//--------------------------------- -->
			</div>
		</div>

</body>
</html>