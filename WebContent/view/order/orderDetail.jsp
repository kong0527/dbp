<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@include file = "/view/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>orderDetails</title>
</head>
<body link="black" vlink="black" alink="black">
   <section name="content" align="center" width="80%">
      <table align="center" class="list">
         <tr><td><h2>주문 내역</h2></td></tr>
         <br>
         <tr><td>완제품 주문 내역</td></tr>
         <c:forEach var="lineitem" items="${lineItemList}">
            <tr><td><!--첫번째 테이블 두번째 row(목록시)  --> <br>
                  <table><!--item box -->
                     <tr>
                     	<td width="120" height="120"><img src="<c:url value= '/images/'/>${lineitem.item_no}.jpg" width="90%" height="90%"></td>
                        <td width="150" height="50" align="left">
                           <table width="90%">
                              <tr><td>수량 : ${lineitem.item_amount}</td></tr>
                           </table>
                        </td>
                     </tr>
                     <tr>
                        <td align="left" colspan="2">합계 : ${lineitem.item_total_price}</td>
                     </tr>
                  </table>
               </td>
            </tr>
         </c:forEach>
         <br>
         <tr><td>DIY 주문 내역</td></tr>
         <c:forEach var="diy" items="${DIYList}">
            <tr><td>
                  <table>
                     <tr>
                        <td width="120" height="120"><img alt="" src="<c:url value= '/images/slime_home.png'/>" width="60%" height="60%"></td>
                        <td width="150" height="50" align="left">
                           <table width="70%">
                           	<tr><td>${diy.diy_name}</td></tr>
                            <tr><td>Scent : ${diy.scenttype}</td></tr>
                            <tr><td>Deco : ${diy.decotype}</td></tr>
                            <tr><td>Color : ${diy.colortype}</td></tr>
                            <tr><td>Glue : ${diy.gluetype}</td></tr>
                            <tr><td>수량 : ${diy.diy_amount}</td></tr>
                            <tr><td>${diy.diy_price}</td></tr>
                           </table>
                  		 </td>
              		 </tr>
                     <tr>
                        <td align="left" colspan="2">합계 : ${diy.diy_amount * diy.diy_price}</td>
                     </tr>
                  </table>
               </td>
            </tr>
         </c:forEach>
      </table>
      <div style="text-align:center" class="list">
	  <br>
       	    <a href="<c:url value='/view/user/myPage' />">목록</a>
      </div>
   </section>
</body>
<%@include file = "/view/footer.jsp"%>
</html>