<%@page import="com.jinan.www.entity.User"%>
<%@ page language="java" contentType="text/html; charset=  utf-8"
    pageEncoding="utf-8"%>
<%  
                //这里要指定一下编码，否则会乱码
                request.setCharacterEncoding("utf-8");

        %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index</title>
</head>
<h1>首页外层index</h1>
<%
	String s  = request.getAttribute("t").toString();
	User user  =(User) request.getAttribute("loginUser");
%>
<body>
 <jsp:useBean id="User" class="com.jinan.www.entity.User"></jsp:useBean>
<ul>
			
			<li>欢迎您：<%=user.getUsername() %></li>
			<li><%=user.getPassword() %></li>
   			<li><%=s %></li>
   			<li><a href="exit.jsp"><input type="button" value="exit"></a></li>
        </ul>


</body>
</html>