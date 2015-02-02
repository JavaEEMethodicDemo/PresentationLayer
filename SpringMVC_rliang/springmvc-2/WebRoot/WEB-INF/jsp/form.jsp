<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <form action="upload/uploadPic.do" method="post" enctype="multipart/form-data">
    	<label>ID：</label><input type="text" name="id"><br>
    	<label>姓名：</label><input type="text" name="name"><br>
    	<label>性别：</label><input type="text" name="gender"><br>
    	<label>地址：</label><input type="text" name="address"><br>
    	<label>生日：</label><input type="text" name="birthday"><br>
    	<label>照片：</label><input type="file" name="pic"><br>
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
