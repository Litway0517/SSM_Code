<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2022-2-7
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%-- 引入js的库 --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-3.3.1.js"></script>

    <script type="text/javascript">

        // 准备数据
        let userList = [];
        userList.push({username:"zhangsan", age:95});
        userList.push({username: "lisi", age: 99});

        // 发送ajax请求, 这里面需要复习
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/user/quick15",
            data: JSON.stringify(userList),
            // 这里面的类型不要大写UTF-8. 另外也不要把content写成了context
            contentType: "application/json;charset=utf-8"
        });
    </script>


</head>
<body>



</body>
</html>
