<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>主页面</title>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id ="div_top" class = "bordored">
		<ul>
    	<li><a href="#">切换用户</a></li>
        <li><a href="#">修改密码</a></li>
        <li><a href="login.servlet?param=destroy" target="_parent">退出</a></li>
    </ul>
	</div>
	<div class = "bordored">
		<div id = "div_left">
			<c:forEach items="${requestScope.permission }" var="permission">
			<ul>
				<li>${permission.value.permission }</li>
			</ul>
			</c:forEach>
		</div>
		<div id = "div_right">
			
		</div>
	</div>
</body>
</html>