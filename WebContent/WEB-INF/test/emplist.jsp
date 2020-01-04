<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工查询</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script>
</head>
<script type="text/javascript">
$(function(){
	alert(1)
	getEmp();
}); 
function getEmp(){
	alert(1)
	$.ajax({
		type:"post",
		url:'<%=request.getContextPath()%>/emp',
		success:function(emplist){
			var  html="";
			$.each(emplist,function(i,obj){
					html += "<tr  height='40px'><td align='center'>"+obj.id+"</td>"+
					"<td  align='center'>"+obj.name+"</td>"+
					"<td  align='center'>"+obj.sex+"</td>"+
					"<td  align='center'>"+obj.age+"</td>"+
					"<td  align='center'>"+obj.dept.name+"</td>"+
					"<td  align='center'>"+
					"<input type='button' value='修改' onclick=\"javascript:location.href='<%=request.getContextPath()%>/empadd"+obj.id+"'\">"+
					"<input type='button' value=\"删除\"onclick=delEmp('"+obj.id+"')>"+ 
					"</td></tr>";	
				});
				
				$('#empId').html(html)		
			},
	})
}

function delEmp(id){
	alert(122)
	if (confirm("是否删除id为：'"+id+"'的员工信息?")) {
		$.ajax({  
			url:'<%=request.getContextPath()%>/empadd'+id,  
            type:'POST',
            success:function(data){ 
				if(data == "kt"){
					alert("删除成功");
					window.location.href="<%=request.getContextPath()%>/start";//返回查询页面 
				}else{
					alert("删除失败");
				}
            }  
        }) 
	}else{
		alert("取消删除数据!");
	}
}
</script>
<body>
<a href="empadd">添加</a>
<a href="fuck">部门管理</a>
		<div style="text-align: center;">
		<table class="imagetable" style="margin: 0 auto" border="1" cellpadding ="10" cellspacing="0">
		<tr height=10>
		<th>员工编号</th>
		<th>员工名字</th>
		<th>性别</th>
		<th>年龄</th>
		<th>部门名称</th>
		<th>操作</th>
		</tr>
		<tbody id ="empId"></tbody>
		</table>
		</div>
		<br>	

</body>
</html>