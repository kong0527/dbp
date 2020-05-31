<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@include file = "/view/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script>
function userCreate() {
	if (form.id.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.userId.focus();
		return false;
	} 
	if (form.pw.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}
	if (form.pw.value != form.pw2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.name.focus();
		return false;
	}
	if (form.username.value == "") {
		alert("이름을 입력하십시오.");
		form.name.focus();
		return false;
	}
	if (form.address.value == "") {
		alert("주소를 입력하십시오.");
		form.address.focus();
		return false;
	}
	form.submit();
}

function userList(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
</head>
<body link = "black" vlink = "black" alink= "black">
<section>
<br>
<!-- registration form  -->
<form name="form" method="POST" action="<c:url value='/view/user/register' />">
  <table style="width: 90%">
    <tr>
      <td width="20"></td>
	  <td> 
	    <!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${registerFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>
	    <br>	  
	    <table align="center">
	  	  <tr height="40">
			<td width="100" align="center" class = "list" >사용자 ID</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240;" name="id">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="100" align="center" class = "list">비밀번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="password" style="width: 240" name="pw">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="100" align="center" class = "list">비밀번호 확인</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="password" style="width: 240" name="pw2">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="100" align="center" class = "list">이름</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="username" 
				 	<c:if test="${registerFailed}">value="${user.username}"</c:if>>
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="100" align="center" class = "list">주소</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="address">
			</td>
		  </tr>	  
	    </table>
	    <br>	  
	    <table style="width: 100%">
		  <tr>
			<td align="center">
			<input type="button" value="회원 가입" onClick="userCreate()"> &nbsp;
			<input type="button" value="목록" onClick="userList('<c:url value='/view/user/list' />')">
			</td>
		  </tr>
	    </table>
	  </td>
    </tr>
  </table>  
</form>
</section>
<%@include file = "/view/footer.jsp" %>
</body>
</html>