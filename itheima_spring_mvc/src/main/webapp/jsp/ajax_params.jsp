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
    <script src="${pageContext.request.contextPath}/static/jQuery/jquery-3.3.1.js"></script>

    <script>
        // 准备数据
        let userList = new Array();
        userList.push({username:"zhangsan", age:95});
        userList.push({username: "lisi", age: 99});

        // 发送ajax请求, 这里面需要复习
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/user/quick15",
            data: JSON.stringify(userList),
            contextType: "application/json; charset=UTF-8",
        });




    </script>


</head>
<body>



</body>
</html>
