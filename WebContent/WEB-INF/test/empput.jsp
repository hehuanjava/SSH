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
<form:form action="${pageContext.request.contextPath }/empadd" method="POST" modelAttribute="emp" >
 		<c:if test="${emp.id == null}"> 
			员工名称: <form:input path="name"/><br>
			部门: <select name="dept1"id="">
	 			<c:forEach items="${Dept}" var="test">
	 				<option value="${test.id }">${test.name}</option>
	 			</c:forEach>
	 	 		 </select><br>
		</c:if>
		<c:if test="${emp.id != null }">
		 <input type="hidden" name="_method" value="PUT"/>		  
		<form:hidden path="id"/>
		员工名称: <form:input path="name"/><br>
		部门:<select name="Deptt"id="">
	 		<c:forEach items="${Deptt}" var="test">
	 		<option value="${test.id }" <c:if test="${test.id==Dept1}">selected </c:if>>${test.name }</option>
	 		</c:forEach>
	 		  </select><br>  
 		 </c:if> 
		 员工性别:<form:radiobuttons path="sex" items="${genders}"/><br> 
		员工年龄: <form:input path="age"/><br>
		<input type="submit" value=提交>	
		</form:form> 
</body>
</html>