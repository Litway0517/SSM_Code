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
    <h1>表单1</h1>
    <hr>
    <form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">
        用户名: <input type="text" name="username" > <br><br>
        单文件测试 -> 文件名: <input type="file" name="uploadFile" > <br>
        <input type="submit" value="提交">
    </form>


    <h1>表单2</h1>
    <hr>
    <form action="${pageContext.request.contextPath}/user/quick23" method="post" enctype="multipart/form-data">
        用户名: <input type="text" name="username" > <br><br>
        单文件测试1 -> 文件名: <input type="file" name="uploadFiles" > <br>
        单文件测试2 -> 文件名: <input type="file" name="uploadFiles" > <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
