<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQR测试与服务平台</title>
</head>
<body>
	<form action="register.do" method="post">
		<label for="uname">&nbsp;&nbsp;用户名：</label>
		<input type="text" name="uname" /><span>@jiuqi.com.cn</span><br />
		<label for="upwd">&nbsp;&nbsp;&nbsp;&nbsp;密码：</label>
		<input type="password" name="upwd" /><br />
		<label for="upwd">确认密码：</label>
		<input type="password" name="upwd" /><br />
		<input type="submit" value="注册"/>
		<input type="reset" value="重置"/>
		<a href="login.jsp">登陆</a><br />
	</form>
</body>
</html>