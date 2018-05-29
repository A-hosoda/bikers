<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">

<!-- グーグルマップ導入用-------------------------------------- -->
<!-- Google Maps javaScript APIをダウンロードする。 -->
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCBoCOwfHJZByOnH6pTqsBTtiOWbavqo2U"></script>
<script src="JQuery/jquery-3.3.1.min.js"></script>
<script src="JQuery/covervid.min.js"></script>

<!--     ----------------------------------------- -->

<!-- フォント -->
<link href="https://fonts.googleapis.com/earlyaccess/sawarabigothic.css" rel="stylesheet" />

</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp" />

	<img src="./img/bikeLogo.png" alt="バイクロゴ" class="logo"/>
	
	<!-- 背景動画 -->
	<div class="covervid-wrapper">
		<video class="covervid-video" autoplay loop poster="img/autumn.jpg">
			<source src="videos/Forest.mp4" type="video/mp4">
		</video>
		<div class="pattern"></div>




		<div id="wrapper">

			<!-- グーグルマップ---------------------------------- -->
			<h2><span class="initialBox">R</span>indo MAP</h2>
			<div id="map"></div>
			<!-- 	GoogleMap表示、Map上にマーカーを設置する。 -->
			<script>
				function map_canvas() {
					//マーカーの情報
					var data = new Array();

					<s:iterator value="#session.rindoAllDTOList">
					data.push({
						lat : <s:property value="latitude" />,
						lng : <s:property value="longitude" />,
						rindoName : "<s:property value='rindoName'/>",
						id : <s:property value="id" />,
						difficulty : <s:property value="difficulty" />,
						img1 : "<s:property value='img1'/>"
					});
					</s:iterator>

					//初期位置に、上記配列の最初の緯度経度を格納
					var latlng = new google.maps.LatLng(data[0].lat,
							data[0].lng);
					var opts = {
						zoom : 6,
						center : latlng,
						mapTypeId : google.maps.MapTypeId.ROADMAP
					};
					var map = new google.maps.Map(document
							.getElementById("map"), opts);

					var markers = new Array();
					var infowin = new Array();

					//マーカーを配置するループ

					for (i = 0; i < data.length; i++) {
						markers[i] = new google.maps.Marker({
							position : new google.maps.LatLng(data[i].lat,
									data[i].lng),
							map : map
						});
						var iContent = infoWinHtml(data[i].rindoName,
								data[i].id, data[i].difficulty, data[i].img1);
						infowin[i] = new google.maps.InfoWindow({
							content : iContent
						});
						markerInfo(markers[i], iContent, infowin[i], map);
					}

				}

				function markerInfo(marker, iContent, infowin, map) {

					google.maps.event.addListener(marker, 'click', function(e) {
						infowin.open(marker.getMap(), marker);
						map.panTo(e.latLng);
					});
					google.maps.event.addListener(map, 'click', function() {
						infowin.close();
					});
				}

				// 		マーカー内容の作成
				function infoWinHtml(rindoName, rindo_id, difficulty, img1) {
					var result;
					result = 'No.';
					result += rindo_id;
					result += '<br><a href="<s:url action="RindoAction"><s:param name="id" value='-1'/></s:url>"><h3>';
					// 			script内でカスタムタグ内の操作するためにはreplaceを使う必要がある？+を使用してもうまく動かない。
					result = result.replace(-1, rindo_id);
					result += rindoName;
					result += '</h3></a>';
					result += '難易度：';
					if (difficulty == 1) {
						result += '☆';
					} else if (difficulty == 2) {
						result += '☆☆';
					} else {
						result += '☆☆☆';
					}
					if (img1 != "") {
						result += '<br><img src="uploadImg/ImageName" width="150" />';
						result = result.replace('ImageName', img1);
					} else {
						result += '<br>画像はありません';
					}

					return result;
				}

				//地図描画を実行 windowのロード時にmap_canvasを起動する。
				google.maps.event.addDomListener(window, 'load', map_canvas);
			</script>
			<!--     --------------------------------------------- -->
			<h2><span class="initialBox">N</span>ew Ivent　(新着5件のイベント)</h2>
			
			<s:iterator value="#session.newIventDTOList">
			
				<a href='<s:url action="IventAction"><s:param name="id" value="id"/></s:url>' class="newIventBox">
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
		</div>
	</div>

</body>
</html>