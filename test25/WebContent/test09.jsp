<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스코프 데이터 추적하기</title>
</head>
<body>
	<h2>스코프 데이터 추적하기</h2>
	<%
	String msg=request.getParameter("msg");
	String pageData = (String) pageContext.getAttribute("pageData");
	String reqData = (String) request.getAttribute("reqeData");
	String sesData = (String) session.getAttribute("sesData");
	String appData = (String) application.getAttribute("appData");
	%>
	<div>
		<p>msg(request on) : <%=msg %></p>
		<p>pageData(pageContext) : <%=pageData %></p>
		<p>reqData(request off) : <%=reqData %></p> //전송된 데이터가 아니기 때문에 null
		<p>sesData(session) : <%=sesData %></p>
		<p>appData(application) : <%=appData %></p>
		<%
			session.invalidate(); // 싹 날려버려, 세션 종료 > 로그아웃	
		  //sesData = (String) session.getAttribute("sesData"); // 위에서 날려버린걸 다시 불러와서 null오류
		%>
		  	<p>세션 종료 후 </p>
		<p>sesData(session) : <%=sesData %></p>
		<p>appData(application) : <%=appData %></p>
		<p>web.xml 전역 변수 : <%=application.getInitParameter("admin") %></p>
	</div>
	<hr>
	<div>
		<a href="index.jsp">홈으로</a>
		<a href="test06.jsp">테스트 06페이지</a>
	</div>

</body>
</html>