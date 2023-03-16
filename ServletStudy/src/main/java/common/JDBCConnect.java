package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;


public class JDBCConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	// 기본 생성자
	public JDBCConnect() {
		try {
			//jdbc 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			//db에 연결
			String url ="jdbc:mysql://localhost:3306/musthave";
			String id = "musthave";
			String pwd = "tiger";
			con = DriverManager.getConnection(url,id,pwd);
			
			System.out.println("DB 연결 성공 (기본 생성자)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * public static void main(String[] args) { JDBCConnect jdbbconnect = new
	 * JDBCConnect(); }
	 */
	// 연결 해제 (자원 반납)
	public void close() {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (psmt != null) psmt.close();
			if (con != null) con.close();
			
			System.out.println("JDBC 자원 해제");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	// 두번째 생성자
	public JDBCConnect(String driver, String url, String id, String pwd) {
		try {
			//jdbc 드라이버 로드
			Class.forName(driver);
			//db에 연결
			
			con = DriverManager.getConnection(url,id,pwd);
			
			System.out.println("DB 연결 성공 (인수 생성자 1)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//세번째 생성자
	public JDBCConnect(ServletContext application) {
		try {
			//jdbc 드라이버 로드
			String driver = application.getInitParameter("mysql");
			Class.forName(driver);
			//db에 연결
			String url = application.getInitParameter("mysqlURL");
			String id = application.getInitParameter("mysqlID");
			String pwd = application.getInitParameter("mysqlPwd");
			con = DriverManager.getConnection(url,id,pwd);
			
			System.out.println("DB 연결 성공 (인수 생성자2)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

