<#ftl>
<html>
<head>
    <title>Home</title>
    <link rel='stylesheet' href='<@spring.url "/webjars/bootstrap/3.1.0/css/bootstrap.min.css"/>'>
    <link rel='stylesheet' href='<@spring.url "/webjars/jquery/1.12.4/jquery.min.css"/>'>
    <script src="webjars/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
Message: ${message}
<br/>
User count: ${userCount!0}
<br/>
Date: ${date}

<div>
<@spring.message "web.label.username"/>: <input type="text" placeholder="<@spring.message "web.label.username"/>">
<@spring.message "web.label.password"/>: <input type="password" placeholder="<@spring.message "web.label.password"/>">
</div>

<footer style="font-size: 16px; width: 100%; height: 200px; line-height: 200px; text-align: center;">
    Koweb.top
</footer>
</body>
</html>