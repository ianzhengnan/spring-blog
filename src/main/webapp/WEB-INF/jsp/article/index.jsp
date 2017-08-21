<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${sessionScope.user_session.username} - 所有文章</title>
</head>
<body>
<c:forEach items="${requestScope.articles}" var="art" varStatus="stat">
	<article>
		<h1><a href="${ctx}/${sessionScope.user_session.username}/article/${art.id}">${art.subject}</a></h1>
		<p>${art.content}</p>
	</article>
</c:forEach>
</body>
</html>