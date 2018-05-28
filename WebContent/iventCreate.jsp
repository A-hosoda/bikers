<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- datetimepickerを使うためにプラグインを導入する -->
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベント作成</title>
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
			<h2>イベント作成</h2>
		</div>
		<div id="formBox">
			
				<s:form action="IventConfirmAction">
			
					<!-- 	エラーが起き、再度データを記入する場合valueにエラーはなかった項目を記入しておく -->
					<table>
						<tr>
							<td>イベント名：</td>
							<td><input type="text" name="iventName" <s:if test="!((session.newIventDTO.getIventName()).equals('error1'))"> value=<s:property value="session.newIventDTO.getIventName()"/>  </s:if>></td>
							<td><s:if
									test="(session.newIventDTO.getIventName()).equals('error1')">
									<div class="error">未入力です。</div>
								</s:if></td>
						</tr>
			
						<tr>
							<td>開催日時：</td>
							<td><sx:datetimepicker name="iventDate"
									displayFormat="yyyy-MM-dd" /></td>
							<td><s:if
									test="(session.newIventDTO.getIventDate()).equals('error1')">
									<div class="error">未選択です。</div>
								</s:if> <s:if test="(session.newIventDTO.getIventDate()).equals('error5')">
									<div class="error">過去の日付を選択しています。</div>
								</s:if></td>
						</tr>
			
						<tr>
							<td>林道：</td>
							<!-- 				iventCreateCompleteActionではidを基にrindoNameを検索する。 -->
							<td><select name="rindo_id">
									<option value=0 selected>選択してください。</option>
									<s:iterator value="session.rindoDTOList">
										<option value=<s:property value="id"/>><s:property
												value="rindoName" />(
											<s:property value="rindoPlaceName" />)
										</option>
									</s:iterator>
							</select></td>
							<td><s:if test="(session.newIventDTO.getRindo_id())== -1">
									<div class="error">未選択です。</div>
								</s:if></td>
						</tr>
						<tr>
							<td>最大参加人数：</td>
							<td><select name="maxPeople">
									<option value=0 selected>選択してください。</option>
									<option value=2>2人</option>
									<option value=3>3人</option>
									<option value=4>4人</option>
							</select></td>
							<td><s:if test="(session.newIventDTO.getMaxPeople())== -1">
									<div class="error">未選択です。</div>
								</s:if></td>
						</tr>
						<tr>
							<td>コメント：</td>
							<td><textarea name="comment"rows="5" cols="30"><s:if test="!((session.newIventDTO.getComment()).equals('error1'))"><s:property value="session.newIventDTO.getComment()"/></s:if></textarea> </td>
							<td><s:if
									test="(session.newIventDTO.getComment()).equals('error1')">
									<div class="error">未入力です。</div>
								</s:if></td>
						</tr>
					</table>
					<s:submit value="作成" class="submitBtn"/>
				</s:form>
			</div>
		</div>
</body>
</html>