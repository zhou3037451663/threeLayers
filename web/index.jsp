<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>学生管理系统</title>
  </head>
  <body>
  <form action="StudentServlet">
    学号: <input type="text" name="sno"><br/>
    姓名: <input type="text" name="sname"><br/>
    年龄: <input type="text" name="sage"><br/>
    住址: <input type="text" name="saddress"><br/>
    <input type="submit" value="添加">
  </form>
  </body>
</html>