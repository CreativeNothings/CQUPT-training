
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功界面</title>
</head>
<body>
<%
    out.print("欢迎您，"+session.getAttribute("username"));
%>
</body>
</html>
