<%@ page import="javax.naming.Context" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/23
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jndi/myjdbc");//java:comp/env/是一个J2EE环境的定义
        Connection conn = ds.getConnection();
        try {
            ResultSet resultSet = conn.createStatement().executeQuery("select * from tb_area");
            while (resultSet.next()){
                System.out.println(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
</body>
</html>
