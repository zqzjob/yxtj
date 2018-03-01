<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/view/jsp/common/base.jsp" %>
</head>
<body>
 	<label style="display: none" id="msg"></label>
 <form id="ajaxForm" action="addUser.do" method="post">
 	<div>
		用户名：<input id="username" name="username" value="${data.username }" />
	</div>
	<div>
		密码：<input id="password" name="password" value="${data.password }" />
	</div>
	<div>
		生日：<input id="birthday" name="birthday" value="${data.birthday }" />
	</div>
	<div>
		性别：<input id="sex" name="sex" value="${data.sex }" />
	</div>
	<div>	
		手机：<input id="tellphone" name="tellphone" value="${data.tellphone }" />
	</div>
	<div>	
		邮箱：<input id="email" name="email" value="${data.email }" />
	</div>
 </form>
	<div>
		<input id="ajaxSubmit" type="button" value = "提交"/><a href="/yixiantianji">去登录</a>
	</div>
</body>
</html>