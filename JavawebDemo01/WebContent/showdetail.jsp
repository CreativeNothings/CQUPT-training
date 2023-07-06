<%@page import="ruanko.newspublish.entity.Article"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//从request里获取文章
	Article article = (Article)request.getAttribute("article");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示文章内容</title>
    
  </head>
  
  <body>
    显示文章详细内容 <br>
   文章标题:<h1><%= article.getTitle() %></h1> 
   <br>作者:<%= article.getAuthor() %>
   <br>文章内容:<%= article.getContent() %>
  </body>
</html>
