<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>

	<%-- 每当访问index.jsp时, 会将所有请求转发到main.jsp页面下面 --%>
	<%
		response.sendRedirect(request.getContextPath()+"/pages/main.jsp");
	%>

</body>
</html>
