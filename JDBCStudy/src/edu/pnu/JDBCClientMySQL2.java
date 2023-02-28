package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCClientMySQL2 {


	public int printColumnName(ResultSet rs) throws Exception {
		ResultSetMetaData meta = rs.getMetaData();
		int count = meta.getColumnCount();
		
		StringBuilder sb = new StringBuilder("#");
		for (int i = 1 ; i <= count ; i++) {
			sb.append("," + meta.getColumnName(i));
		}
		System.out.println(sb);
		System.out.println("-".repeat(sb.length()));
		
		return count;
	}
	
	public void StudyStatement(Connection con) throws Exception {
		//질의을 위한 객체 생성 Statement 변수 없이 날릴때
		Statement st = con.createStatement();
		// sql 질의
		ResultSet rs = st.executeQuery("select * from country limit 10");
		// printColumnName 함수 호출	
		int colCount = printColumnName(rs);
		int rowCount = 1;
		while(rs.next()) {
			for(int i = 1 ; i <= colCount ; i++) {
				if (i == 1)	System.out.print((rowCount++) + ",");
				else		System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}

	public void StudyPrepareStatement(Connection con) throws Exception {
		// PreparedStatement 변수가 있을때 문자열을 만들때 
		PreparedStatement st = con.prepareStatement("select * from country where code=?");
		// "KOR" 넣어주는메소드
		st.setString(1, "KOR");
		ResultSet rs = st.executeQuery();

		int colCount = printColumnName(rs);
		int rowCount = 1;
		while(rs.next()) {
			for(int i = 1 ; i <= colCount ; i++) {
				if (i == 1)	System.out.print((rowCount++) + ",");
				else		System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}	
	
	public static void main(String[] args) throws Exception  {

		JDBCClientMySQL2 cli = new JDBCClientMySQL2();
		// MySQL 접속을 위한 jdbc 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		//MySQL Database 연결 객체 생성
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "musthave", "tiger");) {
			
			System.out.println("<=== StudyStatement ===>");
			// StudyStatement 메소드 호출
			cli.StudyStatement(con);
			System.out.println();

			System.out.println("<=== StudyPrepareStatement ===>");
			cli.StudyPrepareStatement(con);
		}		
	}
}
