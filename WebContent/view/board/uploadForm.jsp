<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/view/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script>
function boardUpload() {
	if (form.title.value == "") {
		alert("제목을 입력하십시오.");
		form.title.focus();
		return false;
	}
	if (form.inquiry.value == "") {
		alert("내용을 입력하십시오.")
		form.inquiry.focus();
		return false;
	}
	form.submit();
}

function boardList(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
<title>upload_QnA</title>
</head>
<body link = "black" vlink = "black" alink= "black">
<br>
<form name="form" method="POST" action="<c:url value='/view/board/upload' /> ">
<table style="width:50%" align = "center" class="list">
	<tr height="20">
		<td width="100" align="center" class="list">제목</td>
		<td width="500" align="center">
			<input type="text" style="width: 480" name="title" size="50">
		</td>
	</tr>
	<tr height = "400">
		<td width="100" align="center" class="list">내용</td>
		<td width="500" align="center">
			<textarea name="inquiry" rows="15" cols="50" wrap="on"></textarea>
		</td>
	</tr>
</table>
<table style="width: 100%" class="list">
	<tr>
		<td align="center">
			<input type="button" value="질문등록" onClick="boardUpload()"> &nbsp;
			<input type="button" value="목록" onClick="boardList('<c:url value='/view/board/list' />')">
		</td>
	</tr>
</table>
</form>
</body>
</html>