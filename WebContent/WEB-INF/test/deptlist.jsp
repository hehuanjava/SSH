<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部门</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script>
</head>

<script type="text/javascript">
$(function() {
	getDept();
}); 

function getDept() {
	$.ajax({
		type:"post",
		url:'<%=request.getContextPath()%>/querydept',
		success:function(deptList){
			var html="";
			$.each(deptList,function(i,obj){
				html += "<tr  height='40px'><td align='center'>"+deptList[i].id+"</td>"+
				"<td  align='center'>"+obj.name+"</td>"+
				"<td  align='center'>"+obj.manager+"</td>"+
				"<td  align='center'>"+
				"<input type='button' value='修改' onclick=\"javascript:location.href='<%=request.getContextPath()%>/isnertdept"+obj.id+"'\">"+
				"<input type='button' value=\"删除\"onclick=a('"+obj.id+"')>"+ 
				"</td></tr>";	
			});

			$('#deptId').html(html)			
		},
	})
}

function a(id){
	alert(1)
		$.ajax
	({
			url:"<%=request.getContextPath() %>/empp/"+id,
			type: "get",
			async:true,
			success:function(list)
		{
				alert(list.name)
			if(confirm("是否要删除")){
				
			if(list==0){	
				//学校没有学生就删除学校 调b函数
			b(id);
				//返回的值学校里有学生 就提示有多少学生  是否确定删除
			}if(list!=0)
			{
				if(confirm("部门还有"+list+"个员工,确定要删除吗?")){
					b(id);
				}else{
				alert("取消了删除")	
				}	
			
			}
				}else
				{
					alert("取消了删除")
				}
			
		},
			error:function(a,b,c){
			alert(a);
			
			}
	});	
}
//b函数
	function b(id){
		$.ajax({
			url:"<%=request.getContextPath()%>/empp/"+id,
			type:"post",//post请求
			asyns:true,//同步
			data:{'_method':'delete'},//类型转换
			success:function(){
				alert("删除成功")	
		location.reload();//刷新当前页
			},
			error:function(a,b,c){
				alert("删除失败")
			}
			
		});
	}
	
	
</script>
<body >
	<a href="isnertdept">添加</a>
	<a href="start">员工管理</a>
	<div style="text-align: center;">
		<table class="imagetable" style="margin: 0 auto" border="1" cellpadding ="10" cellspacing="0">
		<tr height=10>
		<th>部门编号</th>
		<th>部门名称</th>
		<th>部门经理</th>
		<th>操作</th>
		</tr>
		<tbody id ="deptId"></tbody>
		</table>
		</div>
		<br>		
	<!-- 	就将数据读出，以免数据泄漏，造成错误。 -->
<%-- 		<jsp:include page=".jsp" flush="true"/> --%>
	
</body>
</html>