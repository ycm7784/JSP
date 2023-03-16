<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int dan = Integer.parseInt(request.getParameter("dan"));
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
<h2><%= dan %>단을 출력합니다.</h2>
<%	for(int i = 1;i <= 9;i++){ %>
		<%= dan %> * <%= i %> = <%= dan * i %><br/>
<%	} %>

</body>
</html>