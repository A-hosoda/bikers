<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>林道の追加</title>
<link rel="stylesheet" type="text/css" href="./css/form.css">
<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />
<style>
#map {
 	height: 500px; 
	width: 70%;
	background-color: grey;
	display:inline-block;
}
.submitBtn{
	margin-left:30px
}
</style>
<script	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCBoCOwfHJZByOnH6pTqsBTtiOWbavqo2U"></script>
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

	function map_canvas() {

		//初期位置
		var latlng = new google.maps.LatLng(39, 138);
		var opts = {
			zoom : 6,
			center : latlng,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("map"), opts);

		mylistener(map);

		map.addListener('click', function(e) {
			placeMarkerAndPanTo(e.latLng, map);
		});
		
		map.addListener('dblclick', function() {
			marker.setMap(null);
		});
	}

	function placeMarkerAndPanTo(latLng, map) {

		var marker = new google.maps.Marker({
			position : latLng,
			map : map
		});

		map.panTo(latLng);
	}

	function mylistener(map) {
		google.maps.event.addListener(map, 'click', function(e) {
			document.getElementById("show_lat").value = e.latLng.lat();
			document.getElementById("show_lng").value = e.latLng.lng();
		});
	}

	//地図描画を実行 windowのロード時にmap_canvasを起動する。
	google.maps.event.addDomListener(window, 'load', map_canvas);
</script>
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
	
	<div id="mainBox">
		<div id="titleBox">
			<h2>林道の追加</h2>
		</div>
		<div id="formBox">
			<s:form action="RindoConfirmAction" method="post"
				enctype="multipart/form-data" onsubmit="return fileCheck();">
				<table>
					<tr>
						<td>林道名：</td>
						<td><input type="text" name="rindoName"
							<s:if test="!((session.newRindoDTO.getRindoName()).equals('error1'))"> value=<s:property value="session.newRindoDTO.getRindoName()"/>  </s:if> /></td>
						<td><s:if
								test="(session.newRindoDTO.getRindoName()).equals('error1')">
								<div class="error">未入力です。</div>
							</s:if></td>
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
						<td><s:if
								test="(session.newRindoDTO.getRindoPlaceName()).equals('error1')">
								<div class="error">未選択です。</div>
							</s:if></td>
					</tr>
					<tr>
						<td>難易度：</td>
						<td><select name="difficulty">
								<option value="0" selected>指定しない</option>
								<option value="1">☆</option>
								<option value="2">☆☆</option>
								<option value="3">☆☆☆</option>
						</select></td>
						<td><s:if test="(session.newRindoDTO.getDifficulty()) == -1">
								<div class="error">未選択です。</div>
							</s:if></td>
					</tr>
					<tr>
						<td>説明：</td>
						<td><textarea name="comment" rows="5" cols="30"><s:if
									test="!((session.newRindoDTO.getComment()).equals('error1'))">
									<s:property value="session.newRindoDTO.getComment()" />
								</s:if></textarea></td>
						<td><s:if
								test="(session.newRindoDTO.getComment()).equals('error1')">
								<div class="error">未入力です。</div>
							</s:if></td>
					</tr>
					<tr>
						<td>画像：</td>
						<td><s:file name="img1" label="画像" /></td>
						<td><s:if
								test="(session.newRindoDTO.getImg1()).equals('error6')">
								<div class="error">ファイル容量が4MB以上です。</div>
							</s:if></td>
					</tr>
					<tr>
						<td>座標選択：</td>
						<td>下記地図から選択してください</td>
		
					</tr>
					<tr>
						<th>緯度：</th>
						<td><input type="text" name="latitude" id="show_lat"/></td>
					</tr>
					<tr>
						<th>経度：</th>
						<td><input type="text" name="longitude" id="show_lng"/></td>
					</tr>
				</table>
				<div id="map"></div>
				<s:submit value="作成" class="submitBtn" />
			</s:form>
		</div>
	</div>
		
		
	
		

</body>
</html>