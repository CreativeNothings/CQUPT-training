<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//得到要删除的文章的id
	int id = Integer.parseInt(request.getParameter("id"));
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'deteledetail.jsp' starting page</title>
  </head>
  
  <body>
    确认删除?<br>
    <form action="ArticleDelete" method="post">
    	<!-- 这里使用了隐藏域，我觉得这个id没有必要显示给用户，也不需要用户输入，但是需要在表单提交的时候能将这个id提交给服务器，所以使用了隐藏域 -->
    	<input type="hidden" value="<%= id %>" name="id">
    	<input type="submit" value="删除">
    </form>
    <a href="ArticleShowList" >返回文章列表</a>
  </body>
</html>
