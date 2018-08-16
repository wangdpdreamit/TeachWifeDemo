<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
</head>
<body>
	<form action="loginServlet?str=2" method="post">
		<div>
			用户名：<input type="text"  name="username"></br> 密
			&nbsp;码：<input type="text"  name="password"></br>
			<input type="submit" value="注册"> <input type="reset"
				value="重置">
		</div>
	</form>
</body>
</html>