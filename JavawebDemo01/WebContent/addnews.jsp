<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加文章</title>
  </head>
  
  <body>
    添加文章 <br>
        <form action="ArticleAdd" method="post">
    	标题<input type="text" name="title" />
		<br>作者<input type="text" name="author" />
    	<br>内容<textarea name="content" rows="5" cols="50"></textarea>
    	<br><input type="submit" value="添加">
    </form>
  </body>
</html>
