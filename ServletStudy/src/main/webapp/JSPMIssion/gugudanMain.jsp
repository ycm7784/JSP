<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>

	<%
	String type = request.getParameter("type");
	String val = request.getParameter("val");
	if(type.equalsIgnoreCase("dan")){
		response.sendRedirect("gugudan1.jsp?dan="+val);
	}
	else{
		response.sendRedirect("gugudan2.jsp?col="+val);
	}
	%>

</body>
</html>