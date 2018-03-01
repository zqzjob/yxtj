<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	request.setAttribute("basePath", path);
%>

<script src="${basePath }/static/js/common/jquery-1.11.1.js" type="text/javascript"></script>
<script src="${basePath }/static/js/common/jquery-form.js" type="text/javascript"></script>
<script src="${basePath }/static/js/common/base.js" type="text/javascript"></script>