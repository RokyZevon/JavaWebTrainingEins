<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>角色信息修改界面</title>
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
				window.location.href="role.servlet?state=update&ids="+state+"&countpage="+${countpage};
			}
		},false)
	}
	function doBack()
	{
		document.getElementById("btn_back").addEventListener("click",()=>{
			window.location.href="role.servlet?state=init&countpage="+${countpage};
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

</head>
<body>
	<div  id="div_table">
	<table class="bordered">
			<tbody id="show_tbody">
				<tr>
					<td>id</td>
					<td>rolename</td>
					<td>desc</td>
				</tr>
				<c:forEach items ="${sessionScope.roles }" var ="role">  
					<tr>
						<td><input type="text" name = "update1" id = "update_id" value="${role.id }" disabled="disabled"/></td>
						<td><input type="text" name = "update1" id = "update_rolename" value="${role.rolename }"/></td>
						<td><input type="text" name = "update1" id = "update_desc1" value="${role.desc1 }"/></td>
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