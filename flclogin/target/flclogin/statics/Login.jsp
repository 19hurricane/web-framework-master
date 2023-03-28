<%--
  Created by IntelliJ IDEA.
  User: sove
  Date: 2021/3/19
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的登录界面</title>
</head>
<script src="../lib/jquery-3.4.1/jquery-3.4.1.min.js" type="text/javascript"></script>
<body>
<%
if(session.getAttribute("islogin")!=null)
{
%>
<script>
    alert("您还没有登录！")
</script>
<%
}
    session.removeAttribute("islogin");
Integer onlinecount=0;
if(session.getServletContext().getAttribute("onlinecount")!=null)
{
     onlinecount=(Integer)session.getServletContext().getAttribute("onlinecount");
}
%>
<h1>我的登录界面,当前在线人数<%=onlinecount%></h1>
<input id="btnClose" type="button" value="离开本页" onClick="closepage()" />
<input id="btnRefresh" type="button" value="刷新本页" onClick="refreshpage()" />
<form action="login" method="post">
    账号:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登入">
</form>

</body>

<script>
    function quit() {
        console.log(1)
        window.location.href='http://localhost:8080/quit'
    }
    function closepage() {

        if(confirm("您确定要关闭本页吗？")){
            window.location.href="www.baidu.com";
            window.close();
            $.get('http://localhost:8080/quit')
        }
        else{

        }
    }
    function refreshpage() {
        if(confirm("您确定要刷新本页吗？")){
           window.location.reload()
        }
        else{

        }

    }
    // window.onbeforeunload = function(e){
    //     e.returnValue=("确定离开当前页面吗？");
    // }
    // function quit()
    // {
    //
    //         alert("你在搞笑吗")
    // }
    //
    // window.addEventListener("onbeforeunload", quit(), false);


</script>
</html>
