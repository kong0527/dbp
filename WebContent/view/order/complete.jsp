<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file = "/view/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css'/>" type="text/css">
<title>Insert title here</title>
</head>
<body link="black" vlink="black" alink="black">
   <section name="content" align="center" width="80%">
            <p class = "list">감사합니다. 주문이 정상적으로 완료되었습니다.</p>
            <p class = "list">고객님의 주문번호는
            	<a class = "list" href="<c:url value='/view/order/detail'>
                     <c:param name="orderno" value='${order.orderno}'/> </c:url>">
                  ${order.orderno}번</a>입니다.</p>
   </section>
<%@include file = "/view/footer.jsp" %>
</body>
</html>