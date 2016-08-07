<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<link rel="stylesheet" type = "text/css" href="css/table.css"/>
<link rel="stylesheet" type = "text/css" href="css/base.css"/>
<head>
<meta  charset="UTF-8">
<title>用户角色管理</title>
</head>
<body>
	<form action="user.role.servlet?state=update&userid=${requestScope.userid }" method="post">
		<div class="role_show bordered"  style="margin-top:5px">
			<c:forEach items="${requestScope.roles}" var="role" varStatus="status">
			<c:if test="${(status.index+1)%10==0 }">
				</div><div class="role_show bordered"  style="margin-top:5px">
			</c:if>
			<c:if test="${role.value.checked==1}">
				<input type="checkbox" name="roleids" value="${role.value.id }" id="role_${role.value.id}" checked /><label for="role_${role.value.id}" >${role.value.rolename}</label>
			</c:if>
			<c:if test="${role.value.checked==0}">
				<input type="checkbox" name="roleids" value="${role.value.id }" id="role_${role.value.id}" /><label for="role_${role.value.id}" >${role.value.rolename}</label>
			</c:if>
		</c:forEach>
		<br>
		</div>
		<div class="bordered" style="margin-top:5px">
			<button type="submit">修改</button>
		</div>
	</form>
</body>
</html>