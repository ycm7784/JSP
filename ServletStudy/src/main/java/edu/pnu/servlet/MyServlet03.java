package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet03")
public class MyServlet03 extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		System.out.println("MyServlet03");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h2>이것은 서블릿에서 출력하는 문서입니다.</h2>");
		out.println("<h3>잘 보이면 성공</h3>");
		out.close();
	}

}
