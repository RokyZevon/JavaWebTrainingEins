<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>角色信息管理</title>
<link rel="stylesheet" type = "text/css" href="css/table.css"/>
<link rel="stylesheet" type = "text/css" href="css/base.css"/>
<style type="text/css">
</style>
<script type="text/javascript">
function cbx_select(){
	document.getElementById("all").addEventListener("change",()=>{
		var input_cbxs=document.getElementsByName("ids");
		let all=document.querySelector("#all");
		for(let i=0,len=input_cbxs.length;i<len;i++){
			if(all.checked==true){
				input_cbxs[i].checked=true;
			}else{
				input_cbxs[i].checked=false;
			}
		}
	},false);	
}
	function doDelete()
	{
		
			document.getElementById("btn_delete").addEventListener("click",()=>{
			var input_cbxs = document.getElementsByName("ids");
			let state = "";
			for(let i = 0 ,len = input_cbxs.length;i<len;i++)
			{
				if(input_cbxs[i].checked == true)
				{
					if(state=="")
					{
						state += input_cbxs[i].dataset.id; 
					}
					else
					{
						state+=",";
						state+=input_cbxs[i].dataset.id; 
					}
				}
			}
			if(state=="")
			{
				alert("请选择要删除的数据！！");
			}
			else
			{
				window.location.href="role.servlet?state=delete&ids="+state;
			}
		},false)
	}
	function doAdd()
	{
		
		document.getElementById("btn_add").addEventListener("click",()=>{
			window.location.href="role.add.servlet?countpage="+${requestScope.page.countpage};
			
		},false)
	}
	function doUpdate()
	{
		document.getElementById("btn_update").addEventListener("click",()=>{
			var input_cbxs = document.getElementsByName("ids"); 
			let state = "";
			var count = 0;
			for(let i = 0 ,len = input_cbxs.length;i<len;i++)
			{
				if(input_cbxs[i].checked == true)
				{
					count ++;
					if(state=="")
					{
						state += input_cbxs[i].dataset.id; 
					}
					else
					{
						state+=",";
						
						state+=input_cbxs[i].dataset.id; 
					}
				}
			}
			if(count>1)
			{
				alert("一次只能修改一组数据，请重新选择您要修改的数据！！！");
			}
			else if(count==1)
			{
				window.location.href="role.update.servlet?ids="+state+"&countpage="+${requestScope.page.countpage};
			}
			else
			{
				alert("请选择您要修改的数据！！！");
			}
		},false)
	}
	function dojump_page()
	{
		document.getElementById("select_jump").addEventListener("change",()=>{
			window.location.href="role.servlet?state=init&countpage="+document.getElementById("select_jump").value;
		},false)
	}
	function dopermission()
	{
		document.getElementById("btn_permission").addEventListener("click",()=>{
			var input_cbxs = document.getElementsByName("ids"); 
			let state = "";
			var count = 0;
			for(let i = 0 ,len = input_cbxs.length;i<len;i++)
			{
				if(input_cbxs[i].checked == true)
				{
					count ++;
					if(state=="")
					{
						state += input_cbxs[i].dataset.id; 
					}
					else
					{
						state+=",";
						
						state+=input_cbxs[i].dataset.id; 
					}
				}
			}
			if(count>1)
			{
				alert("一次只能修改一组数据，请重新选择您要修改的角色！！！");
			}
			else if(count==1)
			{
				window.location.href="permission.role.servlet?state=init&roleid="+state+"&countpage="+${requestScope.page.countpage};
			}
			else
			{
				alert("请选择您要修改的角色！！！");
			}
		},false)
	}
	function init()
	{
		cbx_select();
		doDelete();
		doAdd();
		doUpdate();
		dojump_page();
		dopermission();
	}
	window.addEventListener( "load", ()=>{
		init();
	},false);
</script>
</head>
<body>
	<div id="div_table">
		<table class="bordered">
			<tbody id="show_tbody">
				<tr>
					<td><input type="checkbox" id = "all" name = "all"  /></td>
					<td>rolename</td>
					<td>desc</td>
				</tr>
				<c:forEach items ="${requestScope.page.pagelist }" var ="role">  
					<tr>
						<td>
							<input type = "checkbox"  name = "ids" data-id = "${role.id }"/>
						</td>
						<td>${role.rolename }</td>
						<td>${role.desc1 }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="table_row">
			<c:if test="${requestScope.page.countpage==1 }">首页 上一页</c:if>
			<c:if test="${requestScope.page.countpage!=1 }">
				<a href="role.servlet?state=init&countpage=1">首页</a> 
				<a href ="role.servlet?state=init&countpage=${requestScope.page.countpage - 1}">上一页</a> 
			</c:if>
			<select id ="select_jump">
				<c:forEach begin="1" end="${requestScope.page.totalpages }" var="i">
					<c:if test="${i==requestScope.page.countpage }">
						<option value="${i }" selected>${i }</option>
					</c:if>
					<c:if test="${i!=requestScope.page.countpage }">
						<option value="${i }">${i }</option>
					</c:if>
				</c:forEach>
			</select>
			<c:if test="${requestScope.page.countpage==requestScope.page.totalpages }">下一页 尾页</c:if>
			<c:if test="${requestScope.page.countpage!=requestScope.page.totalpages }">
				<a href="role.servlet?state=init&countpage=${requestScope.page.countpage +1 }">下一页</a>
				<a href="role.servlet?state=init&countpage=${requestScope.page.totalpages }">尾页</a>
			</c:if>
		</div>
		<div>
			<button type = "button" id = "btn_add" >增加</button>
			<button type = "button" id = "btn_delete">删除</button>
			<button type = "button" id = "btn_update">修改角色信息</button>
			<button type = "button" id = "btn_permission">修改角色权限</button>
		</div>
	</div>
	
</body>
</html>