<%@page import="model.board.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="model.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardDAO dao = new BoardDAO(application); //DAO를 생성해 DB에 연결
List<BoardDTO> boardLists = dao.boardView(); //게시물 가져오기
request.setAttribute("Nboard",boardLists);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<%for (int i = 0;i < boardLists.size(); i++){ 
		pageContext.setAttribute("i", i); %>
	<tr>
		<td>${Nboard[i].num}</td>
		<td>${Nboard[i].title}</td>
		<td>${Nboard[i].content}</td>
		<td>${Nboard[i].postdate}</td>
		<td>${Nboard[i].id}</td>
		<td>${Nboard[i].visitcount}</td>
	</tr>
	<%} %>
</table>		
</body>
</html>