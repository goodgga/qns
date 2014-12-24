<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQR测试与服务平台</title>
</head>
<body>
<%
	String username = request.getParameter("uname");
	if(username == null){
		username = "";
	}
%>
	<form action="login.do" method="post">
		<label for="uname">用户名：</label>
		<input type="text" name="uname" value="<%= username %>" /><span>@jiuqi.com.cn</span><br />
		<label for="upwd">密&nbsp;&nbsp;码：</label>
		<input type="password" name="upwd" /><br />
		<input type="submit" value="登陆"/>
		<input type="reset" value="重置"/>
		<!-- <a href="register.jsp">注册</a><br /> -->
		<%
			if(!username.equals("")){
		%>
			<br /><span style="color: red;">用户名或密码错误</span>
		<%
			}
		%>
	</form>
</body>
</html>