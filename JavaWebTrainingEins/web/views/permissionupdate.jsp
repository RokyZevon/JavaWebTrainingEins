<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>权限信息修改界面</title>
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
				window.location.href="permission.servlet?state=update&ids="+state+"&countpage="+${countpage};
			}
		},false)
	}
	function doBack()
	{
		document.getElementById("btn_back").addEventListener("click",()=>{
			window.location.href="permission.servlet?state=init&countpage="+${countpage};
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
					<td>permission</td>
					<td>url</td>
					<td>desc</td>
				</tr>
				<c:forEach items ="${requestScope.permissions }" var ="permission">  
					<tr>
						<td><input type="text" name = "update1" id = "update_id" value="${permission.id }" disabled="disabled"/></td>
						<td><input type="text" name = "update1" id = "update_name" value="${permission.permission }"/></td>
						<td><input type="text" name = "update1" id = "update_password" value="${permission.url }"/></td>
						<td><input type = "text" name="update1" id = "update_telephone" value="${permission.desc1 }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		<button type = "button" id = "btn_update" >保存</button>
		<button type = "button" id = "btn_back" >返回</button>
</body>
</html>