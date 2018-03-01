<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>用户名称</td>
				<td>性别</td>
				<td>生日</td>
				<td>电话</td>
				<td>邮箱</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="page.list" var="data">
				<tr>
					<td>${data.name }</td>
					<td>${data.sex }</td>
					<td>${data.birthday }</td>
					<td>${data.tellphone }</td>
					<td>${data.email }</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
	<%@include file = "/WEB-INF/view/jsp/common/page.jsp" %>
</body>
</html>