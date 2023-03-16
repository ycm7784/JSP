<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int col = Integer.parseInt(request.getParameter("col"));
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
<h2><%= col %>열을 출력합니다.</h2>
<%	for(int i = 2;i <= 9;i+=col){
	for(int j =1; j <= 9; j++){ 
		for(int z = 0; z < col;z++){ %>
		<%= i+z %> * <%= j %> = <%=  (i+col)*j %> &nbsp;
		<%	} %>
		<br/>
	<%	} 
	} %>

</body>
</html>