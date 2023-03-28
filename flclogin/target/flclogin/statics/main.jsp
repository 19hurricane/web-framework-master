<%--
  Created by IntelliJ IDEA.
  User: sove
  Date: 2021/3/21
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="flclogin.entity.User" %>>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<%
    ServletContext context=request.getSession().getServletContext();
    Integer logincount=(Integer)context.getAttribute("logincount");
    String username="";
    if(session.getAttribute("user")!=null)
    {
        User user=(User)session.getAttribute("user");
        username=user.getUsername();
    }


%>
<input type="button" value="退出" onclick="logout()">
<p>当前登录用户数<%=logincount%></p>
<p>欢迎用户<%=username%>登录，登录成功！</p>


</body>
<script>
    function logout() {
        window.location.href='http://localhost:8080/logout'
    }
    function refreshpage() {
        window.location.reload();
    }
    setTimeout('refreshpage()',3000)
    
</script>
</html>
