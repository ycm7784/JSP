package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCstudy2 {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musthave", "musthave","tiger");
		
		Statement st = con.createStatement();
		
		ResultSet rs1 = st.executeQuery("select num, title , content, id, postdate, visitcount from board");
		
		while(rs1.next()) {		
				System.out.println(rs1.getString(1));
		}
		rs1.close();
		
		ResultSet rs2 = st.executeQuery("select id, pass , name, regidate from member");
		
		while(rs2.next()) {		
				System.out.println(rs2.getString(1));
		}
		rs2.close();			
		
					
					
		st.close();
		con.close();
	}
	
}
