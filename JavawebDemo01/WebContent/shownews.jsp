<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="ruanko.newspublish.entity.Article" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//从request里获取文章列表
	List<Article> articles = (List<Article>)request.getAttribute("articles");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shownews.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    文章列表<a href="addnews.jsp">添加文章</a><br>
    <table border="1">
    	<tr>
    		<td>标题</td>
    		<td>创建时间</td>
    		<td>操作</td>
    	</tr>
	   <%
	   		for (int i = 0; i < articles.size(); i++){
	   			Article article = (Article)articles.get(i);
	    %>
	    <tr>
			<td><a href="ArticleShow?id=<%= article.getId() %>"><%= article.getTitle() %></a></td>
			<td><a href="ArticleShow?id=<%= article.getId() %>"><%= article.getCreateTime() %></a></td>
			<td><a href="deteledetail.jsp?id=<%= article.getId() %>">删除</a> <a href="ArticleUpdate?id=<%= article.getId() %>">修改</a></td>
		</tr>
	    <%
	       }
	     %>
    </table>
  </body>
</html>
