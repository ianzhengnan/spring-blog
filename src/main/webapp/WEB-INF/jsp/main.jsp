<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
</head>
<body>
Welcome, <span>${sessionScope.user_session.username}</span><span><a href="${ctx }/account/logout">logout</a></span>
</body>
</html>