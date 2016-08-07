<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
<link rel="stylesheet" type="text/css" href="css/table.css"/>
</head>
<body>
	<form action="login.servlet" method="post">
		<div class="bordered" style="width:400px;margin:0px auto;padding:10px;text-align:center">
			<c:if test="${not empty requestScope.errorLogin}">
				<div style="text-align:right;color:red">${requestScope.errorLogin }<br></div>
			</c:if>
			用户名:<input type="text" name ="username" id = "username"  style="margin:5px;width:200px;height:20px"/><br/>
			密&nbsp;码:<input type="text" name = "password" id = "password"  style="margin:5px;width:200px;height:20px"/><br/>
			<button type="button" style="margin-right:20px">注册</button><button type="submit">登录</button>
		</div>
	</form>
</body>
</html>