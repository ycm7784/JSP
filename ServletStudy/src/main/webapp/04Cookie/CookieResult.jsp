<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>CookieResult.jsp</title>
</head>
<body>
<h2> 쿠키값확인하기 </h2>
<%
	Cookie[] cookies = request.getCookies();
	if(cookies !=null){
		for(int i =0; i< cookies.length;i++){
			String cookieName = cookies[i].getName();
			String cookieValue = cookies[i].getValue();
			out.println(String.format("쿠키명 : %s - 쿠키값 : %s<br/>", cookieName, cookieValue));
		}
	}
%>
</body>
</html>