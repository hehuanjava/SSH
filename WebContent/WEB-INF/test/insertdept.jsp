<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学校</title>
<script type="text/javascript">
</script>
</head>
<body>
<form:form action="${pageContext.request.contextPath }/isnertdept" method="POST" modelAttribute="dept">
 		<c:if test="${dept.id == null}"> 
			部门名称: <form:input path="name"/><br>
			部门经理: <form:input path="manager"/><br>
		</c:if>
	
		<c:if test="${dept.id != null }">
		 <input type="hidden" name="_method" value="PUT"/>		  
		<form:hidden path="id"/>
		部门名称: <form:input path="name"/><br>
		部门经理: <form:input path="manager"/><br>
 		 </c:if> 
		<input type="submit" value=提交>	
		</form:form> 
</body>
</html>