<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/view/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script>
var count;
function getCount(){
   if(form.count.value == "" || form.count.value == "0"){
         alert("수량을 입력하세요 ");
      form.count.focus();
      return false;
   }
   
   document.getElementById("totalPrice").value = form.count.value * ${item.item_price};
}

function createBasket(){
    if(form.count.value == "" || form.count.value == "0"){
            alert("수량을 입력하세요 ");
         form.count.focus();
         return false;
      }
    
    if(form.totalPrice.value == "" || form.totalPrice.value == "0"){
            alert("수량을 입력하세요 ");
         form.count.focus();
         return false;
      }
    form.submit();
   
}

function comeBack(targetUri) {
   form.action = targetUri;
   form.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>item_Detail</title>
</head>
<body link = "black" vlink = "black" alink= "black">
<section name = "content" align = "center" width = "80%" >
<form name="form" method="POST" action="<c:url value='/view/item/itemBasket' />" class="list">
   <table  align = "center">
      <tr>
         <td>
            <table>
               <tr><td><img src = "<c:url value = '/images/' />${item.item_no}.jpg" width = "300" height = "300" ></td></tr>
               <tr><td>${item.slimename}</td></tr>
            </table>
         </td>
         <td align="left">
            <table>
               <tr><td>판매가</td><td>${item.item_price}</td></tr>
               <tr><td>수량</td><td><input type="number" name = "count" step="1" value="0" min="0" onChange="getCount()"></td></tr>
               <tr><td>배송방법</td><td>택배</td></tr>
               <tr><td>배송비</td><td>3000원(40,000원 이상 구매 시 무료)</td></tr>
               <tr><td>총금액</td><td><input type="text" id = "totalPrice" name = "totalPrice" width = "100"></td></tr>
               <tr><td>상세정보</td><td >${item.detail}</td></tr>
            </table>
        </td>
     </tr>
      <tr><td colspan = "2" align="center">
         	<input type="button" value="장바구니" onClick="createBasket()"> 
         <input type="button" value="취소" onClick="comeBack('<c:url value='/view/item/list' />')">
         </td>
       </tr>
     </table>
     <input type="hidden" name="item_no" value="${item.item_no}">
     <input type="hidden" name="item_name" value="${item.slimename}">
     <input type="hidden" name="item_price" value="${item.item_price}">&nbsp;
 </form>
</section>
<%@include file = "/view/footer.jsp" %>
</body>
</html>