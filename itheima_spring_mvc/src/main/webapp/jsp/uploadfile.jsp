<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2022-2-9
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">
        用户名: <input type="text" name="username" > <br><br>
        文件名: <input type="file" name="uploadFile" > <br>
        <input type="submit" value="提交">
    </form>


</body>
</html>