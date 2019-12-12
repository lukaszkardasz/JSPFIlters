<%--
  Created by IntelliJ IDEA.
  User: n2god
  Date: 12/12/2019
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
%>
<html>
<head>
    <title>Zaloguj się</title>
</head>
<body>
<h2>Zaloguj się</h2>
<form action="LoginServlet" method="post">
    Login: <input type="text" name="username">
    <br/>
    Hasło: <input type="password" name="password">
    <br/>
    <input type="submit" Zaloguj>
</form>
</body>
</html>
