<%@ page import="java.util.List" %>
<%@ page import="org.student.entity.Student" %>
<%@ page import="org.student.entity.Page" %><%--
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
        Page list = (Page) request.getAttribute("p");
        for (Student s : list.getStudents()) {
    %>
    <tr>
        <td><%=s.getSno()%>
        </td>
        <td><%=s.getSname()%>
        </td>
        <td><%=s.getSage()%>
        </td>
        <td><%=s.getSaddress()%>
        </td>
    </tr>
    <%
        }
    %>
    <%
        if (list.getCurrentPage() == 0) {
    %>
    <a href="QueryServlet?currentPage=<%=list.getCurrentPage()+1%>">下一页</a>
    <a href="QueryServlet?currentPage=<%=list.getTotalPage()-1%>">尾页</a>
    <%
    } else if (list.getCurrentPage() == list.getTotalPage()-1) {
    %>
    <a href="QueryServlet?currentPage=0">首页</a>
    <a href="QueryServlet?currentPage=<%=list.getCurrentPage()-1%>">上一页</a>
    <%
    } else {
    %>
    <a href="QueryServlet?currentPage=0">首页</a>
    <a href="QueryServlet?currentPage=<%=list.getCurrentPage()-1%>">上一页</a>
    <a href="QueryServlet?currentPage=<%=list.getCurrentPage()+1%>">下一页</a>
    <a href="QueryServlet?currentPage=<%=list.getTotalPage()-1%>">尾页</a>
    <%
        }
    %>


</table>
</body>
</html>
