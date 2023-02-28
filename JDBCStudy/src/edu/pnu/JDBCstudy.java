package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCstudy {
	public static void main(String[] args) throws Exception {
		
	Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "musthave","tiger");
		
		Statement st = con.createStatement();
		
		
		ResultSet rs1 = st.executeQuery("select count(*)\r\n"
				+ "from country,countrylanguage\r\n"
				+ "where country.Code =countrylanguage.CountryCode and countrylanguage.Language ='English';");
		System.out.println("<=== rs1 Statement ===>");
		while(rs1.next()) {		
			System.out.println(rs1.getString(1));
	}
		rs1.close();
		
		ResultSet rs2 = st.executeQuery("select countrylanguage.Language\r\n"
				+ "from country,countrylanguage\r\n"
				+ "where country.Code =countrylanguage.CountryCode and country.name ='South Korea';");
		System.out.println("<=== rs2 Statement ===>");
		while(rs2.next()) {		
			System.out.println(rs2.getString(1));
	}
		rs2.close();
		
		ResultSet rs3 = st.executeQuery("select country.name ,country.Continent\r\n"
				+ "from country,countrylanguage\r\n"
				+ "where country.Code =countrylanguage.CountryCode and countrylanguage.Language ='English' and countrylanguage.IsOfficial ='T';");
		System.out.println("<=== rs3 Statement ===>");
		while(rs3.next()) {		
			for(int i = 1; i <=2;i++) {
				if(i !=1) System.out.print(",");
				System.out.print(rs3.getString(i));
			}
			System.out.println();
	}
		rs3.close();
		
		ResultSet rs4 = st.executeQuery("select COUNT(DISTINCT country.Continent)\r\n"
				+ "from country,countrylanguage\r\n"
				+ "where country.Code =countrylanguage.CountryCode and countrylanguage.Language ='English';");
		System.out.println("<===rs4 Statement ===>");
		while(rs4.next()) {		
			System.out.println(rs4.getString(1));
	}
		rs4.close();
		
		st.close();
		con.close();
	}
}
