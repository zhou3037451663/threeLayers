<%@ page import="java.util.List" %>
<%@ page import="org.student.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 30374
  Date: 2019/12/31
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示</title>
</head>
<body>
<table border="1">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>住址</th>
    </tr>
    <%
        List<Student> list = (List<Student>) request.getAttribute("list");
        for (Student s : list) {
    %>
    <tr>
        <td><%=s.getSno()%></td>
        <td><%=s.getSname()%></td>
        <td><%=s.getSage()%></td>
        <td><%=s.getSaddress()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
