<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>主页面</title>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
<link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body>
	<div id ="div_top" class="bordered">
		<ul>
    		<li><a href="#">切换用户</a></li>
       		<li><a href="#">修改密码</a></li>
       		<li><a href="login.servlet?state=destroy" >退出</a></li>
	    </ul>
	</div>
	<div id = "main" class="bordered">
		<div id = "div_left" class="bordered">
			<h3>${requestScope.h }</h3><br/>
			<c:forEach items="${requestScope.permission }" var="permission">
			<ul>
				<a href="${permission.value.url }" target="mainIframe"><li>${permission.value.permission }</li></a>
			</ul>
			</c:forEach>
		</div>
		<div id = "div_right" class="bordered">
			<iframe id = "mainIframe" name="mainIframe" src="views/welcome.html" frameborder="0" marginwidth="0" marginheight="0"></iframe>
		</div>
	</div>
	<div class="bordered" id="down">info</div>
</body>
</html>