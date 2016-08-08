<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>用户信息修改界面</title>
</head>
<link rel="stylesheet" type = "text/css" href="css/table.css"/>
<link rel="stylesheet" type = "text/css" href="css/base.css"/>
<style type="text/css">
</style>
<script type="text/javascript">
	
	function doUpdate()
	{
		document.getElementById("btn_update").addEventListener("click",()=>{
			var input_updates = document.getElementsByName("update1");
			var state="";
			for(let i = 0 ,len = input_updates.length;i<len;i++)
			{
				if(state=="")
				{
					state+=input_updates[i].value;
				}
				else
				{
					state+=",";
					state+=input_updates[i].value;
				}
			}
			if(state=="")
			{
				alert("请输入要添加的数据！！");
			}
			else
			{
				window.location.href="user.servlet?state=update&ids="+state+"&countpage="+${countpage};
			}
		},false)
	}
	function doBack()
	{
		document.getElementById("btn_back").addEventListener("click",()=>{
			window.location.href="user.servlet?state=init&countpage="+${countpage};
		},false)
	}
	function init()
	{
		doUpdate();
		doBack();
	}
	window.addEventListener("load",()=>{
		init();
	},false)
</script>
<body>
	<div id="div_table">
	<table class="bordered">
			<tbody id="show_tbody">
				<tr>
					<td>id</td>
					<td>name</td>
					<td>password</td>
					<td>telephone</td>
				</tr>
				<c:forEach items ="${requestScope.users }" var ="user">  
					<tr>
						<td><input type="text" name = "update1" id = "update_id" value="${user.id }" disabled="disabled"/></td>
						<td><input type="text" name = "update1" id = "update_name" value="${user.name }"/></td>
						<td><input type="text" name = "update1" id = "update_password" value="${user.password }"/></td>
						<td><input type = "text" name="update1" id = "update_telephone" value="${user.telephone }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<button type = "button" id = "btn_update" >保存</button>
		<button type = "button" id = "btn_back" >返回</button>
	</div>
</body>
</html>