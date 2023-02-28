package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDbCClientMySQL {
	
	public static void main(String[] args) throws Exception {
		//MySQL 접속을 위한  jdbc 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//MySQL Database 연결 객체 생성
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/musthave", "musthave","tiger");
		
		//질의을 위한 객체 생성 변수 없이 날릴때
		Statement st = con.createStatement();
		
		//SQL 질의
		ResultSet rs = st.executeQuery("select Name,continent,Population,HeadOfState from country");
		
		//질의 결과 Parsing
		while (rs.next()) { // 다음 결과 레코드로 이동 cursor Processing
			// 처음에 빈곳을 가르키다가 rs.next()호출하면 첫번째부터 하나씩 리모트값을 출력  
			
			for(int i = 1; i <=4;i++) {
				if(i !=1) System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		// 생성된 객체 연결을 모두 해체
		rs.close();
		st.close();
		con.close();
	}

}
