<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link rel="stylesheet" type="text/css" href="./css/header.css">
</head>
<body>

	<header>
		<a href="<s:url action='GoHomeAction'/>"><img src="./img/bikeLogo.png" alt="ヘッダーロゴ" class="headerlogo"/></a>
		<div class="welcome">WELCOME <s:property value="(#session.loginDTO).getUserName()" />!</div>
		<div id="text">
			<s:if test="!#session.loginDTO.isLoginFlg()">
				 <a href="<s:url action='LoginAction'/>" class="login headerBtn">LOGIN</a>
			 </s:if>
			 <s:else>
				<a href="<s:url action='MyPageAction'/>"class="headerBtn">MYPAGE</a>
				 <a href="<s:url action='LogoutAction'/>" class="logout headerBtn">LOGOUT</a>
			 </s:else>
			 <a href="<s:url action='UserCreateAction'/>" class="headerBtn">USER CREATE</a>
			 <a href="<s:url action='SearchAction'/>" class="headerBtn">SEARCH</a>
			 <a href="<s:url action='SiteExplanationAction'/>" class="headerBtn">？</a>
		</div>
	</header>

</body>
</html>