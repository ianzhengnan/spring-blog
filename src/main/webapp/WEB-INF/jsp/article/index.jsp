<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${sessionScope.user_session.username} - 所有文章</title>
</head>
<body>
<p><a href="${ctx }/account/main">主页</a></p>
<ul>
<c:forEach items="${requestScope.articles}" var="art" varStatus="stat">
	<li>
		<span><c:if test="${ art.top == '1' }">[置顶]</c:if></span>
		<span><a href="${ctx}/${sessionScope.user_session.username}/article/${art.id}">${art.subject}</a></span> &nbsp;&nbsp;
		<span>${art.createAt == null ? "空" : art.lastModifyAt}</span>&nbsp;&nbsp;<span>阅读：${art.visitCount == null ? 0 : art.visitCount}</span>&nbsp;&nbsp;<span>评论：${art.commentCount == null ? 0 : art.commentCount}</span>
		<span style="text-align: right;"><a href="${ctx}/postedit?id=${art.id}">编辑</a>|<a href="${ctx}/del?id=${art.id}">删除</a>|<c:choose><c:when test="${art.top == ''}"><a href="${ctx}/top?id=${art.id}">置顶</a></c:when><c:otherwise><a href="${ctx}/untop?id=${art.id}">取消置顶</a></c:otherwise></c:choose></span>
	</li>
</c:forEach>
</ul>
</body>
</html>