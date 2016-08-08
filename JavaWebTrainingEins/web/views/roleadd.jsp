<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>角色信息添加界面</title>
</head>
<link rel="stylesheet" type = "text/css" href="css/table.css"/>
<link rel="stylesheet" type = "text/css" href="css/base.css"/>
<style type="text/css">
</style>
<script type="text/javascript">	
	function doAdd()
	{
		document.getElementById("btn_add").addEventListener("click",()=>{
			var input_adds = document.getElementsByName("add1");
			var state="";
			for(let i = 0 ,len = input_adds.length;i<len;i++)
			{
				if(state=="")
				{
					state+=input_adds[i].value;
				}
				else
				{
					state+=",";
					state+=input_adds[i].value;
				}
			}
			if(state=="")
			{
				alert("请输入要添加的数据！！");
			}
			else
			{
				window.location.href="role.servlet?state=add&ids="+state;
			}
		},false)
	}
	function doAgain()
	{
		document.getElementById("btn_again").addEventListener("click",()=>{
			window.location.href="role.add.servlet?state=init&countpage="+${countpage};
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
		doAdd();
		doAgain();
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
				<td>rolename</td>
				<td>desc</td>
			</tr>
			<tr>
				<td><input type="text" name = "add1" id = "add_rolename"/></td>
				<td><input type = "text" name ="add1" id = "add_desc"/></td>
			</tr>
			</tbody>
		</table>
	</div>
	<div>
		<button type = "button" id = "btn_add" >增加</button>
		<button type = "button" id = "btn_again" >重置</button>
		<button type = "button" id = "btn_back" >返回</button>
	</div>
</body>
</html>