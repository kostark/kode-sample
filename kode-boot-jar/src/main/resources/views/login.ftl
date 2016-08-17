<#ftl>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="<@spring.url "/login"/>" method="post">
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