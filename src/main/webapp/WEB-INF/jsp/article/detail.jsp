<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${sessionScope.user_session.username}的文章 - ${requestScope.article.subject}</title>
</head>
<body>
<article>
	<h1>${requestScope.article.subject}</h1>
	<p>${requestScope.article.content}</p>
</article>
</body>
</html>