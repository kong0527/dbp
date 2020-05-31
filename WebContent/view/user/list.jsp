<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@include file = "/view/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
<section name = "content" align = "center">
<table style="width:100%" class="list">
  <tr>
  	<td width="20"></td>
  </tr>
  <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
  <tr>
	<td width="20"></td>
	<td> 
	  <br>
	  <table align = "center">
		<tr>
		  <td width="190" align="center" class = "list" height="22">사용자 ID</td>
		  <td width="200" align="center" class = "list">이름</td>
		  <td width="200" align="center" class = "list">주소</td>
		</tr>
		<c:forEach var = "user" items = "${userList}">
			<tr>
		  <td width="190" align="center" bgcolor="ffffff" height="20">
			${user.id}
		  </td>
		  <td width="200" bgcolor="ffffff" style="padding-left: 10">
		 	<a href="<c:url value='/view/user/list'>
					   <c:param name='userId' value='${user.id}'/>
			 		 </c:url>"></a>
			 ${user.username} 
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
			  ${user.address}
		  </td>
		</tr>
		</c:forEach>	  	
		  	
	  </table>	  	 
	  <br>   
	  </td>
  </tr>
</table>
</section>
<%@include file = "/view/footer.jsp"%>
</body>
