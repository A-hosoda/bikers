<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/index.css">
<title>ignition</title>
<script src="JQuery/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div class="indexContainer">
		<h1 class="indextitle">Are you ready?</h1>

		<a href="<s:url action='HomeAction'/>" class="startButton"><img
			src="./img/helmet.png" /></a>

<img src="./img/bike1.png" class="bikeImg"/>
	</div>


	<script>
		$(function() {
			$("a").click(function() {
				$(".startButton img").fadeOut("fast");
				$(".indextitle").text("Let's GO!!");
				$(".bikeImg").animate({
					"margin-left" : "0px",
// 					"margin-top" : "-500px",
					"zoom" : "200%"
				}, "slow", "swing");
				
			});
		});
	</script>
</body>
</html>