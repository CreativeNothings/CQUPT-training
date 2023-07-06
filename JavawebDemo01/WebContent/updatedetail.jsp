<%@page import="ruanko.newspublish.entity.Article"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//从request里得到要修改的文章
	Article article = (Article)request.getAttribute("article");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatedetail.jsp' starting page</title>
    
	
  </head>
  
  <body>
    修改文章<br>
    <form action="ArticleUpdateDo" method="post">
    	<input type="hidden" name="id" value="<%= article.getId() %>" />
    	标题<input type="text" name="title" value="<%= article.getTitle() %>" />
		<br>作者<input type="text" name="author" value="<%= article.getAuthor() %>" />
    	<br>内容
    	<textarea name="content" rows="5" cols="50"  ><%= article.getContent() %></textarea>
    	<br><input type="submit" value="保存修改">
    </form>
    <a href="ArticleShowList" >返回文章列表</a>
  </body>
</html>
