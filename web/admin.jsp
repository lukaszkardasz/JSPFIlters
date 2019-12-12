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
    <title>Hello in Admin Panel!</title>
</head>
<body>
<h2>Hello in Admin Panel!</h2>
<h3>Your IP Adress is: <%= request.getRemoteAddr()%></h3>
<br/>
<a href="LogoutServlet">Logout</a>
</body>
</html>
