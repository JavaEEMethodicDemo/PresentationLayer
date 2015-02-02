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
	<script type="text/javascript">
		function delPerson(personId){
			if(confirm("确认要删除吗?")){
				window.location.href = "person/delete.do?personId="+personId;
			}
		}
	</script>
  </head>
  
  <body>
  	<form action="person/selectPersonByCondition.do" method="post">
	    <table align="center" width="80%">
	    	<tr>
	    		<td><label>姓名：</label><input type="text" name="name" value="${name }"></td>
	    		<td><label>性别：</label>
	    			<select name="gender">
	    				<option value="">--请选择--</option>
	    				<option value="1" <c:if test="${gender == 1 }">selected</c:if>  >男</option>
	    				<option value="0" <c:if test="${gender == 0 }">selected</c:if>>女</option>
	    			</select>
	    		</td>
	    		<td><label>地址：</label><input type="text" name="personAddr" value="${personAddr }"></td>
	    		<td><label>生日：</label><input type="text" name="birthday" value="<fmt:formatDate value="${birthday }" pattern="yyyy-MM-dd"/>"></td>
	    		<td><input type="submit" value="查询"></td>
	    	</tr>
	    </table>
    </form>
    <table align="center"  width="80%">
    	<tr><td>
    		<a href="person/toSave.do">添加</a>
    	</td></tr>
    </table>
    <table align="center" border="1px;" width="80%">
    	<tr>
    		<th>姓名</th>
    		<th>性别</th>
    		<th>地址</th>
    		<th>生日</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${pList }" var="person">
	    	<tr>
	    		<td>${person.name }</td>
	    		<td>
	    			<c:if test="${person.gender == 1 }">男</c:if>
	    			<c:if test="${person.gender == 0 }">女</c:if>
	    		</td>
	    		<td>${person.personAddr }</td>
	    		<td><fmt:formatDate value="${person.birthday }" pattern="yyyy-MM-dd"/></td>
	    		<td align="center"><a href="person/toUpdate.do?personId=${person.personId }">修改</a>&nbsp;
	    		<a href="javascript:void(0)" onclick="delPerson(${person.personId})">删除</a></td>
	    		
	    	</tr>
    	</c:forEach>
    	
    </table>
  </body>
</html>
