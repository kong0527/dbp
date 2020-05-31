<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@include file = "/view/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script>
var count;
var resultPrice;
var color_p;
var scent_p;
var deco_p;
var glue_p;
function DiyPrice(){
   resultPrice = 0;
   var color = document.getElementById("color");
   if (form.color.value == "")
      resultPrice += 0;
   else{
      for(i=0; i<form.color.options.length; i++) {
          if(form.color.options[i].selected == true) {
             switch (i){
                case 1 : // black
                   resultPrice += 600;
                   break;
                case 2 : // brown
                   resultPrice += 900;
                   break;
                case 3 : // grape
                   resultPrice += 800;
                   break;
                case 4 : // red
                   resultPrice += 500;
                   break;
                case 5 : // skyblue
                   resultPrice += 400;
                   break;
                case 6 : //white
                   resultPrice += 300;
                   break;
                case 7 : //yellow
                   resultPrice += 700;
                   break;
             }
              break;
          }
      }
   }
   var scent = document.getElementById("scent");
   if (form.scent.value == "")
      resultPrice += 0;
   else{
      for(i=0; i<form.scent.options.length; i++) {
          if(form.scent.options[i].selected == true) {
             switch (i){
                case 1 : // banana
                   resultPrice += 1200;
                   break;
                case 2 : // chocolate
                   resultPrice += 1400;
                   break;
                case 3 : // mango
                   resultPrice += 1100;
                   break;
                case 4 : // rose
                   resultPrice += 900;
                   break;
                case 5 : // soda
                   resultPrice += 1000;
                   break;
                case 6 : // strawberry
                   resultPrice += 1000;
                   break;
             }
              break;
          }
      }
   }
   var deco = document.getElementById("deco");
   if (form.deco.value == "")
      resultPrice += 0;
   else{
      for(i=0; i<form.deco.options.length; i++) {
          if(form.deco.options[i].selected == true) {
             switch (i){
                case 1 : // biz
                   resultPrice += 1000;
                   break;
                case 2 : // foam
                   resultPrice += 400;
                   break;
                case 3 ://glitter
                   resultPrice += 700;
                   break;
                case 4 : // snowpowder
                   resultPrice += 800;
                   break;
                case 5 : // sponge
                   resultPrice += 500;
                   break;
             }
              break;
          }
      }
   }
   var glue = document.getElementById("glue");
   if (form.glue.value == "")
      resultPrice += 0;
   else{
      for(i=0; i<form.glue.options.length; i++) {
          if(form.glue.options[i].selected == true) {
             switch (i){
                case 1 : // amos
                   resultPrice += 5000;
                   break;
                case 2 : // clear glue
                   resultPrice += 5400;
                   break;
                case 3 :// glue-all
                   resultPrice += 6300;
                   break;
                case 4 : // school glue
                   resultPrice += 6000;
                   break;
                case 5 : // wood glue
                   resultPrice += 6600;
                   break;
             }
              break;
          }
      }
   }
   document.getElementById("Price").value = resultPrice;
}
function getCount(){
   document.getElementById("totalPrice").value = form.count.value * document.getElementById("Price").value;
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
<title>DIY 주문</title>
</head>
<body>
   <section name="content" align="center" width="80%">
      <form name="form" method="POST" action="<c:url value='/view/item/diyBasket'/>" class="list">
         <table align="center">
            <tr>
               <td>
                  <table>
                     <tr>
                        <td>Slime Color</td>
                        <td>
                           <select id="color" name="color" onChange="DiyPrice();getCount();">
                              <option value="">--선택--</option>
                              <c:forEach var="color" items="${colorList}">
                                 <option value="${color.colorType}">${color.colorType}</option>
                              </c:forEach>
                           </select>
                        </td>
                     </tr>
                     <tr>
                        <td>Slime Deco</td>
                        <td>
                           <select name="deco" onChange="DiyPrice();getCount();">
                              <option value="">-----선택-----</option>
                              <c:forEach var="deco" items="${decoList}">
                                 <option value="${deco.decoType}">${deco.decoType}</option>
                              </c:forEach>
                           </select>
                        </td>
                     </tr>
                     <tr>
                        <td>Slime Scent</td>
                        <td>
                           <select name="scent" onChange="DiyPrice();getCount();">
                              <option value="">----선택----</option>
                              <c:forEach var="scent" items="${scentList}">
                                 <option value="${scent.scentType}">${scent.scentType}</option>
                              </c:forEach>
                           </select>
                        </td>
                     </tr>
                     <tr>
                        <td>Slime Glue</td>
                        <td>
                           <select name="glue" onChange="DiyPrice();getCount();">
                              <option value="">----선택----</option>
                              <c:forEach var="glue" items="${glueList}">
                                 <option value="${glue.glueType}">${glue.glueType}</option>
                              </c:forEach>
                           </select>
                        </td>
                     </tr>
                  </table>
               </td>
            </tr>
            <tr>
               <table align="center">
                  <tr>
                     <td>이름</td>
                     <td><input type="text" name="diy_name"></td>
                  </tr>
                  <tr>
                     <td>판매가</td>
                     <td>
                        <input type="text" id="Price" name="Price" width="100" value="0">
                     </td>
                  </tr>
                  <tr>
                     <td>수량</td>
                     <td>
                        <input type="number" name="count" step="1" value="0" min="0" onChange="getCount()">
                     </td>
                  </tr>
                  <tr>
                     <td>배송방법</td>
                     <td>택배</td>
                  </tr>
                  <tr>
                     <td>배송비</td>
                     <td>3000원(40,000원 이상 구매 시 무료)</td>
                  </tr>
                  <tr>
                     <td>총금액</td>
                     <td>
                        <input type="text" id="totalPrice" name="totalPrice" width="100">
                     </td>
                  </tr>
               </table>
            </tr>
            <tr>
               <td>
                  <table style="width: 100%">
                     <tr align="center">
                        <td>
                           <input type="button" value="장바구니" onClick="createBasket()"> &nbsp; 
                           <input type="button" value="취소" onClick="comeBack('<c:url value='/view/item/list'/>')">
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