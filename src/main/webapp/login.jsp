<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/8/13
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="color:red; font-size:22px;">${error_msg}</div>

    <form action="login" method="GET">
        姓名：<input type="text" name="username"/><br/>
        密码：<input type="text" name="password"/><br/>
        <input type="submit" value="确认"/>
    </form>
</body>
</html>
