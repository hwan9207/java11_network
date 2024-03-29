<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ page import="org.kh.dto.Member" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어의 비교문장</title>
</head>
<body>
<c:set scope="application" var="num3" value="30" />
<%
	pageContext.setAttribute("num1", 9);
	pageContext.setAttribute("num2", "10");
	pageContext.setAttribute("nullStr", null); 
	pageContext.setAttribute("emptyStr", "");
	pageContext.setAttribute("lengthZero", "");
%>
<%@ include file="menu.jsp" %>
<hr>
<h2>표현언어의 비교문장</h2>
<div>
	<c:if test="${sid.equals('admin') }">
		<p>관리자 로그인 중 </p>
	</c:if>	
	<c:if test="${not equals sid }">
		<p>${sid } 님이 로그인 중입니다.</p>
	</c:if>	
	<c:if test="${empty sid }">
		<p>현재 로그인중이 아닙니다.</p>
	</c:if>	
</div>
<div>

</div>
</body>
</html>