<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录检查</title>
</head>
<body>
<%
    String username =request.getParameter("username");
    String password =request.getParameter("password");
    if(username.equals(password)){
    	session.setAttribute("username",username);
        response.sendRedirect("ok.jsp");
    }else {
        response.sendRedirect("error.html");
    }
%>
</body>
</html>
