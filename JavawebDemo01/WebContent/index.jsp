<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="ruanko.newspublish.entity.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
  //从request里得到用户信息
  User user = (User)request.getAttribute("user");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>欢迎！<%= user.getNickName() %></title>
	
  </head>
  
  <body>
  欢迎！最小文章发布系统<a href="ArticleShowList">点击进入</a><br>
  </body>
</html>
