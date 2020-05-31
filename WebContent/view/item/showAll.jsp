<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/view/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>slime_home</title>
<body link="black" vlink="black" alink="black">
<table align = "center" width = "70%">
<tr>
        <c:set var="i" value="1" />
      <c:forEach var="item" items="${itemList}">       
         <td>
            <table align = "center">
               <tr><td width="120" height="120"><img src = "<c:url value = '/images/' />${i}.jpg" width = "90%" height = "90%"></td></tr>
               <tr><td width="120" height = "50">
                   <a class = "list" href="<c:url value='/view/item/detail'>
                     <c:param name="item_name" value='${item.slimename}'/>
                    </c:url>">
                    ${item.slimename}</a> 
                 </td></tr>
             </table> 
          </td>
            <c:if test="${i%3==0}"> 
               </tr><tr>
            </c:if>
            <c:set var="i" value="${i=i+1}" /> 
         </c:forEach>
</table>  
<%@include file = "/view/footer.jsp"%>
</body>
</html>