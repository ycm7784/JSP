package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/myservlet02")
public class MyServlet02 extends HttpServlet {
	

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		System.out.println("MyServlet02");
		res.setContentType("text/plain; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("이것은 서블릿에서 출력하는 문서입니다.");
		out.println("잘 보이면 성공");
		out.close();
	}

}
