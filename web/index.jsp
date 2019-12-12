<%--
  Created by IntelliJ IDEA.
  User: n2god
  Date: 12/12/2019
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
%>
<html>
  <head>
    <title>Hello</title>
  </head>
  <body>
  <h2>Witaj, Twój adres IP: <%=request.getRemoteAddr()%></h2>
  <a href="admin.jsp">Admin panel</a>
  </body>
</html>
