<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page import ="common.JDBCConnect" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<h2>world 테이블 생성</h2>
<%
	String driver = application.getInitParameter("mysql");
	String url = application.getInitParameter("mysqlURL");
	String id = application.getInitParameter("mysqlID");
	String pwd = application.getInitParameter("mysqlPwd");
	
	JDBCConnect jdbc = new JDBCConnect(driver,url, id , pwd);
	
	//쿼리문 생성
	String sql = "SELECT ID , Name, CountryCode ,District , Population FROM city";
	Statement stmt = jdbc.con.createStatement();
	
	// 퀴리 생성
	ResultSet rs = stmt.executeQuery(sql);
	%> <table class = "table table-striped-columns" > 
	<% 
	while(rs.next()){
		String wid = rs.getString("ID");
		String name = rs.getString("Name");
		String CountryCode = rs.getString("CountryCode");
		String District = rs.getString("District");
		String Population = rs.getString("Population");
	%>
		<tr>
			<td><%= wid%></td>
			<td><%= name%></td>
			<td><%= CountryCode%></td>
			<td><%= District%></td>
			<td><%= Population%></td><br>
		</tr>

	<% 
	
		
	}
	%>
	</table>
	<% 
	
	jdbc.close();	
	%>
</body>
</html>