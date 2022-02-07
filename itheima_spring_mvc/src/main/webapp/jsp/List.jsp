<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2022-2-7
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <hr>
    <h1>表单提交</h1>

    <form action="${pageContext.request.contextPath}" method="post">
        <%-- 这样写耦合度及其高 --%>

        <%-- 表明是第一个User对象的username age属性值 --%>
        用户名: <input type="text" name="userList[0].username" /><br>
        年 龄: <input type="text" name="userList[0].age" /><br>
        <%-- 表明是第二个User对象的username age属性值 --%>
        用户名: <input type="text" name="userList[1].username" /><br>
        年 龄: <input type="text" name="userList[1].age" /><br>

    </form>


</body>
</html>
