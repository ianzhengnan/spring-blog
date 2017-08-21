<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增文章</title>
<script type="text/javascript" src="${ctx }/js/jquery.1.4.4.min.js"></script>
<script type="text/javascript" src="${ctx }/js/xheditor-1.2.2.min.js"></script>
<script type="text/javascript" src="${ctx }/js/xheditor_lang/zh-cn.js"></script>
<script>
	$(pageInit);
	
	function submitForm(){
		return true;
	}
	
	function onSaveBtnPressed(e){
		document.getElementById("ispub").value = '2';
	}
	
	function onPostBtnPressed(e){
		document.getElementById("ispub").value = '1';
	}
	
	function pageInit(){
		$('#content').xheditor({upLinkUrl:'/upload',upLinkExt:"zip,rar,txt",upImgUrl:'/upload',upImgExt:'jpg, jpeg,png,gif'});
	}
	
</script>
</head>
<body>
	<form action="postedit" method="post" onsubmit="return submitForm()">
		<input id="ispub" type="hidden" name="isPub" value="2">
		<input type="hidden" name="id" value="${article.id}">
		Subject: <br>
		<input type="text" name="subject" value="${article.subject}"><br>
		Content: <br>
		<textarea id="content" name="content" class="xheditor{upLinkUrl:'/upload',upLinkExt:'zip,rar,txt',upImgUrl:'/upload',upImgExt:'jpg, jpeg,png,gif'}" rows="20" cols="150">${article.content}</textarea><br>
		<input type="submit" value="Save" id="saveBtn" onclick="onSaveBtnPressed()">&nbsp;&nbsp;
		<input type="submit" value="Post" id="postBtn" onclick="onPostBtnPressed()">
	</form>
</body>
</html>