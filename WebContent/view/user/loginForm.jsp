<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@include file = "/view/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Homepage Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script>
function login() {
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
	form.submit();
}

function userCreate(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
</head>
<body link = "black" vlink = "black" alink= "black">
<section>
<br>
<!-- login form  -->
<div>
<form name="form" method="POST" action="<c:url value='/view/user/login' />">
  <table style="width:100%" >
	<tr>
	  <td>
	    <!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${loginFailed}">
	  	  <br><font color="red"><c:out value="${exception.getMessage()}" /></font><br>
	    </c:if>
	    <br>	  
	    <table align = "center">
	  	  <tr height="40">
			<td width="50" align="center" class="list">사용자 ID</td>
			<td width="250" bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="id">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="50" align="center" class="list">비밀번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left:10">
				<input type="password" style="width:240" name="pw">
			</td>
		  </tr>
	    </table>
	    <br>	  
	    <table style="width:95%">
		  <tr>
			<td align = "center">
			<input type="button" value="로그인" class="list" onClick="login()"> &nbsp;
			<input type="button" value="회원가입" class="list" onClick="userCreate('<c:url value='/view/user/register/form' />')">
			</td>						
		  </tr>
	    </table>
	  </td>	  
	</tr>
  </table>  
</form>
</div>
</section>
<%@include file = "/view/footer.jsp" %>
</body>
</html>