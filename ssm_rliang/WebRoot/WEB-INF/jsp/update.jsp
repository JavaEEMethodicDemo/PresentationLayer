<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'save.jsp' starting page</title>
    
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
    <form action="person/update.do" method="post">
    	<input type="hidden" name="personId" value="${person.personId }">
	    <table align="center" width="80%">
	    	<tr>
	    		<td><label>姓名：</label><input type="text" name="name" value="${person.name }"></td>
	    		<td><label>性别：</label>
	    			<select name="gender">
	    				<option value="">--请选择--</option>
	    				<option value="1" <c:if test="${person.gender == 1 }">selected</c:if>  >男</option>
	    				<option value="0" <c:if test="${person.gender == 0 }">selected</c:if>>女</option>
	    			</select>
	    		</td>
	    		<td><label>地址：</label><input type="text" name="personAddr" value="${person.personAddr }"></td>
	    		<td><label>生日：</label><input type="text" name="birthday" value="<fmt:formatDate value="${person.birthday }" pattern="yyyy-MM-dd"/>"></td>
	    		<td><input type="submit" value="修改"></td>
	    	</tr>
	    </table>
    </form>
  </body>
</html>
