<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增文章</title>
<script>
	function submitForm(){
		return true;
	}
	
	function onSaveBtnPressed(e){
		document.getElementById("ispub").value = '2';
	}
	
	function onPostBtnPressed(e){
		document.getElementById("ispub").value = '1';
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
		<textarea name="content" rows="10" cols="30">${article.content}</textarea><br>
		<input type="submit" value="Save" id="saveBtn" onclick="onSaveBtnPressed()">&nbsp;&nbsp;
		<input type="submit" value="Post" id="postBtn" onclick="onPostBtnPressed()">
	</form>
</body>
</html>