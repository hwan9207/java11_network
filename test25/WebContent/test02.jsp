<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%//request.getParameter() 메서드는 클라이언트가 전송한 HTTP요청의 매개변수를 가져오는데 사용
//이 메서드는 일반적으로 HTML form요소의 값이나 URL 쿼리 매개변수의 값을 가져올 때 사용된다.
	request.setCharacterEncoding("UTF-8"); //한글 깨지는거 방지
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	int point = Integer.parseInt(request.getParameter("point"));
	//겟 방식은 URL 주소에 내용이 다 보임 엽서..
%>
<h2>요청된 데이터</h2>
<%
	String hak = "";
	if(point>=90){
		hak = "A";
	}else if(point>=80){
		hak = "B";
	}else if(point>=70){
		hak = "C";
	}else if(point>=60){
		hak = "D";
	}
%>
<ul>
	<li><strong>이름</strong> : <span><%=name %></span></li>
	<li><strong>나이</strong> : <span><%=age %></span></li>
	<li><strong>점수</strong> : <span><%=point %></span></li>
	<li><strong>학점</strong> : <span><%=hak %></span></li>
</ul>
</body>
</html>