<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@include file = "/view/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>장바구니</title>
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
<body link="black" vlink="black" alink="black">
   <section name="content" align="center" width="80%">
      <form name="form" method="POST" action="<c:url value='/view/order/form'/>" class="list">
         <table align="center">
            <tr>
               <td>완제품 목록</td>
            </tr>
            <c:set var="tIndex" value="0" />
            <c:set var="tTotalPrice" value="0"/>
            <c:forEach var="lineitem" items="${sessionScope.lineItemList}">
               <tr><td><!--첫번째 테이블 두번째 row(목록시)  -->
               		<br>
                     <table><!--item box -->
                        <tr><td width="120" height="120">
                           <img src="<c:url value= '/images/'/>${lineitem.item_no}.jpg" width="90%" height="90%"></td>
                           <td width="150" height="50" align="left">
                              <table width="90%">
                                 <tr><td>${lineitem.item_name}</td></tr>
                                 <tr><td>수량 : ${lineitem.item_amount}</td></tr>
                                 <tr><td>${lineitem.item_price}</td></tr>
                              </table>
                           </td>
                  		</tr>
                  		<tr><td align="left"><input type="button" value="삭제"
                     			onClick="location.href='<c:url value='/view/item/removeItemBasket'><c:param name="tIndex" value="${tIndex}"/></c:url>'"></td>
                     		<td align="left">합계 : ${lineitem.item_total_price}</td></tr>
                     </table>
                 </td></tr>
               <c:set var="tIndex" value="${tIndex+1}" />
               <c:set var="tTotalPrice" value="${tTotalPrice + lineitem.item_total_price}"/>
            </c:forEach>
            <tr>
               <td>DIY 목록</td>
            </tr>
            <c:set var="dIndex" value="0" />
            <c:set var="dTotalPrice" value="0"/>
            <c:forEach var="diy" items="${sessionScope.DIYList}">
               <tr><td>
                     <table>
                        <tr><td width="120" height="120">
                            <img alt="" src="<c:url value= '/images/slime_home.png'/>" width="60%" height="60%">
                           </td>
                           <td width="150" height="50" align="left">
                              <table width = "70%">
                                 <tr><td>${diy.diy_name}</td></tr>
                                 <tr><td>Scent : ${diy.scenttype}</td></tr>
                                 <tr><td>Deco : ${diy.decotype}</td></tr>
                                 <tr><c:set var="i" value="1"/><td>Color : ${diy.colortype}</td></tr>
                                 <tr><td>Glue : ${diy.gluetype}</td></tr>
                                 <tr><td>수량 : ${diy.diy_amount}</td></tr>
                                 <tr><td>${diy.diy_price}</td></tr>
                              </table>
                           </td>
                        </tr>
                        <tr><td align="left"><input type="button" value="삭제"
               				 onClick="location.href='<c:url value='/view/item/removeDiyBasket'><c:param name="dIndex" value="${dIndex}"/></c:url>'"></td>
               				 <td align = "left">합계 : ${diy.diy_total_price}</td></tr>
                     </table>
                  </td>
              </tr>
               <c:set var="dIndex" value="${dIndex+1}" />
               <c:set var="tTotalPrice" value="${tTotalPrice + diy.diy_total_price}"/>
            </c:forEach>
            <tr><td colspan="2" align="right">
                  <input type="button" value="주문하기" onClick="createOrder()"> &nbsp; 
                  <input type="hidden" name="itemTotalPrice" value="${tTotalPrice + dTotalPrice}">
                  	<c:if test="${(tTotalPrice + dTotalPrice) >= 40000}"><c:set var="dlPrice" value="0"/></c:if>
                    <c:if test="${(tTotalPrice + dTotalPrice) < 40000}"><c:set var="dlPrice" value="3000"/></c:if>
                  <input type="hidden" name="dlPrice" value="${dlPrice}">
                  <input type="button" value="취소" onClick="comeBack('<c:url value='/view/item/showAll'/>')">
                </td>
            </tr>
         </table>
      </form>
   </section>
<%@include file = "/view/footer.jsp" %>
</body>
</html>