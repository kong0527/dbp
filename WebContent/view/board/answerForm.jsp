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
<script>
function answerBoard() {
	if (form.answer.value == "") {
		alert("답변을 입력하십시오.");
		form.title.focus();
		return false;
	}
	form.submit();
}

function boardList(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
<title>answer_QnA</title>
</head>
<body>
<form name="form" method="POST" action="<c:url value='/view/board/answer' /> ">
<input type="hidden" name="boardNo" value="${board.boardno}" />
<table align = "center" class="list">
	<tr height = "300">
		<td width="100" align="center" >내용</td>
		<td width="300" align="center">
			<textarea name="answer" rows="15" cols="50" wrap="on" class="list"></textarea>
		</td>
	</tr>
</table>
<table style="width: 100%" class="list">
	<tr>
		<td align="center">
			<input type="button" value="답변 등록" onClick="answerBoard()"> &nbsp;
			<input type="button" value="목록" onClick="boardList('<c:url value='/view/board/list' />')">
		</td>
	</tr>
</table>
</form>
</body>
</html>