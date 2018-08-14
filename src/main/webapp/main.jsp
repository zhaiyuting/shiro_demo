<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/8/13
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    普通用户可访问<a href="/ShiroDemo/user/info.jsp" target="_blank">用户信息页面</a>
    <br/>
    <br/>
    管理员可访问<a href="/ShiroDemo/admin/listUser.jsp" target="_blank">用户列表页面</a>
    <br/>
    <br/>
    <a href="/ShiroDemo/default/logout" target="_blank">Logout</a>
</body>
</html>
