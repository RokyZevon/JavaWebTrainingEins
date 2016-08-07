<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type = "text/css" href="css/table.css"/>
<link rel="stylesheet" type = "text/css" href="css/base.css"/>
<head>
<meta charset="UTF-8">
<title>角色权限管理</title>
</head>
<body>
	<form action = "permission.role.servlet?state=update&roleid=${requestScope.roleid }" method = "post" >
		<div class="role_show bordered"  style="margin-top:5px">
			<c:forEach items="${requestScope.permissions }" var="permission" varStatus="status">
				<c:if test="${(status.index+1)%10==0 }">
					</div><div class="role_show bordered"  style="margin-top:5px">
				</c:if>
				<c:if test="${permission.value.checked==1 }">
					<input type="checkbox" name = "permissionids" value="${permission.value.id }" checked /><label for="permission_${permission.value.id }">${permission.value.permission }</label>
				</c:if>
				<c:if test="${permission.value.checked==0 }">
					<input type="checkbox" name = "permissionids" value="${permission.value.id }" /><label for="permission_${permission.value.id }">${permission.value.permission }</label>
				</c:if>
			</c:forEach>
			</br>
		</div>
		<div class="bordered" style="margin-top:5px">
			<button type="submit">修改</button>
		</div>
	</form>
	
</body>
</html>