<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
<form action = "gugudanMain.jsp" method = "post">
	<input type="radio"  name ="type" value="dan"/>Type1
	<input type="radio" name ="type" value="col"/>Type2</br>
	<input type="text"  name ="val" value=""/>단수/열수</br>
	<input type = "submit" value = "선택"/>
</form>
</body>
</html>