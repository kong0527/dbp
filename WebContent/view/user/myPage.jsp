<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file = "/view/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>myPage</title>
</head>
<body link="black" vlink="black" alink="black">
   <section name="content" align="center" width="80%">
      <table align="center"class="list" width="60%">
         <tr><td>사용자 정보</td></tr>
         <tr><td>
            <table align="center">
               <tr><td>이름</td><td>${user.username}</td></tr>
               <tr><td>ID</td><td>${user.id}</td></tr>
               <tr><td>Address</td><td>${user.address}</td></tr>
            </table>
          </td>
         </tr>
         <br>
         <tr><td>주문 내역</td></tr>
         <tr><td><table align="center" width ="60%"><tr><td width = "100">주문번호</td><td width = "100">배송지 정보</td><td width = "50">총금액</td></tr></tr></table></td></tr>
         <c:forEach var="order" items="${orderList}">
            <tr><td>
                  <table align="center" width ="60%">
                  <tr>
                        <td width = "100"><a href="<c:url value='/view/order/detail'><c:param name="orderno" value="${order.orderno}"/></c:url>">[${order.ordertime}]&nbsp;${order.orderno}</a></td>
                        <td width = "100">${order.order_address}</td>
                        <td width = "50">${order.totalprice}</td>
                     </tr>
                  </table>
               </td>
            </tr>
         </c:forEach>
      </table>
   </section>
<%@include file = "/view/footer.jsp"%>
</body>
</html>