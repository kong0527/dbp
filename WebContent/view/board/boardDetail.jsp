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
<title>QnA Board</title>
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function boardRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
</script>
</head>
<body>
<table align = "center" style="width:30%" class="list">
	<tr>
		<td width = "150" align = "center" height = "40">제목</td>
		<td width = "400" align = "center" heigth = "40">${board.title}</td>
	</tr>
	<tr>
		<td width = "150" align = "center" height = "40">등록 날짜</td>
		<td width = "400" align = "center" heigth = "40">${board.date}</td>
	</tr>
	<tr>
		<td width = "150" align = "center" height = "150">질문</td>
		<td width = "400" align = "center" height = "150">${board.inquiry}</td>
	</tr>
	<tr>
		<td width = "150" align = "center" height = "150">답변</td>
		<td width = "400" align = "center" height = "150">${board.answer}
			<c:if test="${empty board.answer}">
				판매자가 아직 답변을 등록하지 않았습니다.
			</c:if>
		</td>
	</tr>
</table>
<div style="text-align:center" class="list">
	    <a href="<c:url value='/view/board/update/form'>
	     		   <c:param name='boardNo' value="${board.boardno}"/>
	     		   <c:param name='userId' value='${board.id}' />
			 	 </c:url>">수정</a> &nbsp;
 	    <a href="<c:url value='/view/board/remove'>
				   <c:param name='boardNo' value='${board.boardno}'/>
				   <c:param name='userId' value='${board.id}' />
			 	 </c:url>" onclick="return boardRemove();">삭제</a> &nbsp;
		<a href="<c:url value='/view/board/answer/form'>
	     		   <c:param name='boardNo' value='${board.boardno}'/>
			 	 </c:url>">답변</a> &nbsp;
 	    <a href="<c:url value='/view/board/list' />">목록</a>
 </div> 	    
 	    <br><br>
 	    <c:if test="${updateFailed || deleteFailed || answerFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if> 
	    <br><br>

<%@include file = "/view/footer.jsp"%>
</body>
</html>