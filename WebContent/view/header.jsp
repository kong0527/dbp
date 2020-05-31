<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet href="<c:url value='/css/user.css' />"type="text/css">
<header align="center">
	<a href="<c:url value='/view/item/list' />"><img alt=""
		src="<c:url value='/images/slime_home.png' />" width="30%"
		height="30%"></a>
</header>
</head>
	<nav>
		<ul align="center">
			<li><a href="<c:url value='/view/item/list' />" class="list">total_slime</a></li>
			<li><a href="<c:url value='/view/item/diy' />" class="list">diy_slime</a></li>
			<li><a href="<c:url value='/view/board/list' />" class="list">board</a></li>
			<li><a href="<c:url value='/view/item/basket' />" class="list">basket</a></li>
			<c:if test="${empty sessionScope.user}">
				<li><a href=" <c:url value='/view/user/login/form' />" class="list">login</a></li></c:if>
			<c:if test="${!empty sessionScope.user}"><li>
			<a href="<c:url value='/user/logout' />" class = "list" class="list">logout(&nbsp;${sessionScope.user}&nbsp;)</a></li></c:if>
			<li><a href="<c:url value='/view/user/myPage' />" class="list">myPage</a></li>
		</ul>
	</nav>
</html>