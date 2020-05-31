<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/view/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>주문하기</title>
<script>
function createOrder(){
    form.submit();
}
function comeBack(targetUri) {
   form.action = targetUri;
   form.submit();
}
</script>
</head>
<body link = "black" vlink = "black" alink= "black">
<section name = "content" align = "center" width = "80%" >
<form name="form" method="POST" action="<c:url value='/view/order/complete'/>" class="list">
   <table  align = "center">
      <tr><td>주문자 정보</td></tr>
      <tr><td>
            <table width = "90%" align="center">
               <tr><td>성명</td><td><input type="text" value="${user.username}"></td></tr>
               <tr><td>주소</td><td><input type="text" name = "address" value="${user.address}"></td></tr>
            </table>
         </td>
      </tr>
      <br>
      <tr><td>결제 정보</td></tr>
      <tr><td>
            <table width="90%">
               <tr> <td>총금액</td><td>${itemTotalPrice}원</td></tr>
               <tr><td>배송비</td><td>${dlPrice}원</td></tr>
               <tr><td>최종 결제 금액</td><td>${totalPrice}원</td></tr>
               <tr><td>결제 수단</td><td>무통장 입금</td></tr>
               <tr><td>입금 계좌</td><td>슬라임 요정 국민 12345-45678989</td></tr>
            </table>
         </td>
      </tr>
      <tr><td>
      	<input type="button" value="결제하기" onClick="createOrder()"> &nbsp;
		<input type="button" value="취소" onClick="comeBack('<c:url value='/view/item/basket'/>')">
          </td>
      </tr>
   </table>
   <input type="hidden" name="userId" value="${user.id}" >
   <input type="hidden" name="totalPrice" value="${totalPrice}">
</form>
</section> 
<%@include file = "/view/footer.jsp" %>  
</body>
</html>