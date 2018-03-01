<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <%@ include file="/WEB-INF/view/jsp/common/base.jsp" %>

<script type="text/javascript">
	$(function(){
		var error = $("#error").val();
		if(error != ""){
			$("#eMsg").css("display","block");
		}
	})
</script>
<body>
<h2>Hello World!</h2>
<input type="hidden" id="error" name="error" value="${eMsg }"/>
<form action="login.do" method="post">
<input id="username" name="username"/>
<input id="password" name="password"/>
<div id="eMsg" style="display: none"><i>${eMsg }</i></div>
<button type="submit">提交</button>
<a href="register.do">注册新用户</a>
</form>
</body>
</html>
