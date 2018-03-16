<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <%@ include file="/WEB-INF/view/jsp/common/base.jsp" %>
<link rel="stylesheet" media="screen" href="${basePath }/static/css/index/index.css" />
<script type="text/javascript">
	$(function(){
		var error = $("#error").val();
		if(error != ""){
			$("#eMsg").css("display","block");
		}
	})
</script>
<body id = "index">
<div><h2>Hello World!</h2></div>
<div>
	<input type="hidden" id="error" name="error" value="${eMsg }"/>
	<form action="login.do" method="post">
	<input id="username" name="username"/>
	<input id="password" name="password"/>
	<div id="eMsg" style="display: none"><i>${eMsg }</i></div>
	<button type="submit">提交</button>
	<a href="register.do">注册新用户</a>
	</form>
</div>
</body>
</html>
