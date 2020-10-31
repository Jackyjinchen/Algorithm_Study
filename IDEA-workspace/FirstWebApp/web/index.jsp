<%@ page import="test.Person" %><%--
  Created by IntelliJ IDEA.
  User: Jackyjinchen
  Date: 2019/10/17
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!--java代码写在下面-->
    <%
        Person person=new Person();
        System.out.println(person.getPersonInfo());
    %>
</body>
</html>
