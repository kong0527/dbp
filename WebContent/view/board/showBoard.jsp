<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/view/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>QnA Board</title>
</head>
<body link="black" vlink="black" alink="black">
<table align = "center" width = "70%" class="list">
	<tr>
		<td width = "100" align = "center" height = "22">No</td>
		<td width = "400" align = "center" height = "22">제목</td>
		<td width = "200" align = "center" height = "22">ID</td>
		<td width = "200" align = "center" height = "22">날짜</td>
	</tr>
	<c:forEach var="board" items="${boardList}">
		<tr>
			<td width = "100" align = "center" height = "22">${board.boardno}</td>
			<td width = "400" align = "center" height = "22">
				<a class = "list" href="<c:url value='/view/board/detail'>
						   <c:param name="boardNo" value='${board.boardno}'/>
				 		 </c:url>">
				${board.title}</a>
			</td>
			<td width = "200" align = "center" height = "22">${board.id}</td>
			<td width = "200" align = "center" height = "22">${board.date}</td>
		</tr>
	</c:forEach>
</table>
<br>
<div style="text-align:center" class="list">
	<a href="<c:url value='/view/board/upload/form' />">질문등록</a>
</div>
<%@include file = "/view/footer.jsp"%>
</body>
</html>