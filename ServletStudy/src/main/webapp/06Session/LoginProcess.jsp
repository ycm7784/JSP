<%@page import="membership.MemberDTO"%>
<%@page import="membership.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 로그인 폼으로부터 받은 아이디와 패스워드
String userId = request.getParameter("user_id");
String userPwd = request.getParameter("user_pw");

//web.xml에서 가져온 데이터베이스 연결 정보
 String MysqlDriver = application.getInitParameter("mysql");
String MysqlURL = application.getInitParameter("mysqlURL");
String MysqlId = application.getInitParameter("mysqlID");
String MysqlPwd = application.getInitParameter("mysqlPwd");

//회우너 테이블 DAO를 통해 회원 정보 DTO 획득
MemberDAO dao = new MemberDAO(MysqlDriver, MysqlURL, MysqlId, MysqlPwd);
MemberDTO memberDTO = dao.getMemberDTO(userId,userPwd);
dao.close();

//if(userId.equals("musthave")& userPwd.equals("1234")){
if(memberDTO.getId()!= null){
	//session.setAttribute("UserId", "musthave");
	//session.setAttribute("UserName", "고길동");
	session.setAttribute("UserId", memberDTO.getId());
	session.setAttribute("UserName",memberDTO.getName());
	response.sendRedirect("LoginForm.jsp");
}
else{
	request.setAttribute("LoginErrMsg", "로그인 오류입니다");
	request.getRequestDispatcher("LoginForm.jsp").forward(request, response)
;}
%>
