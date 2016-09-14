<#ftl>
<html>
<head>
	<title>Login</title>
</head>
<body style="height: 100%; width: 500px; margin: 0 auto; padding: 50px; text-align: center;">
<h3 style="font-size: 16px; color: red;">登陆页面</h3>
<form action="<@spring.url "/login"/>" method="post" style="width: ">
	<input type="text" name="username" title="username"/>
	<br>
	<input type="password" name="password" title="password">
	<br>
	<input type="checkbox" name="remember-me" title="记住密码">
	<br>
	<input type="submit" value="提交">
	<br>
<@widget.test/>
</form>
</body>
</html>