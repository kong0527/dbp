<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.Board" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/view/header.jsp"%>
<%
	Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function boardUpdate() {
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
<title>update_QnA</title>
</head>
<body>
<br>
<form name = "form" method="POST" action="<c:url value='/view/board/update'/>">
	<input type="hidden" name="boardNo" value="${board.boardno}" />
	<table align = "center" class="list">
		<tr height="20">
			<td width="100" align="center" class="list">제목</td>
			<td width="500" align="center">
				<input type="text" style="width: 480" name="title" size="50" value="${board.title}">
			</td>
		</tr>
		<tr>
			<td width = "150" align = "center" height = "30">등록 날짜</td>
			<td width = "400" align = "center" heigth = "30">${board.date}</td>
		</tr>
		<tr height = "300">
			<td width="100" align="center" class="list">내용</td>
			<td width="500" align="center">
				<textarea name="inquiry" rows="15" cols="50" wrap="on">${board.inquiry}</textarea>
			</td>
		</tr>
	</table>
	<div style="text-align:center" class="list">
				<input type="button" value="수정" onClick="boardUpdate()"> &nbsp;
				<input type="button" value="목록" onClick="boardList('<c:url value='/view/board/list' />')">
	</div>
</form>
<%@include file = "/view/footer.jsp"%>
</body>
</html>